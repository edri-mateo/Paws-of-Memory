import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Screen2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Screen2 extends Actor
{
    private int iter = 0;
    
    /**
     * Constructor for objects of class
     * Screen2.
     * Scales image, sets trasnparency, and sets image to a black screen. 
     */
    public Screen2()
    {
        setImage("blackscreen.png");
        getImage().scale(900,400);
    }
    
    /**
     * Act - do whatever the Screen2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        introScreen();
    }
    
    /**
     * Method introScreen
     * Sets image to a clear screen at 850 iterations.
     */
    public void introScreen()
    {
        iter++;
        {
            if(iter == 850)
            {
                setImage("clearscreen.png");
            }
        }
    }
}
