import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Data here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Data extends Actor
{
    public static int maxTime;
    public static int time;
    int kOffset=0;
    Color c2 = new Color(0,0,0,0);
    Color c1 = new Color(255,255,255,255);
    
    public Data(){
        maxTime=400;
        time=0;
        Mario.lives=3;
        Mario.coins=0;
        Mario.score=0;
    }
    
    public void act()
    {
        /*
        String data = "Score: "+Mario.score+"    Coins: "+Mario.coins+"  Word: "+Mario.Level+"   Lives: "+Mario.lives+"  Time: "+maxTime;
        GreenfootImage datas = new GreenfootImage(data, 30, c1, c2);
        setImage(datas);*/
        
        String condition = "Score: "+Mario.score+"    Coins: "+Mario.coins+"  Word: "+Mario.Level+"   Lives: "+Mario.lives+"  Time: "+maxTime + 
        "Mushroomed: "+Mario.mushroomed+
        "Flowered: "+Mario.flowered+
        "Starred: "+Mario.starred+
        "isDead: "+Mario.dead;
        GreenfootImage conditions = new GreenfootImage(condition, 30, c1,c2);
        setImage(conditions);
        
        timer();

        if(((Mario.score-(Mario.score%1000))/1000)>kOffset && Mario.score>1000){
            Mario.lives+=(((Mario.score-(Mario.score%1000))/1000)-kOffset);
            kOffset=((Mario.score-(Mario.score%1000))/1000);
        }
    }
    
    private void timer(){
        time++;
        if(time%60==0) maxTime--;
    }
}
