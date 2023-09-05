import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goomba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goomba extends Enemy
{
    int xSpeed=-1;
    int ySpeed=0;
    int anim=0;
    boolean dead=false;
    int deadAnim=0;
    /**
     * Act - do whatever the Goomba wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!dead){
            if(checkGround()){ySpeed=0;}
            else{ySpeed++;}
            setLocation(getX()+xSpeed, getY()+ySpeed);
            checkCollision();
            animation();

            dead=checkDead();
        }
        if(dead){
            if(deadAnim==0){
                Mario.goombaPerTick++;
                if(Greenfoot.getRandomNumber(1000)==0){
                    for (int i=1; i<=250; i++){
                        getWorld().addObject(new Goomba(), getX()+5, getY());
                    }
                }
                if(Mario.goombaPerTick==1){
                    getWorld().addObject(new killScore(200*Mario.goombaPerTick), getX(), getY()-getImage().getHeight());
                }
                else{
                    getWorld().addObject(new killScore(200*Mario.goombaPerTick+(100*Mario.goombaPerTick)), getX(), getY()-getImage().getHeight());
                }
            }

            setImage("enemy_goomba3.png");
            xSpeed=0;
            if(checkGround()){ySpeed=0;}
            else{ySpeed++;}
            deadAnim++;

            if(deadAnim>=20){getWorld().removeObject(this);}
        }

    }    

    public boolean checkGround(){
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Actor BL = getOneObjectAtOffset(-w/2, h/2, Obstacle.class);
        Actor BR = getOneObjectAtOffset(w/2, h/2, Obstacle.class);
        return BL != null || BR != null;
    }

    public void checkCollision() {
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        // BOTTOM LEFT COLLISION
        Actor BL = getOneObjectAtOffset(-w/4, h/2, Obstacle.class);
        if(BL != null) {
            ySpeed = 1;
            int oh = BL.getImage().getHeight();
            setLocation(getX(), BL.getY()-oh/2-h/2);
        }
        // BOTTOM RIGHT COLLISION
        Actor BR = getOneObjectAtOffset(w/4, h/2, Obstacle.class);
        if(BR != null) {
            ySpeed = -1;
            int oh = BR.getImage().getHeight();
            setLocation(getX(), BR.getY()-oh/2-h/2);
        }
        // TOP LEFT COLLISION
        Actor TL = getOneObjectAtOffset(-w/4, -h/2, Obstacle.class);
        if(TL != null) {
            ySpeed = 1;
            int oh = TL.getImage().getHeight();
            setLocation(getX(), TL.getY()+oh/2+h/2);
        }
        // TOP RIGHT COLLISION
        Actor TR = getOneObjectAtOffset(w/4, -h/2, Obstacle.class);
        if(TR != null) {
            ySpeed = 1;
            int oh = TR.getImage().getHeight();
            setLocation(getX(), TR.getY()+oh/2+h/2);
        }
        // LEFT TOP COLLISION
        Actor LT = getOneObjectAtOffset(-w/2, -h/4, Obstacle.class);
        if(LT != null) {
            xSpeed = 1;
            int ow = LT.getImage().getWidth();
            setLocation(LT.getX()+ow/2+w/2, getY());
        }
        // LEFT BOTTOM COLLISION
        Actor LB = getOneObjectAtOffset(-w/2, h/4, Obstacle.class);
        if(LB != null) {
            xSpeed = 1;
            int ow = LB.getImage().getWidth();
            setLocation(LB.getX()+ow/2+w/2, getY());
        }
        // RIGHT TOP COLLISION
        Actor RT = getOneObjectAtOffset(w/2, -h/4, Obstacle.class);
        if(RT != null) {
            xSpeed = -1;
            int ow = RT.getImage().getWidth();
            setLocation(RT.getX()-ow/2-w/2, getY());
        }
        // RIGHT BOTTOM COLLISION
        Actor RB = getOneObjectAtOffset(w/2, h/4, Obstacle.class);
        if(RB != null) {
            xSpeed = -1;
            int ow = RB.getImage().getWidth();
            setLocation(RB.getX()-ow/2-w/2, getY());
        }
        if(BL==null&&BR!=null){xSpeed=1;}
        if(BL!=null&&BR==null){xSpeed=-1;}
    }

    public void animation(){
        if(anim>=1&&anim<=10){setImage("enemy_goomba1.png");}
        if(anim>=11&&anim<20){setImage("enemy_goomba2.png");}
        if(anim==20){anim=0;}
        anim++;
    }

    public boolean checkDead(){
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        // TOP LEFT COLLISION
        Actor TL = getOneObjectAtOffset(-w/4, -h/2, Mario.class);
        // TOP RIGHT COLLISION
        Actor TR = getOneObjectAtOffset(w/4, -h/2, Mario.class);
        // TOP RIGHT COLLISION
        Actor M = getOneObjectAtOffset(w/2, -h/2, Mario.class);
        Actor RB = getOneObjectAtOffset(w/2, h/4, Mario.class);
        Actor LB = getOneObjectAtOffset(-w/2, h/4, Mario.class);
        Actor LT = getOneObjectAtOffset(-w/2, -h/4, Mario.class);
        Actor BL = getOneObjectAtOffset(-w/4, h/2, Mario.class);
        Actor BR = getOneObjectAtOffset(w/4, h/2, Mario.class);
        Actor RT = getOneObjectAtOffset(w/2, -h/4, Mario.class);
        if((TR==null||TL==null||M==null)&&(RB!=null||LB!=null||LT!=null||BL!=null||BR!=null||RT!=null)){Mario.dead=true;}
        return (TR!=null||TL!=null||M!=null)&&(RB==null&&LB==null&&LT==null&&BL==null&&BR==null&&RT==null);
    }
}
