import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends World
{

    /**
     * Constructor for objects of class WinScreen.
     * 
     */
    public WinScreen()
    {    
        super(1600, 900, 1, false); 
        GreenfootImage image = getBackground();
        image.setColor(new Color(0,0,0, 255));
        
        image.setFont(new Font("Arial", false, false, 150));
        image.drawString("You win", 500, 300);
        
        image.setFont(new Font("Arial", false, false, 50));
        image.drawString("You found the princess", 650, 400);
        
        image.setFont(new Font("Arial", false, false, 100));
        image.drawString("Score: "+scoreDisplay.score, 300, 600);
    }
}
