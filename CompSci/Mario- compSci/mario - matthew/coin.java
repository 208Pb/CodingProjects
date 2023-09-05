import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class coin extends Actor
{
    int anim=0;
    /**
     * Act - do whatever the coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(anim<=1){setImage("obstacle_coin1.png");}
        if(anim>10&&anim<=20){setImage("obstacle_coin2.png");}
        if(anim>30&&anim<=40){setImage("obstacle_coin3.png");}
        if(anim>40&&anim<=50){setImage("obstacle_coin2.png");}
        if(anim>=50){anim=0;}
        anim++;
        if(isTouching(Mario.class)){
            coinsDisplay.coins++;
            scoreDisplay.score+=200;
            getWorld().removeObject(this);
        }
    }    
}
