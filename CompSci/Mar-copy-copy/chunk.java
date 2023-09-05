import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class chunk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class chunk extends breakable
{
    /**
     * Act - do whatever the chunk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int xSpeed;
    int ySpeed;
    int spin;
    public chunk(int x, int y,int rotation){
        xSpeed=x;
        ySpeed=y;
        spin=rotation;
        getImage().scale(10,10);
    }
    public void act()
    {
        setLocation(getX()+xSpeed,getY()+ySpeed);
        setRotation(getRotation()+spin);
        ySpeed++;
        if(getY()>950) getWorld().removeObject(this);
        // Add your action code here.
    }
}
