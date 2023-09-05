import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class scoreDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class scoreDisplay extends Actor
{
   public static int score;
   Color c1 = new Color(255,255,255,255);
   Color c2= new Color(0,0,0,0);
         
        public scoreDisplay(){
            score=0;
            act();
   }
        public void act(){
            String text= "Score: " +score;
            GreenfootImage image= new GreenfootImage(text, 50, c1, c2);
            setImage(image);
   }    
}
