import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class killScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class killScore extends Actor
{
    int score;
    int anim=0;
    public killScore(int i){score=i; scoreDisplay.score+=i;}
    Color c1 = new Color(255,255,255,255);
    Color c2= new Color(0,0,0,0);

    public void act(){
        String text= ""+score;
        if(anim%1==0){setLocation(getX(),getY()-1);}
        GreenfootImage image= new GreenfootImage(text, 25, c1, c2);
        setImage(image);
        anim++;
        if(anim>=30){getWorld().removeObject(this);}
    }    
}
