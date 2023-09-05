import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 *  
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Floor extends Actor
{
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //107x107 pixels
    Actor man;
    boolean canJump = false;
    int jumpCounter;
    public void act() 
    {
        man = (Actor)getWorld().getObjects(Man.class).get(0);
        gravity();
        movement();
        jumpCheck();
    }
    public void jumpCheck(){
        if(getY()==350){canJump=true;jumpCounter=20;}
        if(jumpCounter==0) canJump=false;
        jumpCounter--;
    }
    public void gravity(){
        if(getY()>350){
            setLocation(getX(),getY()-5);
        }
    }
    public void movement(){
        if(Greenfoot.isKeyDown("w")&&canJump) setLocation(getX(),getY()+10);
        if(Greenfoot.isKeyDown("d")&&man.getX()==300) setLocation(getX()-10,getY());
    }
}
