import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoseScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseScreen extends World
{

    /**
     * Constructor for objects of class LoseScreen.
     * 
     */
    public LoseScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 900, 1, false); 
        Greenfoot.playSound("smb_gameover.wav");
        GreenfootImage image = getBackground();
        image.setColor(new Color(0,0,0, 255));
        
        image.setFont(new Font("Arial", false, false, 150));
        image.drawString("You lose", 500, 300);
        
        image.setFont(new Font("Arial", false, false, 50));
        image.drawString("You ran out of lives", 650, 400);
        
        image.setFont(new Font("Arial", false, false, 100));
        image.drawString("Score: "+scoreDisplay.score, 300, 600);
        
    }
}
