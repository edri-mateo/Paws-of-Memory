import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Screen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Screen extends Actor
{
    private int transparent;
    private int iter = 0;
    
    /**
     * Constructor for objects of class
     * Screen.
     * Scales image and sets trasnparency. 
     */
    public Screen()
    {
        getImage().scale(900,400);
        transparent = 255;
    }
    
    /**
     * Act - do whatever the Screen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        //titleScreen();
        getImage().setTransparency(transparent);
        transparent = transparent - 5;
        if(transparent <= 0)
        {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Method titleScreen
     * Shows screen at 850 iterations.
     */
    public void titleScreen()
    {
        iter++;
        if(iter == 850)
        {
            iter = 0;
        }
    }
}
