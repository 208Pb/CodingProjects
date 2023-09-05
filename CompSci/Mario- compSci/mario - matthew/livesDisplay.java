import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class livesDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class livesDisplay extends Actor
{
   public static int lives;
   Color c1 = new Color(255,255,255,255);
   Color c2= new Color(0,0,0,0);
         
        public livesDisplay(){
            
            act();
   }
        public void act(){
            String text= "Lives: " +lives;
            GreenfootImage image= new GreenfootImage(text, 50, c1, c2);
            setImage(image);
            if(lives==0){Greenfoot.setWorld(new LoseScreen());}
   }    
}
