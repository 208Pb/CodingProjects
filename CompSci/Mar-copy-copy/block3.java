import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class block3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class block3 extends breakable
{
    /**
     * Act - do whatever the itemBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean touched = false;
    boolean jumped  = false;
    String alter;
    int anim = 0;
    int jumpAnim = 20;
    String itemType;
    int gridX;
    int gridY;

    public void act()
    {
        collisions();
        jump();
    }

    private void collisions(){
        int w = getImage().getWidth();
        int h = getImage().getHeight();

        Actor BL = getOneObjectAtOffset(-w/4,h/2,Mario.class);
        Actor BR = getOneObjectAtOffset( w/4,h/2,Mario.class);

        if(BL!=null||BR!=null) touched=true;
    }

    private void jump(){
        if(!jumped&&touched){
            if(jumpAnim>0){
                if(jumpAnim>10)  setLocation(getX(), getY()-1);
                if(jumpAnim==10) {jumped=true; shatter(); getWorld().removeObject(this);}
                jumpAnim--;
            }
        }
    }
    
    private void shatter(){
        getWorld().addObject(new killScore(50),getX(),getY());
        Mario.score+=50;
        getWorld().addObject(new chunk( 5, -5, 5),getX(),getY());
        getWorld().addObject(new chunk( 5,-10, 5),getX(),getY());
        getWorld().addObject(new chunk(-5, -5,-5),getX(),getY());
        getWorld().addObject(new chunk(-5,-10,-5),getX(),getY());
    }
}