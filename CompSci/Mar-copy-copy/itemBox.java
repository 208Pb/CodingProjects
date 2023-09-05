import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class itemBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class itemBox extends breakable
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
    public itemBox(String item, String alt){
        getImage().scale(50,50);  
        itemType=item;
        alter= alt;
    }

    public void act()
    {
        collisions();
        anim();
        jump();
    }

    private void collisions(){
        int w = getImage().getWidth();
        int h = getImage().getHeight();

        Actor BL = getOneObjectAtOffset(-w/4,h/2,Mario.class);
        Actor BR = getOneObjectAtOffset( w/4,h/2,Mario.class);

        if(BL!=null||BR!=null) touched=true;
    }

    private void anim(){
        if(alter.equals("null")){
            if(anim<=10)            setImage(new GreenfootImage("obstacle_item1.png"));
            if(anim>10&&anim<=20)   setImage(new GreenfootImage("obstacle_item2.png"));
            if(anim>20&&anim<=30)   setImage(new GreenfootImage("obstacle_item3.png"));
            if(anim==31)            setImage(new GreenfootImage("obstacle_item4.png"));
            anim=(jumped)?anim=31:(anim<30)?anim+1:0;
            getImage().scale(50,50);
        }
        else{
            if(alter.equals("brick")) setImage(new GreenfootImage("obstacle_block3.png"));
            if(alter.equals("invis")) setImage(new GreenfootImage(50,50));
            if(touched){jump();setImage(new GreenfootImage("obstacle_item4.png"));getImage().scale(50,50);}
        }
    }

    private void jump(){
        if(!jumped&&touched){
            if(jumpAnim>0){
                if(jumpAnim>10)  setLocation(getX(), getY()-1);
                if(jumpAnim==10) placeItem();
                if(jumpAnim<=10) setLocation(getX(), getY()+1);
            }
            if(jumpAnim<0) jumped=true;
            jumpAnim--;
        }
    }

    private void placeItem(){
        switch(itemType){
            case "coin":
                getWorld().addObject( new coin(),getX(),getY()-50);
                break;
            case "mushroom":
                getWorld().addObject( new mushroom(),getX(),getY()-50);
                break;
            case "oneUp":
                getWorld().addObject( new oneUp(),getX(),getY()-50);
                break;
            case "flower":
                getWorld().addObject( new flower(),getX(),getY()-50);
                break;
            case "star":
                getWorld().addObject( new star(),getX(),getY()-50);
                break;
            case "fireball":
                getWorld().addObject( new fireball(),getX(),getY()-50);
                break;
        }
    }
}
