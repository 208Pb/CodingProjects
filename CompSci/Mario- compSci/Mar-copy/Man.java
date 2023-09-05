import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Man here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//33x61 pixels
public class Man extends Actor
{
    /**
     * Act - do whatever the Man wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       movement();
    }
    public void movement(){
        if(Greenfoot.isKeyDown("a")&&getX()>0) setLocation(getX()-10,getY());
        if(Greenfoot.isKeyDown("d")&&getX()<300) setLocation(getX()+10,getY());
    }
}
