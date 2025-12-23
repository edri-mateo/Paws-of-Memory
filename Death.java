import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Death here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Death extends Actor
{
    private int iter = 0;
    
    /**
     * Constructor for objects of class
     * Death.
     * Scales image. 
     */
    public Death()
    {
        getImage().scale(25,25);
    }
    
    /**
     * Act - do whatever the Death wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        iter++;
        if(iter >= 1400)
        {
            move(-5);
            if(getX() <= -500)
            {
                setLocation(1300, 315);
            }
        }
    }
}
