import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item_Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item_Box extends Breakable
{
    int anim=0;
    int breakAnim=0;
    String item="shroom";
    /**
     * Act - do whatever the Item_Box wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Item_Box(){
        
    }

    public void act() 
    {

        if(!breaky){
            if(anim<=1){setImage("obstacle_item1.png");}
            if(anim>10&&anim<=20){setImage("obstacle_item2.png");}
            if(anim>30&&anim<=40){setImage("obstacle_item3.png");}
            if(anim>40&&anim<=50){setImage("obstacle_item2.png");}
            if(anim>=50){anim=0;}
            anim++;

        }
        else{
            if(breakAnim>0&&breakAnim<=10){
                setLocation(getX(),getY()-1);
            }
            if(breakAnim==10){setImage("obstacle_item4.png");}
            if(item.equals("shroom")&&breakAnim==10){getWorld().addObject(new Mushroom(), getX(), getY()-25-getImage().getWidth()/2+10);}
            if(breakAnim>=11&&breakAnim<=20){
                setLocation(getX(),getY()+1);
            }
            breakAnim++;
        }
        getImage().scale(50,50);

    }

    @Override
    public void addedToWorld(World world){
        getImage().scale(50,50);
        int x = getX();
        int y= getY();
        int w= 50;
        int h=50;
        setLocation(x+w/2-x%w, y+h/2-y%h);
    }
}
