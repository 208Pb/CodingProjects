import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of pope enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy extends Actor
{
    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act(){

    }

    public boolean TL(int w, int h, Class cls){
        Actor TL = getOneObjectAtOffset(-w/4,-h/2,cls);
        return TL != null;
    }

    public boolean TR(int w, int h, Class cls){
        Actor TR = getOneObjectAtOffset( w/4,-h/2,cls);
        return TR != null;
    }

    public boolean BL(int w, int h, Class cls){
        Actor BL = getOneObjectAtOffset(-w/4, h/2,cls);
        return BL != null;
    }

    public boolean BR(int w, int h, Class cls){
        Actor BR = getOneObjectAtOffset( w/4, h/2,cls);
        return BR != null;
    }

    public boolean LT(int w, int h, Class cls){
        Actor LT = getOneObjectAtOffset(-w/2,-h/4,cls);
        return LT != null;
    }

    public boolean LB(int w, int h, Class cls){
        Actor LB = getOneObjectAtOffset(-w/2, h/4,cls);
        return LB != null;
    }

    public boolean RT(int w, int h, Class cls){
        Actor RT = getOneObjectAtOffset( w/2,-h/4,cls);
        return RT != null;
    }

    public boolean RB(int w, int h, Class cls){
        Actor RB = getOneObjectAtOffset( w/2, h/4,cls);
        return RB != null;
    }
}
