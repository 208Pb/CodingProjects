import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Actor
{
    int xSpeed =0;
    int ySpeed =0;
    int xSpeedMax =10;
    int ySpeedMax =10;
    int frame = 0;
    int walkingFrame =0;
    boolean faceRight = true;
    public void act() 
    {
        testMovement();
        walking();
        frame++;
    }    

    public void testMovement(){
        if(Greenfoot.isKeyDown("a")&&Math.abs(xSpeed)<xSpeedMax){faceRight=false;xSpeed--;}
        if(Greenfoot.isKeyDown("d")&&Math.abs(xSpeed)<xSpeedMax){faceRight=true;xSpeed++;}

    }

    public void walking(){ 
        //crouchL, crouchR, jumpL, jumpR, standL, standR, turnL, turnR, walk1L,walk1R, walk2L, walk2R, walk3L, walk3R
        if(frame%5==0)walkingFrame++;
        if(faceRight&&xSpeed>0){
            switch(walkingFrame%3){//walking Right
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
        if(!faceRight&&xSpeed<0){
            switch(walkingFrame%3){//walking Left
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
        /*
        //if(xSpeed>0&&faceRight) setImage(new GreenfootImage(crouchL); // crouchL
        //if(xSpeed>0&&faceRight) setImage(new GreenfootImage(crouchR); // crouchR

        //if(xSpeed>0&&faceRight) setImage(new GreenfootImage(jumpL); // jumpL
        //if(xSpeed>0&&faceRight) setImage(new GreenfootImage(jumpR); // jumpR

        if(xSpeed==0&&!faceRight) setImage(new GreenfootImage("mario_standL.png")); // standL
        if(xSpeed==0&&faceRight)  setImage(new GreenfootImage("mario_standR.png")); // standR

        if(xSpeed>0&&!faceRight) setImage(new GreenfootImage("mario_turnL.png")); // turnL
        if(xSpeed<0&&faceRight)  setImage(new GreenfootImage("mario_turnR.png")); // turnR

        if(xSpeed<0&&!faceRight) setImage(new GreenfootImage((animationFrames%2==0)?"mario_walk1L.png":"mario_walk2L.png")); // walkL
        if(xSpeed>0&&faceRight) setImage(new GreenfootImage((animationFrames%2==0)?"mario_walk1R.png":"mario_walk2R.png")); // walkR
         */
    }

    public boolean checkGround(){
        int height = getImage().getHeight();
        int width = getImage().getWidth();
        Actor BL = getOneObjectAtOffset(-width/2, height/2, Obstacles.class);
        Actor BR = getOneObjectAtOffset(width/2, height/2, Obstacles.class);
        return (BL!=null||BR!=null); 
    }

    private void collisions(){
        int h = getImage().getHeight();
        int w = getImage().getWidth();
        // eight point collision system
        // top-left, top-right, bottom-left, bottom-right, left-top, left-bottom, right-top, right-bottom
        Actor TL = getOneObjectAtOffset(-w/4, -h/2, Object.class); // top-left
        Actor TR = getOneObjectAtOffset(w/4, -h/2, Object.class); // top-right
        Actor BL = getOneObjectAtOffset(-w/4, h/2, Object.class); // bottom-left
        Actor BR = getOneObjectAtOffset(w/4, h/2, Object.class); // bottom-right

        Actor LT = getOneObjectAtOffset(-w/2,-h/4, Object.class); // left-top
        Actor LB = getOneObjectAtOffset(-w/2,h/4, Object.class); // left-bottom
        Actor RT = getOneObjectAtOffset(w/2,-h/4, Object.class); // right-top
        Actor RB = getOneObjectAtOffset(w/2,h/4, Object.class); // right-bottom
        /*
        //top-bottom collisions
        if(TL !=null){ //TL
        int ow = LT.getImage().getWidth();
        int oh = LT.getImage().getHeight();
        setLocation(getX(),getY()+((h/2)+(oh/2))); 
        // if it hits the top move it down(+) the length of half mario and half obstical
        }
        if(TR !=null){ //TR
        int ow = LT.getImage().getWidth();
        int oh = LT.getImage().getHeight();
        setLocation(getX(),getY()+((h/2)+(oh/2)));
        }
        if(BL !=null){ //BL
        int ow = LT.getImage().getWidth();
        int oh = LT.getImage().getHeight();
        setLocation(getX(),getY()-((h/2)+(oh/2)));
        }
        if(BR !=null){ //BR
        int ow = LT.getImage().getWidth();
        int oh = LT.getImage().getHeight();
        setLocation(getX(),getY()-((h/2)+(oh/2)));
        }
        // left-right collisions
        if(LT !=null){ //LT
        int ow = LT.getImage().getWidth();
        int oh = LT.getImage().getHeight();
        setLocation(getX()+((w/2)+(ow/2)),getY());
        }
        if(LB !=null){ //LB
        int ow = LT.getImage().getWidth();
        int oh = LT.getImage().getHeight();
        setLocation(getX()+((w/2)+(ow/2)),getY());
        }
        if(RT !=null){ //RT
        int ow = LT.getImage().getWidth();
        int oh = LT.getImage().getHeight();
        setLocation(getX()-((w/2)+(ow/2)),getY());
        }
        if(RB !=null){ //RB
        int ow = LT.getImage().getWidth();
        int oh = LT.getImage().getHeight();
        setLocation(getX()-((w/2)+(ow/2)),getY());
        }
         */

    }
}
