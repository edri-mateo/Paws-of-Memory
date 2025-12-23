import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Orbs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orbs extends Actor
{
    /**
     * Constructor for objects of class
     * Orbs.
     * Contains different images for Orbs. 
     */
    public Orbs(int orbImages)
    {
        if(orbImages == 1)
        {
            setImage("orb1.png");
            getImage().scale(30,30);
        }
        else if(orbImages == 2)
        {
            setImage("orb2.png");
            getImage().scale(30,30);
        }
        else
        {
            setImage("orb3.png");
            getImage().scale(30,30);
        }
    }
    
    /**
     * Act - do whatever the Orbs wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        move(-5);
    }
}
