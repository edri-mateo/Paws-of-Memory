import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int iter1 = 0;
    private int iter2 = 0;
    private int iter3 = 0;
    private int iter4 = 0;
    private int iter5 = 0;
    private int iter6 = 0;
    private int iter7 = 0;
    
    private int lives = 6;
    public boolean ifDie = false;
    public boolean touchDie = false;
    public boolean touchHealth = false;
    public boolean died = false;
    public boolean win = false;
    
    /**
     * Constructor for objects of class
     * MyWorld.
     * Prepares the world before runned. 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1, false); 
        setPaintOrder(Screen2.class, Screen.class, HeartBar.class, Health.class, Orbs.class, Cat.class, Birds.class, Broken.class, Background.class, Ground.class, Death.class);
        
        addObject( new Screen2(), 400,200);
        
        addObject( new Background(), 200, 200);
        addObject( new Background(), 1100, 200); 
        
        addObject( new Broken(), 1100, 330);
        addObject( new Broken(), 1900, 329);
        addObject( new Death(), 1100, 315);
        addObject( new Death(), 1100, 325);
        addObject( new Death(), 1900, 315);
        addObject( new Death(), 1900, 325);
        
        addObject( new Ground(), 50, 320);
        addObject( new Ground(), 220, 320);
    }
    
     /**
     * Act - Calls other methods in world class. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        addCat();
        addText();
        addScreen();
        addBirds();
        ifDie();
        addOrbs();
        addBar();
        dieScreen();
        winText();
        sound();
        addHealth();
    }
    
    /**
     * Method addCat
     * Adds the starting Cat at 1330 iterations.
     */
    public void addCat()
    {
        iter1++;
        if(iter1 == 1330)
        {
            addObject( new Cat(), 100, 200);
        }
    }
    
    /**
     * Method addScreen
     * Adds the fading screen at 850 iterations.
     */
    public void addScreen()
    {
        iter2++;
        if(iter2 == 850)
        {
            addObject( new Screen(), 400, 200);
        }
    }
    
    /**
     * Method addText
     * Adds the Introduction Text, INSTRUCTIONS text, and beginning "Memory Orbs Collcted" text. 
     */
    public void addText()
    {
        iter3++;
        if(iter3 == 1)
        {
            Greenfoot.playSound("rain2.mp3");
        }
        if(iter3 == 100)
        {
            showText("During a storm, you get washed away from home...", 400,180);
            showText("Cold, lost, and confused, you stand shivering and", 400,200);
            showText("unaware of your surroundings. You just know that", 400,220); 
            showText("you need to get home...", 400,240);
        }
        if(iter3 == 600)
        {
            showText("", 400,180);
            showText("", 400,200);
            showText("", 400,220);
            showText("", 400,240);
        }
        if(iter3 == 650)
        {
            showText("... But where exactly is home?", 400,210);
        } 
        if(iter3 == 800)
        {
            showText("", 400,210);
        } 
        if(iter3 == 950)
        {
            showText("INSTRUCTIONS", 400,70);
            showText("Collect memory orbs to remember the way home", 400,115);
            showText("Avoid missing roof tiles, falling will get you injured", 400,140);
            showText("and make you forget your memories", 400,165);
            showText("Jumping too high will result in losing your life", 400,190);
            showText("... You won't land on your feet ...", 400,240);
        } 
        if(iter3 == 1310)
        {
            showText("", 400,70);
            showText("", 400,115);
            showText("", 400,140);
            showText("", 400,165);
            showText("", 400,190);
            showText("", 400,240);
        } 
        if(iter3 == 1400)
        {
            showText("Memory Orbs Collected: 0", 170,40);
        }
    }
    
    /**
     * Method addBirds
     * Can add Birds randomly at 1400 iterations and up.
     */
    public void addBirds()
    {
        int y = Greenfoot.getRandomNumber(140);
        iter4++;
        if(iter4 >= 1400)
        {
            if(Greenfoot.getRandomNumber(500)<1)
            {
                addObject(new Birds(), 1100, y);
            }
        }
    }
    
    /**
     * Method addHealth
     * Can add First Aid Kits at 1400 iterations and up and if lives < 6.
     */
    public void addHealth()
    {
        int y = Greenfoot.getRandomNumber(200);
        if(lives < 6)
        {
            if(iter4 >= 1400)
            {
                if(Greenfoot.getRandomNumber(400)<1)
                {
                    addObject(new Health(), 1100, y);
                }
            }
        }
    }
    
    /**
     * Method ifDie
     * Adds new Cat if the Cat falls off the screen.
     */
    public void ifDie()
    {
        if( ifDie == true)
        {
            addObject( new Cat(), 100, 180);
            ifDie = false;
        }
    }
    
    /**
     * Method addOrbs
     * Can add Orbs randomly at 1400 iterations and up.  
     */
    public void addOrbs()
    {
        int getRandom = Greenfoot.getRandomNumber(3);
        int y = Greenfoot.getRandomNumber(200);
        Orbs o = new Orbs(getRandom);
        if(iter4 >= 1400)
        {
            if(Greenfoot.getRandomNumber(200)<1)
            {
                addObject(o, 1100, y);
            }
        }
    }
    
    /**
     * Method addBar
     * Adds the starting Health Bar and edits it if the Cat falls or gets a First Aid Kit.
     */
    public void addBar()
    {
        iter5++;
        if(iter5 == 1400)
        {
            addObject( new HeartBar(6), 700, 50);
        }
        if( touchHealth == true)
        {
            lives++;
            if(lives > 6)
            {
                lives--;
                touchHealth = false; 
            }
            if(lives == 6)
            {
                addObject( new HeartBar(6), 700, 50);
                touchHealth = false;                
            }
            if(lives == 5)
            {
                addObject( new HeartBar(5), 700, 50);
                touchHealth = false;                
            }
            else if(lives == 4)
            {
                addObject( new HeartBar(4), 700, 50);
                touchHealth = false;                
            }
            else if(lives == 3)
            {
                addObject( new HeartBar(3), 700, 50);
                touchHealth = false;                
            }
            else if(lives == 2)
            {
                addObject( new HeartBar(2), 700, 50);
                touchHealth = false;                
            }
        }
        if( touchDie == true)
        {
            lives--;
            if(lives == 5)
            {
                addObject( new HeartBar(5), 700, 50);
                touchDie = false;                
            }
            else if(lives == 4)
            {
                addObject( new HeartBar(4), 700, 50);
                touchDie = false;                
            }
            else if(lives == 3)
            {
                addObject( new HeartBar(3), 700, 50);
                touchDie = false;                
            }
            else if(lives == 2)
            {
                addObject( new HeartBar(2), 700, 50);
                touchDie = false;                
            }
            else
            {
                addObject( new HeartBar(1), 700, 50);
                addObject( new Screen(), 400, 200);
                Greenfoot.playSound("die2.mp3");
                showText("YOU DIED", 400, 140);
                showText("You were too badly injured and could not make it back home...", 400,210);
                showText("", 400, 330);
                showText("", 170,40);
                touchDie = false;                
                Greenfoot.stop();
            }
        }
    }
    
    /**
     * Method dieScreen
     * Shows Death Screen if Cat jumps up too high, touching the edge.
     */
    public void dieScreen()
    {
        if(died == true)
        {
            addObject( new Screen(), 400, 200);
            Greenfoot.playSound("die2.mp3");
            showText("YOU DIED", 400, 140);
            showText("You fell from a height that you could not recover from", 400,210);
            showText("and could not make it back home...", 400,230);
            showText("", 170,40);
            showText("", 400, 330);
            Greenfoot.stop();   
        }
    }
    
    /**
     * Method winText
     * Shows Win Screen if Cat wins.
     */
    public void winText()
    {
        if(win == true)
        {
            iter6++;
            if(iter6 == 200)
            {
                showText("", 400, 330);
            }
            if(iter6 == 300)
            {
                addObject( new Screen(), 400, 200);
                Greenfoot.playSound("win.mp3");
                showText("YOU MADE IT HOME", 400, 140);
                showText("You collected all your memories and found your way home!", 400,210);
                showText("Congratulations!", 400,230);
                showText("", 170,40);
                Greenfoot.stop();
            }
        }
    }
    
    /**
     * Method sound
     * Adds Background and Cat sounds.
     */
    public void sound()
    {
        iter7++;
        if(iter3 == 800)        
        {
            Greenfoot.playSound("birds.mp3");
        }
        if(iter4 == 1330)
        {
            Greenfoot.playSound("cat.mp3");
        }
        if(iter7 == 2200)
        {
            Greenfoot.playSound("birds.mp3");
            iter7 = 0;
        }
    }
}
