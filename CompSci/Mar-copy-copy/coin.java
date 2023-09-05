import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class coin extends powerUps
{
    /**
     * Act - do whatever the coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int frame=0;
    public void act()
    {
        if(isTouching(Mario.class)){
            Mario.score+=200;
            Mario.coins++;
            getWorld().removeObject(this);
        }
        anim();
    }

    private void anim(){
        frame=(frame<31)?frame+1:0;
        switch(frame/10){
            case 0:
                setImage(new GreenfootImage("obstacle_coin1.png"));
                break;
            case 1:
                setImage(new GreenfootImage("obstacle_coin2.png"));
                break;
            case 2:
                setImage(new GreenfootImage("obstacle_coin3.png"));
                break;
        }
    }
}
