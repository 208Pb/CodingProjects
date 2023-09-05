import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block1 extends Obstacle
{
    /**
     * Act - do whatever the Block1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    @Override
    public void addedToWorld(World world){
        int x = getX();
        int y= getY();
        int w= getImage().getWidth();
        int h=getImage().getHeight();
        setLocation(x+w/2-x%w, y+h/2-y%h);
    }
}
