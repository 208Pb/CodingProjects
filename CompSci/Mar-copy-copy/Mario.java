import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Actor
{
    public static boolean gameOver=false;
    public static int score = 0;
    public static int coins = 0;
    public static int lives = 3;
    public static boolean mushroomed = false;
    public static boolean flowered = false;
    public static boolean starred = false;
    public static boolean invulnerable = false;
    public static int Level = 1;
    int xSpeed = 0;
    int ySpeed = 3;
    int xSpeedMax =5;
    int ySpeedMax =20;
    int frame = 0;
    int walkingFrame =0;
    boolean faceRight = true;
    boolean crouching = false;
    boolean checkGround = false;
    boolean canJump = false;
    public static boolean dead=false;
    public static boolean deathCounted=false;
    
    public void act() 
    {
        if(lives>0&&Data.maxTime>0){
            if(dead&&!deathCounted){lives--;deathCounted=true;}
            if(getY()>900) dead=true;
            if(dead&&Greenfoot.isKeyDown("enter")){ respawn(); dead=false;deathCounted=false; mushroomed=false;}
            if(!dead){
                movement();
                animations();
                collisions();
            }
        }
        else Greenfoot.setWorld(new LoseScreen());
    }

    public void movement(){
        xSpeedMax=(Greenfoot.isKeyDown("shift"))?8:5;

        if(getX()<=51){xSpeed=0;setLocation(getX()+ 1,getY());}
        if(Greenfoot.isKeyDown("w")&&canJump){ySpeed-=30;canJump=false;}
        if(Greenfoot.isKeyDown("a")&&Math.abs(xSpeed)<xSpeedMax&&!crouching){faceRight=false;xSpeed--;}
        if(Greenfoot.isKeyDown("d")&&Math.abs(xSpeed)<xSpeedMax&&!crouching){faceRight=true;xSpeed++;}
        crouching=Greenfoot.isKeyDown("s");

        if(!dead)setLocation(getX()+xSpeed,getY()+ySpeed);

    }

    public void animations(){ // remember to consolidate the animation stuff
        //crouchL, crouchR, jumpL, jumpR, standL, standR, turnL, turnR, walk1L,walk1R, walk2L, walk2R, walk3L, walk3R
        // remember to add &&checkGround() to all ground based animations
        //setImage(new GreenfootImage("mario_.png"));

        frame=(frame<61)?frame+1:0;
        walkingFrame=(walkingFrame<61)?((frame%(25/xSpeedMax)==0)?walkingFrame+1:walkingFrame):0;
        if(frame%10==0) if(Math.abs(xSpeed)!=0) xSpeed+=(xSpeed<0)?1:-1; // slows mario when no inputs are pressed

        if(faceRight){
            if(xSpeed >0){
                switch(walkingFrame%3){
                    case 0:
                        setImage(new GreenfootImage("mario_walk1R.png"));
                        break;
                    case 1:
                        setImage(new GreenfootImage("mario_walk2R.png"));
                        break;
                    case 2:
                        setImage(new GreenfootImage("mario_walk3R.png"));
                        break;
                }
            }
            if(xSpeed <0) setImage(new GreenfootImage("mario_turnR.png"));
            if(xSpeed ==0) setImage(new GreenfootImage("mario_standR.png"));//standing right
            if(crouching) setImage(new GreenfootImage("mario_crouchR.png"));
            if(!checkGround&&!crouching) setImage(new GreenfootImage("mario_jumpR.png"));
        }
        else{
            if(xSpeed <0){
                switch(walkingFrame%3){
                    case 0:
                        setImage(new GreenfootImage("mario_walk1L.png"));
                        break;
                    case 1:
                        setImage(new GreenfootImage("mario_walk2L.png"));
                        break;
                    case 2:
                        setImage(new GreenfootImage("mario_walk3L.png"));
                        break;
                }
            }
            if(xSpeed >0) setImage(new GreenfootImage("mario_turnL.png"));
            if(xSpeed ==0) setImage(new GreenfootImage("mario_standL.png"));//standing right
            if(crouching) setImage(new GreenfootImage("mario_crouchL.png"));
            if(!checkGround&&!crouching) setImage(new GreenfootImage("mario_jumpL.png"));
        }

    }

    private void enemyCollisions(){
        int h = getImage().getHeight();
        int w = getImage().getWidth();

        Actor BL = getOneObjectAtOffset(-w/4, h/2, enemy.class); // bottom-left
        Actor BR = getOneObjectAtOffset(w/4, h/2, enemy.class); // bottom-right

        Actor LT = getOneObjectAtOffset(-w/2,-h/4, enemy.class); // left-top
        Actor LB = getOneObjectAtOffset(-w/2,h/4, enemy.class); // left-bottom
        Actor RT = getOneObjectAtOffset(w/2,-h/4, enemy.class); // right-top
        Actor RB = getOneObjectAtOffset(w/2,h/4, enemy.class); // right-bottom

        if(LT!=null||LB!=null||RT!=null||RB!=null&&(BL==null&&BR==null)){
            if(!mushroomed&&!flowered&&!starred){
                dead=true;
            }

            if(mushroomed&&!flowered&&!starred){
                mushroomed = false;
            }

            if(flowered&&!starred){
                flowered = false;
            }
        }
        // if hit when mushroomed and not flowered adn not starred 
        // then mushroomed = false; && deaths == deaths
        // if hit when flowered and not starred 
        // then flowered = false && mushroomed == true && starred == false && deaths = deaths
        // if hit when starred
        // then nothing changes

        // when flowered you're mushroomed
        // starred doesn't require either

        //power ups
        //if oneUp lives++
        //if mushroom mushroomed == true
        //if mushroomed mushrooms turn to flowers
        //if flowers turn to 1ups
        //if star invulnerable for 60 seconds
        /*
        if(BL!=null&&BR==null) BL.getWorld().removeObject(getOneObjectAtOffset(-w/4,h/2,enemy.class));
        if(BL==null&&BR!=null) BL.getWorld().removeObject(getOneObjectAtOffset(w/4,h/2,enemy.class));
        if(BL!=null&&BR!=null) BL.getWorld().removeObject(getOneObjectAtOffset(0,h/2,enemy.class));*/

    }

    private void collisions(){
        int h = getImage().getHeight();
        int w = getImage().getWidth();

        // eight point collision system
        // top-left, top-right, bottom-left, bottom-right, left-top, left-bottom, right-top, right-bottom

        Actor TL = getOneObjectAtOffset(-w/4, -h/2, Obstacles.class); // top-left
        Actor TR = getOneObjectAtOffset(w/4, -h/2, Obstacles.class); // top-right
        Actor BL = getOneObjectAtOffset(-w/4, h/2, Obstacles.class); // bottom-left
        Actor BR = getOneObjectAtOffset(w/4, h/2, Obstacles.class); // bottom-right

        Actor LT = getOneObjectAtOffset(-w/2,-h/4, Obstacles.class); // left-top
        Actor LB = getOneObjectAtOffset(-w/2,h/4, Obstacles.class); // left-bottom
        Actor RT = getOneObjectAtOffset(w/2,-h/4, Obstacles.class); // right-top
        Actor RB = getOneObjectAtOffset(w/2,h/4, Obstacles.class); // right-bottom

        checkGround=(BL!=null||BR!=null);
        canJump = (!Greenfoot.isKeyDown("w")&&!!checkGround&&checkGround);
        if(!checkGround&&ySpeed<ySpeedMax) ySpeed+=2;
        //top-bottom collisions

        if(TL !=null){
            int oh = TL.getImage().getHeight();
            ySpeed=0;
            setLocation(getX(),TL.getY()+((oh/2)+(h/2)));
        }

        if(TR !=null){
            int oh = TR.getImage().getHeight();
            ySpeed=0;
            setLocation(getX(),TR.getY()+((oh/2)+(h/2)));
        }

        if(BL !=null){
            int oh = BL.getImage().getHeight();
            ySpeed=0;
            setLocation(getX(),BL.getY()-((oh/2)+(h/2)));
        }

        if(BR !=null){
            int oh = BR.getImage().getHeight();
            ySpeed=0;
            setLocation(getX(),BR.getY()-((oh/2)+(h/2)));
        }

        //left-right collisions

        if(LT !=null){
            int ow = LT.getImage().getWidth();
            xSpeed=0;
            setLocation(LT.getX()+((ow/2)+(w/2)),getY());
        }

        if(LB !=null){
            int ow = LB.getImage().getWidth();
            xSpeed=0;
            setLocation(LB.getX()+((ow/2)+(w/2)),getY());
        }

        if(RT !=null){
            int ow = RT.getImage().getWidth();
            xSpeed=0;
            setLocation(RT.getX()-((ow/2)+(w/2)),getY());
        }

        if(RB !=null){
            int ow = RB.getImage().getWidth();
            xSpeed=0;
            setLocation(RB.getX()-((ow/2)+(w/2)),getY());
        }
    }

    private void lives(){
        if(score>1000){ score=0; lives++;}
        if(dead){lives--;}
        if(lives==0) gameOver = true;

        //power ups
        //if oneUp lives++
        //if mushroom mushroomed == true
        //if mushroomed mushrooms turn to flowers
        //if flowers turn to 1ups
        //if star invulnerable for 60 seconds

        //50 points for breaking bricks
        //200 points for coins
        //400 for kicking shells 
        //500 points for killing
    }

    private void respawn(){
        switch(Level){
            case 1:
                setLocation(Level1.rp.getX(), Level1.rp.getY());
                break;
                /*case 2:
                setLocation(Level2.rp.getX(), Level2.rp.getY());
                break;*/
        }
        setImage("mario_standR.png");
        faceRight=true;
        xSpeed=0;
        ySpeed=0;
        dead=false;
    }
}
