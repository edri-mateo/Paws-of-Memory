import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cat extends Actor
{
    private GreenfootImage[] catArrival = new GreenfootImage[18];
    private GreenfootImage[] catWalk = new GreenfootImage[16];
    private GreenfootImage[] catJump = new GreenfootImage[1];
    
    private int currentImage1 = 0;
    private int currentImage2 = 0;
    private boolean isDie = false;
    
    private int points = 0;
    
    private int delay1 = 0;
    private int delay2 = 0;   
    
    private static final int SPEED = 5;
    private int iter = 0;
    
    private int vSpeed = 0;
    private int acceleration = 1;
    private int jumpStrength = 12;
    
    /**
     * Constructor for objects of class
     * Cat.
     * Contains for loops for animating. 
     */
    public Cat()
    {
        for(int i=0; i<catArrival.length; i++)
        {
            catArrival[i] = new GreenfootImage("arrival0"+(i+1)+".png");
            catArrival[i].scale(200, 150);
        }
        setImage(catArrival[0]);
        
        for(int i=0; i<catWalk.length; i++)
        {
            catWalk[i] = new GreenfootImage("walk0"+(i+1)+".png");
            catWalk[i].scale(125,85);
        }
        
        for(int i=0; i<catJump.length; i++)
        {
            catJump[i] = new GreenfootImage("jump0"+(i+1)+".png");
            catJump[i].scale(125,85);     
        }
    }
    
    /**
     * Act - do whatever the Cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        arrival();
        walk();
        jump();
        checkFall();
        
        if(getY() < 0) //stops him from jumping off the screen
        {
            setLocation(getX(), 0);
            if(getY() == 0) 
            {
                MyWorld m = (MyWorld)getWorld();
                m.died = true;
            }
        }
        
        if(isTouching(Health.class))
        {
            removeTouching(Health.class);
            MyWorld m = (MyWorld)getWorld();
            Greenfoot.playSound("heal.wav");
            m.touchHealth = true;
        }
        
        if(isTouching(Orbs.class))
        {
            Greenfoot.playSound("orb.mp3");
            MyWorld m = (MyWorld)getWorld();
            points++;
            m.showText("Memory Orbs Collected: " + points, 170,40);
            removeTouching(Orbs.class);
            if(points >= 5 && points < 8)
            {
                m.showText("My memory is still fuzzy, I have to remember more...", 400, 330);
            }
            else if(points >= 8 && points < 10)
            {
                m.showText("", 400, 330);
            }
            else if(points >= 10 && points < 13)
            {
                m.showText("I think it's coming back to me now...", 400, 330);
            }
            else if(points >= 13 && points < 15)
            {
                m.showText("", 400, 330);
            }
            else if(points >= 15 && points < 18)
            {
                m.showText("I've been this way before... I'm close", 400, 330);
            }
            else if(points >= 18 && points < 20)
            {
                m.showText("", 400, 330);
            }
            else if(points == 20)
            {
                m.showText("This is the way... Im home!", 400, 330);
                m.win = true;            
            }
        }
        
        if(isTouching(Death.class))
        {
            setLocation(getX(), getY() + 5);
            if(getY() > 369) 
            {
                MyWorld m = (MyWorld)getWorld();
                m.showText("Memory Orbs Collected: 0", 170,40);
                Greenfoot.playSound("cat.mp3");
                Greenfoot.playSound("die.mp3");
                m.ifDie = true;
                m.touchDie = true;
                getWorld().removeObject(this);
            }
        }
    }  
    
    /**
     * Method arrival
     * Sets speed and images for the arrival animation.
     */
    public void arrival()
    {
        delay1++;
        if(delay1 == SPEED)
        {
            if(currentImage1 < 19)
            {
                currentImage1 = currentImage1 + 1;
            }
            if(currentImage1 >= catArrival.length)
            {
                currentImage1 = 17;
            }
            setImage(catArrival[currentImage1]);
            delay1 = 0;
        }
    }
    
    /**
     * Method walk
     * Sets speed and images for walking animation.
     */
    public void walk()
    {
        delay2++;
        iter++;
        if(delay2 == SPEED)
        {
            if(iter >= 60)
            {
                if(currentImage2 < 17)
                {
                        currentImage2 = currentImage2 + 1;
                }
                if(currentImage2 >= catWalk.length)
                {
                        currentImage2 = 0;
                }
                setImage(catWalk[currentImage2]);
            }
            delay2 = 0;
        }
    }
    
    /**
     * Method jump
     * Sets speed, key, and image for when Cat jumps.
     * Doesn't let Cat jump while arrival animation is taking place.
     */
    public void jump()
    {
        if(isDie = false)
        {
            if(iter >= 550)
            {
                if(Greenfoot.isKeyDown("space"))
                {
                    vSpeed = -8;
                    fall();
                    setImage(catJump[0]);
                }
            }
        }
        else
        {
            if(iter >= 60)
            {
                if(Greenfoot.isKeyDown("space"))
                {
                    vSpeed = -8;
                    fall();
                    setImage(catJump[0]);
                }
            }
        }
    }
    
    /**
     * Method fall
     * Sets speed for Cat fall.
     */
    public void fall()
    {
        setLocation( getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    
    /**
     * Method checkFall
     * Checks if Cat is falling.
     */
    public void checkFall()
    {
        if(isTouching(Ground.class))
        {
            vSpeed = 0;
        }
        else
        {
            fall();
        }
    }
    
    /**
     * Method onGround
     * Checks that Cat is on ground.
     */
    public boolean onGround()
    {
        Actor under = getOneObjectAtOffset( 0, getImage().getHeight()/2, Ground.class);
        return under == null;
    }
}
