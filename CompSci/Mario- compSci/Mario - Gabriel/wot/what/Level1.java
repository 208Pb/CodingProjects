import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Scrolling
{

    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {
                super(1600, 900, 1, false); 
        //rp=new respawnPoint();
        //addObject(rp, 150, 707);
        prepare();
    }
    private void prepare(){
        Mario mario = new Mario();
        addMainActor(mario,150,200);
        Block1 block1 = new Block1();
        addObject(block1, 1256,681);
        // etc etc
    }
}
