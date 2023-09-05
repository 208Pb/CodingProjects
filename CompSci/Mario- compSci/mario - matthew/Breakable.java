import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Breakable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Breakable extends Obstacle
{
    public boolean breaky=false;
    /**
     * Act - do whatever the Breakable wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(breaky){System.out.println("I breaky");}
    }    
}
