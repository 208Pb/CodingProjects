import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This subclass is just an example. You can delete it or change the code if you want.
 * It's not necessary for the scrolling system.
 */
public class ExampleWorld extends ScrollingWorld
{
    
    public ExampleWorld() {
        super(600, 400, 1);//creates an infinite scrolling world with a screen size of 600 x 400;
        //if you want to limitate the scrolling world you have to use this constructor:
        //super(600, 400, 1, scrollingWidth, scrollingHeight);
        setScrollingBackground(new GreenfootImage("background1.png"));
        createExampleWorld();//this method just adds some objects to the world.
    }
    
    /**
     * Creates an example world where the ScrollingActor can move.
     */
    public void createExampleWorld() {
        for (int x = getWidth() * -3; x < getWidth() * 3; x += getWidth()/2) {
            for (int y = getHeight() * -3; y < getHeight() * 3; y += getHeight()/2) {
                if (x != getWidth()/2 || y != getHeight()/2) {
                    addObject(new Rock(), x, y);
                }
            }
        }
        for (int x = getWidth() * -3 + getWidth()/2; x < getWidth() * 3; x += getWidth()) {
            for (int y = getHeight() * -3 + getHeight()/4; y < getHeight() * 3; y += getHeight()) {
                addObject(new Enemy(), x, y);
            }
        }
        addObject(new ExampleScrollingActor(), getWidth()/2, getHeight()/2);
    }
}