import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BreakParticle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BreakParticle extends Actor
{
    int anim=0;
    int realdirection=1;
    int y=0;
    int spawnY=0;
    int spawnX=0;
    double previousY=0;
    int rotation=0;
    public BreakParticle(int direction){
        //1 left
        //2 right
        setImage("break_Particle.png");
        realdirection=direction;
        anim++;
    }

    /**
     * Act - do whatever the BreakParticle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        double y = 1.0 / 1024.0 * (((anim-2.5)*(anim-2.5))+40.0);
        anim++;
        y = 1.0 / 1024.0 * (((anim-2.5)*(anim-2.5))+40.0);
        anim++;
        y = 1.0 / 1024.0 * (((anim-2.5)*(anim-2.5))+40.0);
        anim++;
        y = 1.0 / 1024.0 * (((anim-2.5)*(anim-2.5))+40.0);
        anim++;
        y = 1.0 / 1024.0 * (((anim-2.5)*(anim-2.5))+40.0);
        anim++;
        y = 1.0 / 1024.0 * (((anim-2.5)*(anim-2.5))+40.0);
        anim++;
        previousY=(previousY+y);
        setRotation(rotation);
        if(realdirection==2){
            setLocation(spawnX+anim, (int)previousY);
            anim++;
            if(rotation<45){
                rotation+=5;}
        }
        if(realdirection==1){
            setLocation(spawnX-anim, (int)previousY);
            anim++;
            if(rotation<45){
                rotation-=5;}
        }
        if(getY()>950){getWorld().removeObject(this);}
    }  

    @Override
    public void addedToWorld(World world){
        spawnY=getY();
        spawnX=getX();
        previousY=spawnY;
    }
}
