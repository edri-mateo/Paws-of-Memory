import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeartBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeartBar extends Actor
{
    /**
     * Constructor for objects of class
     * HeartBar.
     * Contains different images for HeartBar. 
     */
    public HeartBar(int lives)
    {
        if( lives == 6)
        {
            setImage("life1.png");
            getImage().scale(150, 40);
        }
        else if( lives == 5)
        {
            setImage("life2.png");
            getImage().scale(150, 40);
        }
        else if( lives == 4)
        {
            setImage("life3.png");
            getImage().scale(150, 40);
        }
        else if( lives == 3)
        {
            setImage("life4.png");
            getImage().scale(150, 40);
        }
        else if( lives == 2)
        {
            setImage("life5.png");
            getImage().scale(150, 40);
        }
        else
        {
            setImage("life6.png");
            getImage().scale(150, 40);
        }
    }
    
    /**
     * Act - do whatever the HeartBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
