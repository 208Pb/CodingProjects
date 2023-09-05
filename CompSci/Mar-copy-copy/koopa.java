import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class goomba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class koopa extends enemy
{
    /**
     * Act - do whatever the goomba wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public  int xSpeed=1;
    int ySpeed=0;
    boolean isDead=false;
    int frame=0;
    int anim=0;
    int deathAnim=0;

    public void act()
    {
        animation();
        if(!isDead){
            collisions();
            setLocation(getX()+xSpeed,getY()+ySpeed);
        }
    }

    private void animation(){
        frame=(frame<60)?frame+1:0;
        anim=(frame%20==0)?(anim<61)?anim+1:0:anim;
        if(xSpeed==0)setImage(new GreenfootImage("enemy_koopa4.png"));
        if(xSpeed>0)setImage(new GreenfootImage((anim%2==0)?"enemy_koopa1.png":"enemy_koopa2.png"));
        if(xSpeed<0)setImage(new GreenfootImage((anim%2==0)?"enemy_koopa5.png":"enemy_koopa6.png"));

        if(isDead){ deathAnim++;setImage(new GreenfootImage("enemy_koopa3.png"));}
        if(deathAnim>10) getWorld().removeObject(this);
    }

    private void collisions(){
        int h = getImage().getHeight();
        int w = getImage().getWidth();

        if(LT(w,h,Obstacles.class)||LB(w,h,Obstacles.class)||RT(w,h,Obstacles.class)||RB(w,h,Obstacles.class)) xSpeed*=-1;
        ySpeed = (BL(w,h,Obstacles.class)||BR(w,h,Obstacles.class))? 0: ySpeed+1;

        if((LT(w,h,Mario.class)||LB(w,h,Mario.class)||RT(w,h,Mario.class)||RB(w,h,Mario.class))&&!(TL(w,h,Mario.class)||TR(w,h,Mario.class))){
            if(!(Mario.starred||Mario.flowered||Mario.mushroomed)) Mario.dead=true;
            if(Mario.flowered)Mario.flowered = false;
            if(Mario.mushroomed)Mario.mushroomed = false;
        }
        if((!Mario.dead)&&(TL(w,h,Mario.class)||TR(w,h,Mario.class))) isDead=true;

        if(LT(w+12,h,enemy.class)||LB(w+12,h,enemy.class)||RT(w+12,h,enemy.class)||RB(w+12,h,enemy.class)) xSpeed*=-1;
    }
}

/*
int h = getImage().getHeight();
int w = getImage().getWidth();

Actor L  = getOneObjectAtOffset(-w/2,  0, Obstacles.class);
Actor R  = getOneObjectAtOffset( w/2,  0, Obstacles.class);
Actor BL = getOneObjectAtOffset(-w/4,h/2, Obstacles.class);
Actor BR = getOneObjectAtOffset( w/4,h/2, Obstacles.class);

Actor enemyL = getOneObjectAtOffset((-w/2)-12, 0, enemy.class);
Actor enemyR = getOneObjectAtOffset(( w/2)+12, 0, enemy.class);

ySpeed  = (BL==null&&BR==null)? ySpeed+1:0;
if((BL==null||BR==null)&&!(BL==null&&BR==null)) xSpeed*=-1;
if((enemyL!=null||enemyR!=null)||(L!=null||R!=null)) xSpeed*=-1;
marioCollisions();
}

private void marioCollisions(){
int h = getImage().getHeight();
int w = getImage().getWidth();

Actor L  = getOneObjectAtOffset(-w/2,  0, Mario.class);
Actor R  = getOneObjectAtOffset( w/2,  0, Mario.class);
Actor TL = getOneObjectAtOffset(-w/4,-h/2, Mario.class);
Actor TR = getOneObjectAtOffset( w/4,-h/2, Mario.class);

if(TL!=null||TR!=null&&(L==null&&R==null)){Mario.score+=500; isDead=true;}
if((L!=null||R!=null)&&(TL==null&&TR==null)){
if(!Mario.mushroomed&&!Mario.flowered&&!Mario.starred) Mario.dead=true;
if(Mario.mushroomed&&!Mario.flowered) Mario.mushroomed = false;
if(Mario.flowered) Mario.flowered = false;
}
}
}
 */
