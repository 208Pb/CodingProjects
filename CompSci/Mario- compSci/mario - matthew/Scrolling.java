import greenfoot.*;
import java.util.ArrayList;
public class Scrolling extends World {
    int scrolledX;
    Actor mainActor;
    ArrayList<Actor> actorList;
    
    public Scrolling(int w, int h, int s, boolean b) {
        super(w, h, s, b);
        scrolledX = 0;
        mainActor = null;
        actorList = new ArrayList<Actor>();
    }

    public void act() {
        scrollActors();
    }

    public void scrollActors() {
        int dx = 0;
        if(mainActor.getX() < 700) {
            dx = 700-mainActor.getX();
        }
        if(mainActor.getX() > 900) {
            dx = 900-mainActor.getX();
        }
        scrolledX -= dx;
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY());
        for(Actor a : actorList) {
            a.setLocation(a.getX()+dx, a.getY());
        }
    }

    public void addMainActor(Actor mainActor, int x, int y) {
        super.addObject(mainActor, x, y);
        this.mainActor = mainActor;
    }

    public void addObject(Actor a, int x, int y) {
        super.addObject(a, x, y);
        actorList.add(a);
    }

    public void addNonScroller(Actor a, int x, int y) {
        super.addObject(a, x, y);
    }

    public void removeObject(Actor a) {
        if(actorList.contains(a)) {
            actorList.remove(a);
        }
        super.removeObject(a);
    }
}
