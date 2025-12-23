import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Actor
{
    private int iter = 0;
    
    /**
     * Constructor for objects of class
     * Background.
     * Scales image. 
     */
    public Background()
    {
        getImage().scale(900,405);
    } 

    /**
     * Act - do whatever the Background2 wants to do. This method is called whenever
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
                setLocation(1300, getY());
            }
        }
    }    
}
