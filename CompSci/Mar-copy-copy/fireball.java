import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class fireball extends flower
{
    /**
     * Act - do whatever the fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        anim();
    }
    
    private void anim(){
        frame=(frame<40)?frame+1:0;
        switch(frame/10){
            case 0:
                setImage(new GreenfootImage("powerup_fireball1.png"));
                break;
            case 1:
                setImage(new GreenfootImage("powerup_fireball2.png"));
                break;
            case 2:
                setImage(new GreenfootImage("powerup_fireball3.png"));
                break;
            case 3:
                setImage(new GreenfootImage("powerup_fireball4.png"));
                break;
        }
    }
}
