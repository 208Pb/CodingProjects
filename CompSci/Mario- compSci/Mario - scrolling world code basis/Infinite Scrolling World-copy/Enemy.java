import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is not necessary for the scrolling system.
 * 
 * The enemys just run arround all time. But you can create better ones.
 */
public class Enemy extends Player
{
    private int angle = 0;
    private int counter;
    
    public Enemy() {
        
    }
    
    public void act() {
        move(angle, 2);
        counter++;
        if (counter > 30) {
            angle += 90;
            counter = 0;
        }
    }
    
    public void move(double angle, double distance) throws NullPointerException {
        angle = Math.toRadians(angle);
        setLocation(getX() + Math.cos(angle) * distance, getY() + Math.sin(angle) * distance);
    }
}