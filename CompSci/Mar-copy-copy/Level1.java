import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Scrolling
{
    public static respawnPoint rp;
    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {
        super(1600, 900, 1, false); 
        rp=new respawnPoint();
        addObject(rp, 150, 707);
        prepare();
    }

    private void prepare(){
        Mario mario = new Mario();
        addMainActor(mario,150,600);
        
        addNonScroller(new Data(),600,300);

        //addObject(new leftWorldBorder(), 0,0);

        //pavers
        for (int i = 0; i < 208; i++)//225
        {
            if(!((i>=69 && i<71)||(i>=86 && i<89)||(i>=153 && i<155))){
                addObject(new block2(), (i*50)+25, 900-25);
                addObject(new block2(), (i*50)+25, 900-75);
            }
        }

        //item boxes
        int[] y5boxesX = {16,21,23,78,106,109,112,170};
        int[] y9boxesX = {22,94,109,129,130};
        //21,78,109
        String[] y5boxItems = {"coin","mushroom","coin","mushroom","coin","coin","coin","coin"};
        String[] y9boxItems = {"coin","coin","mushroom","coin","coin"};
        for(int i=0;i< y5boxesX.length;i++) addObject(new itemBox(y5boxItems[i],"null"), ((y5boxesX[i]*50)+25), 900-((5*50)+25));
        for(int i=0;i< y9boxesX.length;i++)addObject(new itemBox(y9boxItems[i],"null"), ((y9boxesX[i]*50)+25), 900-((9*50)+25));
        addObject(new itemBox("coin","brick"), ((94*50)+25), 900-((5*50)+25));
        addObject(new itemBox("star","brick"), ((101*50)+25), 900-((5*50)+25));
        addObject(new itemBox("oneUp","invis"), ((64*50)+25), 900-((7*50)+25));

        //stones
        int[] y2stonesX = {134,135,136,137,140,141,142,143,148,149,150,151,152,155,156,157,158,181,182,183,184,185,186,187,188,189};
        int[] y3stonesX = {135,136,137,140,141,142,149,150,151,152,155,156,157,182,183,184,185,186,187,188,189};
        int[] y4stonesX = {136,137,140,141,150,151,152,155,156,183,184,185,186,187,188,189};
        int[] y5stonesX = {137,140,151,152,155,184,185,186,187,188,189};
        int[] y6stonesX = {185,186,187,188,189};
        int[] y7stonesX = {186,187,188,189};
        int[] y8stonesX = {187,188,189};
        int[] y9stonesX = {188,189};
        for(int i=0;i< y2stonesX.length;i++) addObject(new block1(), ((y2stonesX[i]*50)+25), 900-((2*50)+25));
        for(int i=0;i< y3stonesX.length;i++) addObject(new block1(), ((y3stonesX[i]*50)+25), 900-((3*50)+25));
        for(int i=0;i< y4stonesX.length;i++) addObject(new block1(), ((y4stonesX[i]*50)+25), 900-((4*50)+25));
        for(int i=0;i< y5stonesX.length;i++) addObject(new block1(), ((y5stonesX[i]*50)+25), 900-((5*50)+25));
        for(int i=0;i< y6stonesX.length;i++) addObject(new block1(), ((y6stonesX[i]*50)+25), 900-((6*50)+25));
        for(int i=0;i< y7stonesX.length;i++) addObject(new block1(), ((y7stonesX[i]*50)+25), 900-((7*50)+25));
        for(int i=0;i< y8stonesX.length;i++) addObject(new block1(), ((y8stonesX[i]*50)+25), 900-((8*50)+25));
        for(int i=0;i< y9stonesX.length;i++) addObject(new block1(), ((y9stonesX[i]*50)+25), 900-((9*50)+25));
        
        //brick
        int[] y5bricksX = {20,22,24,77,79,100,118,129,130,168,169,171};
        int[] y9bricksX = {80,81,82,83,84,85,86,87,91,92,93,121,122,123,128,131};
        for(int i=0;i< y5bricksX.length;i++) addObject(new block3(), ((y5bricksX[i]*50)+25), 900-((5*50)+25));
        for(int i=0;i< y9bricksX.length;i++) addObject(new block3(), ((y9bricksX[i]*50)+25), 900-((9*50)+25));

        
        //goomba 48*48px
        int[] y2goombasX = {22,40,51,97,114,124,128,174};
        int[] y2goombasXmid = {53,99,116,126,130,176};
        for(int i=0;i<y2goombasXmid.length;i++) addObject(new goomba(), (y2goombasXmid[i]*50), 900-((2*50)+(48/2)));
        for(int i=0;i<y2goombasX.length;i++) addObject(new goomba(), ((y2goombasX[i]*50)+25), 900-((2*50)+(48/2)));
        addObject(new goomba(), (83*50), 900-((10*50)+(48/2)));
        addObject(new goomba(), ((80*50)+25), 900-((10*50)+(48/2)));
        
        //koopa 48*72px
        addObject(new koopa(), ((107*50)+(48/2)), 900-((2*50)+(72/2)));

        //pipes pipe1 =96px*96px; pipe2 =96px*144px; pipe3 =96px*192px;
        int[] pipe1X = {29,164,180};
        for(int i=0;i<pipe1X.length;i++)addObject(new pipe1(), (pipe1X[i]*50), 900-((2*50)+(96/2)));
        addObject(new pipe2(), (39*50), 900-((2*50)+(144/2)));
        addObject(new pipe3(), (47*50), 900-((2*50)+(192/2)));
        addObject(new pipe3(), (58*50), 900-((2*50)+(192/2)));

        //flag 72*504px
        addObject(new flag(), ((198*50)+(72/2)), 900-((2*50)+(504/2)));
        //198 (BL corner)
        
        //castle 240*240px
        addObject(new castle(), ((202*50)+(240/2)), 900-((2*50)+(240/2)));
        //202 (BL corner)
        
        
        //(WARNING: Incorrect dimensions)
        //requires adjustments
        //world base is 15H TL is 0,0
    }
}
