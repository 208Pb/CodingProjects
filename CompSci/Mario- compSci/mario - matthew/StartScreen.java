import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 900, 1, false); 
        GreenfootImage image = getBackground();
        image.setColor(new Color(0,0,0, 255));

        image.setFont(new Font("Arial", false, false, 150));
        image.drawString("Mario", 600, 300);

        image.setFont(new Font("Arial", false, false, 100));
        image.drawString("Press Space to Play", 300, 600);
        
   
    }

    public void act(){
        if(Greenfoot.isKeyDown("SPACE")){
            livesDisplay.lives=3;
            Greenfoot.setWorld(new Level1());
        }
    }
}
