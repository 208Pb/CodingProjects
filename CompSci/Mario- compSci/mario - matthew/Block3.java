import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block3 extends Breakable
{
    
    /**
     * Act - do whatever the Block3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Block3(){
        breaky=false;
    }
    public void act() 
    {
        if(breaky){
            getWorld().addObject(new BreakParticle(1), getX()-25, getY()+25);
            getWorld().addObject(new BreakParticle(1), getX()-25, getY()-25);
            getWorld().addObject(new BreakParticle(2), getX()+25, getY()+25);
            getWorld().addObject(new BreakParticle(2), getX()+25, getY()-25);
            getWorld().removeObject(this); 
        }
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
