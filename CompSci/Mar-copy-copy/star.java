import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class star extends powerUps
{
    /**
     * Act - do whatever the star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int frame=0;
    public void act()
    {
        if(isTouching(Mario.class)){
            Mario.starred=true;
            Mario.score+=200;
            getWorld().removeObject(this);
        }
        anim();
    }
    
    private void anim(){
        frame=(frame<41)?frame+1:0;
        switch(frame/10){
            case 0:
                setImage(new GreenfootImage("powerup_star1.png"));
                break;
            case 1:
                setImage(new GreenfootImage("powerup_star2.png"));
                break;
            case 2:
                setImage(new GreenfootImage("powerup_star3.png"));
                break;
            case 3:
                setImage(new GreenfootImage("powerup_star4.png"));
                break;
        }
    }
}
