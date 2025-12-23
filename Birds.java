import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Birds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Birds extends Actor
{
    private GreenfootImage[] birdsFly = new GreenfootImage[4];
    private int currentImage = 0;
    private int delay = 0;
    private int speed;
    private static final int SPEED = 5;
    
    /**
     * Constructor for objects of class
     * Birds.
     * Contains for loops for animating. 
     * Sets speeds at which birds move randomly.
     */
    public Birds()
    {
         speed = Greenfoot.getRandomNumber(4) + 6;
         for( int i=0; i<birdsFly.length; i++)
         {
            birdsFly[i] = new GreenfootImage("bird"+(i+1)+".png");
            birdsFly[i].scale(100, 50);
         }
         setImage(birdsFly[0]);
    }
        
    /**
     * Act - do whatever the Birds wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(-speed);
        moveBirds();
    }    
    
    /**
     * Method moveBirds
     * Sets speed and images for moving birds animation.
     */
    public void moveBirds()
    {
        delay = delay + 1;
        if(delay == SPEED)
        {
            if(currentImage < 5)
            {
                currentImage = currentImage + 1;
            }
            if(currentImage >= birdsFly.length)
            {
                currentImage = 0;
            }
            setImage(birdsFly[currentImage]);
            delay = 0;
        }
    }
}
