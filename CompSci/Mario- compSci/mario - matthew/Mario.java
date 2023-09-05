import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Actor
{
    int xSpeed=0;
    int ySpeed=0;
    int frame=0;
    int xSpeedMax=7;
    int ySpeedMax=40;
    boolean facingRight=true;
    int walkingFrame=0;
    boolean sprinting=false;
    static int goombaPerTick=0;
    static boolean dead=false;
    boolean inLevel1=true;
    /**
     * Act - do whatever the Mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        frame++;
        boolean onGround=checkGround();
        checkBreaky();
        if(onGround){ySpeed=0;}
        else{ySpeed++;}
        if(Greenfoot.isKeyDown("SHIFT")){xSpeedMax=9;}
        else{xSpeedMax=5;}
        if((Greenfoot.isKeyDown("SPACE")||Greenfoot.isKeyDown("W")||Greenfoot.isKeyDown("UP"))&&onGround){ySpeed=-20;}
        if(Greenfoot.isKeyDown("A")||Greenfoot.isKeyDown("LEFT")){xSpeed--; facingRight=false;}
        if(Greenfoot.isKeyDown("D")||Greenfoot.isKeyDown("RIGHT")){xSpeed++; facingRight=true;}
        if(xSpeed>0&&frame%2==0){xSpeed--;}
        if(xSpeed<0&&frame%2==0){xSpeed++;}
        if(xSpeed>xSpeedMax){xSpeed=xSpeedMax;}
        if(xSpeed<-xSpeedMax){xSpeed=-xSpeedMax;}
        if(ySpeed>ySpeedMax){ySpeed=ySpeedMax;}
        if(ySpeed<-ySpeedMax){ySpeed=-ySpeedMax;}
        setLocation(getX()+xSpeed, getY()+ySpeed);
        if(ySpeed!=0&&!facingRight){setImage("mario_jumpL.png");}
        else if(ySpeed!=0&&facingRight){setImage("mario_jumpR.png");}
        else if(ySpeed==0&&xSpeed==0&&facingRight&&onGround){setImage("mario_standR.png");}
        else if(ySpeed==0&&xSpeed==0&&!facingRight&&onGround){setImage("mario_standL.png");}
        else if(xSpeed>0&&ySpeed==0&&onGround){
            if(sprinting){walkingFrame+=2;}
            else{walkingFrame++;}
            if((walkingFrame<=10)){setImage("mario_walk1R.png");}
            if((walkingFrame>10&&walkingFrame<=20)){setImage("mario_walk2R.png");}
            if((walkingFrame>20&&walkingFrame<=30)){setImage("mario_walk3R.png");}
            if((walkingFrame>30&&walkingFrame<=40)){setImage("mario_walk2R.png");}
            if(walkingFrame>=40){walkingFrame=0;}
        }
        else if(xSpeed<0&&ySpeed==0&&onGround){
            if(sprinting){walkingFrame+=2;}
            else{walkingFrame++;}
            if((walkingFrame<=10)){setImage("mario_walk1L.png");}
            if((walkingFrame>10&&walkingFrame<=20)){setImage("mario_walk2L.png");}
            if((walkingFrame>20&&walkingFrame<=30)){setImage("mario_walk3L.png");}
            if((walkingFrame>30&&walkingFrame<=40)){setImage("mario_walk2L.png");}
            if(walkingFrame>=40){walkingFrame=0;}
        }
        if(getY()>900){respawn();}
        if(dead){respawn();}
        checkCollision();  

        goombaPerTick=0;
    }

    public boolean checkGround(){
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Actor BL = getOneObjectAtOffset(-w/2, h/2, Obstacle.class);
        Actor BR = getOneObjectAtOffset(w/2, h/2, Obstacle.class);
        return BL != null || BR != null;
    }

    public boolean checkBreaky(){
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Actor TL=null;
        Actor TR=null;
        if(!facingRight){TL = getOneObjectAtOffset(-w/4, (-h/2)-1, Breakable.class);}
        else{TR = getOneObjectAtOffset(w/4, (-h/2)-1, Breakable.class);}
        if(TL!=null||TR!=null){
            if(TL!=null){
                Breakable B = (Breakable)TL;
                B.breaky = true;
            }
            if(TR!=null){
                Breakable A = (Breakable)TR;
                A.breaky = true;
            }
        }
        return TL!=null||TR!=null;
    }

    public void checkCollision() {
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        // BOTTOM LEFT COLLISION
        Actor BL = getOneObjectAtOffset(-w/4, h/2, Obstacle.class);
        if(BL != null) {
            ySpeed = 0;
            int oh = BL.getImage().getHeight();
            setLocation(getX(), BL.getY()-oh/2-h/2);
        }
        // BOTTOM RIGHT COLLISION
        Actor BR = getOneObjectAtOffset(w/4, h/2, Obstacle.class);
        if(BR != null) {
            ySpeed = 0;
            int oh = BR.getImage().getHeight();
            setLocation(getX(), BR.getY()-oh/2-h/2);
        }
        // TOP LEFT COLLISION
        Actor TL = getOneObjectAtOffset(-w/4, -h/2, Obstacle.class);
        if(TL != null) {
            ySpeed = 0;
            int oh = TL.getImage().getHeight();
            setLocation(getX(), TL.getY()+oh/2+h/2);
        }
        // TOP RIGHT COLLISION
        Actor TR = getOneObjectAtOffset(w/4, -h/2, Obstacle.class);
        if(TR != null) {
            ySpeed = 0;
            int oh = TR.getImage().getHeight();
            setLocation(getX(), TR.getY()+oh/2+h/2);
        }
        // LEFT TOP COLLISION
        Actor LT = getOneObjectAtOffset(-w/2, -h/4, Obstacle.class);
        if(LT != null) {
            xSpeed = 0;
            int ow = LT.getImage().getWidth();
            setLocation(LT.getX()+ow/2+w/2, getY());
        }
        // LEFT BOTTOM COLLISION
        Actor LB = getOneObjectAtOffset(-w/2, h/4, Obstacle.class);
        if(LB != null) {
            xSpeed = 0;
            int ow = LB.getImage().getWidth();
            setLocation(LB.getX()+ow/2+w/2, getY());
        }
        // RIGHT TOP COLLISION
        Actor RT = getOneObjectAtOffset(w/2, -h/4, Obstacle.class);
        if(RT != null) {
            xSpeed = 0;
            int ow = RT.getImage().getWidth();
            setLocation(RT.getX()-ow/2-w/2, getY());
        }
        // RIGHT BOTTOM COLLISION
        Actor RB = getOneObjectAtOffset(w/2, h/4, Obstacle.class);
        if(RB != null) {
            xSpeed = 0;
            int ow = RB.getImage().getWidth();
            setLocation(RB.getX()-ow/2-w/2, getY());
        }
    }

    public void respawn(){
        livesDisplay.lives--;
        if(inLevel1){
            setLocation(Level1.rp.getX(), Level1.rp.getY());
        }
        else{setLocation(Level2.rp.getX(), Level2.rp.getY());}
        setImage("mario_standR.png");
        facingRight=true;
        xSpeed=0;
        ySpeed=0;
        dead=false;
    }
}
