import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class killScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class killScore extends Actor
{
    /**
     * Act - do whatever the killScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int scoreVal = 500;
    int anim=0;
    Color c1 = new Color(255,255,255,255);
    Color c2= new Color(0,0,0,0);
    
    public killScore(int val){
        scoreVal = val;
    }
    
    public void act()
    {
        String txt = "" + scoreVal;
        if(anim<31)setLocation(getX(),getY()-1);
        else getWorld().removeObject(this);
        GreenfootImage img = new GreenfootImage(txt, 25, c1, c2);
        setImage(img);
        anim++;
    }
}
