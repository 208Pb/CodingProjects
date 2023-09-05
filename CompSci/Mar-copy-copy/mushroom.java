import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mushroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mushroom extends powerUps
{
    /**
     * Act - do whatever the mushroom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int xSpeed=5;
    int ySpeed=0;
    public void act() 
    {
        if(checkGround()){ySpeed=0;}
        else{ySpeed++;}

        setLocation(getX()+xSpeed, getY()+ySpeed);
        checkCollision();
        if(isTouching(Mario.class)){Mario.mushroomed=true; getWorld().removeObject(this);}
    }        

    public boolean checkGround(){
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Actor BL = getOneObjectAtOffset(-w/2, h/2, Obstacles.class);
        Actor BR = getOneObjectAtOffset(w/2, h/2, Obstacles.class);
        return BL != null || BR != null;
    }

    public void checkCollision() {
        int w = getImage().getWidth();
        int h = getImage().getHeight();

        Actor BL = getOneObjectAtOffset(-w/4, h/2, Obstacles.class);
        Actor BR = getOneObjectAtOffset(w/4, h/2, Obstacles.class);
        Actor TL = getOneObjectAtOffset(-w/4, -h/2, Obstacles.class);
        Actor TR = getOneObjectAtOffset(w/4, -h/2, Obstacles.class);
        Actor LT = getOneObjectAtOffset(-w/2, -h/4, Obstacles.class);
        Actor LB = getOneObjectAtOffset(-w/2, h/4, Obstacles.class);
        Actor RT = getOneObjectAtOffset(w/2, -h/4, Obstacles.class);
        Actor RB = getOneObjectAtOffset(w/2, h/4, Obstacles.class);

        if(BL != null) {
            ySpeed = 5;
            int oh = BL.getImage().getHeight();
            setLocation(getX(), BL.getY()-oh/2-h/2);
        }
        if(BR != null) {
            ySpeed = -5;
            int oh = BR.getImage().getHeight();
            setLocation(getX(), BR.getY()-oh/2-h/2);
        }
        if(TL != null) {
            ySpeed = 5;
            int oh = TL.getImage().getHeight();
            setLocation(getX(), TL.getY()+oh/2+h/2);
        }
        if(TR != null) {
            ySpeed = -5;
            int oh = TR.getImage().getHeight();
            setLocation(getX(), TR.getY()+oh/2+h/2);
        }
        if(LT != null) {
            xSpeed = 5;
            int ow = LT.getImage().getWidth();
            setLocation(LT.getX()+ow/2+w/2, getY());
        }
        if(LB != null) {
            xSpeed = 5;
            int ow = LB.getImage().getWidth();
            setLocation(LB.getX()+ow/2+w/2, getY());
        }
        if(RT != null) {
            xSpeed = -5;
            int ow = RT.getImage().getWidth();
            setLocation(RT.getX()-ow/2-w/2, getY());
        }
        if(RB != null) {
            xSpeed = -5;
            int ow = RB.getImage().getWidth();
            setLocation(RB.getX()-ow/2-w/2, getY());
        }
    }
}