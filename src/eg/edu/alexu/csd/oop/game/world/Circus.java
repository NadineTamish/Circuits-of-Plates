/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.world;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.object.Background;
import eg.edu.alexu.csd.oop.game.object.Bomb;
import eg.edu.alexu.csd.oop.game.object.Bonus;
import eg.edu.alexu.csd.oop.game.object.Clown;
import eg.edu.alexu.csd.oop.game.object.ShapeFactory;
import eg.edu.alexu.csd.oop.game.object.Snapshot;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jana Gh
 */
public class Circus implements World,ScoreObservable{
    private final int width;
    private final int height;
    private static int MAX_TIME = 1 * 60 * 1000;	// 1 minute
    private int score = 0;
    private long startTime = System.currentTimeMillis();
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private static final List<GameObject> control = new LinkedList<GameObject>();    
    private final List<GameObject> toBeRemoved = new LinkedList<GameObject>();
    private final DifficultyStrategy differentStrategy;
    private static final Clown clown = Clown.getInstance();
    private int x = 0;//left hand
    private int y = 0;//right hand
    Background bg=new Background("/background8.png",0,0);
    private List<ScoreObserver> observers = new ArrayList<>();
    public Circus(int width,int height, DifficultyStrategy differentStrategy){
        this.height=height;
        this.width=width;
        this.differentStrategy=differentStrategy;
        constant.add(bg);
        control.add(clown);
        for(int i=0; i < 1; i++)
        {
            moving.add(ShapeFactory.createShape("Bomb"));
            moving.add(ShapeFactory.createShape("Ball")); 
            moving.add(ShapeFactory.createShape("Plate"));
        }
    }
    @Override
	public boolean refresh() {
            boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME|| Clown.getCareTaker().getRight().size()>=8 || Clown.getCareTaker().getLeft().size()>=8;
            for(GameObject m : moving){
                {m.setY((m.getY() +1));}	 
	}
            if(System.currentTimeMillis()%100==0 && !timeout)
            { 
                moving.add(ShapeFactory.createShape("Bomb"));
                moving.add(ShapeFactory.createShape("Ball")); 
                moving.add(ShapeFactory.createShape("Plate"));
            }
            if(System.currentTimeMillis()%150==0 && !timeout)
                moving.add(ShapeFactory.createShape("Bonus"));
             for(GameObject c : moving){
                if(c.isVisible() &&(((c.getX()>=clown.getX()-15&&c.getX()<=clown.getX()+6)&& c.getY()==370-x)||((c.getX()>=clown.getX()+150-45&&c.getX()<=clown.getX()+150-20)&& c.getY()==370-y))&&!timeout ){
            if(c instanceof Bomb)
            {Clown.getCareTaker().downdate(this);
            ((Bomb)c).setVisible(false);
            }
            else if(c instanceof Bonus)
            {Clown.getCareTaker().update(this);
            ((Bonus)c).setVisible(false);
            }
            else{   
            control.add(c);
            toBeRemoved.add(c);
             if(c.getX()>=clown.getX()-15&&c.getX()<=clown.getX()+6){
             
             Clown.getCareTaker().save(this,new Snapshot(c),0);
             }
             else if(c.getX()>=clown.getX()+150-45&&c.getX()<=clown.getX()+150-20){
            
             Clown.getCareTaker().save(this,new Snapshot(c),1);
             }
            }
                }
             }
            moving.removeAll(toBeRemoved);
            Clown.getCareTaker().increaseScore(this);      
        return !timeout;
        }
        
	@Override
	public int getSpeed() {	
		return differentStrategy.getSpeed();
	}
	@Override
	public int getControlSpeed() {	
		return 10;  
	}
	@Override
	public List<GameObject> getConstantObjects() {	
		return constant;	
	}
	@Override
	public List<GameObject> getMovableObjects() {	
		return moving;	
	}
	@Override
	public List<GameObject> getControlableObjects() {	
		return control;	
	}
	@Override
	public int getWidth() {	
		return width; 
	}
	@Override
	public int getHeight() { 
		return height; 
	}
	@Override
	public String getStatus() {
		return "Please Use Arrows To Move   |   Location = " + control.get(0).getX() + "," + control.get(0).getY() + "   |   Score=" + score + "   |   Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis()-startTime))/1000);	// update status
	}
        
        public static Clown getClown(){
            return clown;
        }
        
        public static List<GameObject> getControl(){
            return control;
        }
        
        public  int getScore(){
            return score;
        }
        
        public  void setScore(int s){
            score=s;
            notifyObservers();
        }
        public  int getX(){
            return x;
        }
        
        public  void setX(int s){
            x=s;
        }
        public  int getY(){
            return y;
        }
        
        public  void setY(int s){
            y=s;
        }
        @Override
    public void addObserver(ScoreObserver observer) {
         observers.add(observer);
    }

    @Override
    public void removeObserver(ScoreObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ScoreObserver observer : observers) {
            observer.update(this);
            observer.downdate(this);
        }
    }
    

}
