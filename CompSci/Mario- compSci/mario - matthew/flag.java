import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class flag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class flag extends Actor
{
    /**
     * Act - do whatever the flag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int where=0;
    public flag(int level){
        where=level;
    }
    public void act() 
    {
        if(checkCollision()&&where==1){Greenfoot.setWorld(new Level2());}
        if(checkCollision()&&where==2){Greenfoot.setWorld(new WinScreen());}
    }    
    public boolean checkCollision(){
        return isTouching(Mario.class);
    }
}
