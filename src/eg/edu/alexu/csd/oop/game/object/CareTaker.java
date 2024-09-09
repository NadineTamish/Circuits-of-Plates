/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.world.Circus;
import eg.edu.alexu.csd.oop.game.world.ScoreObserver;
import java.awt.Color;
import java.util.Stack;

/**
 *
 * @author Jana Gh
 */
public class CareTaker implements ScoreObserver{
    private Stack<Snapshot> left=new Stack<Snapshot>();
    private Stack<Snapshot> right=new Stack<Snapshot>();
    private Color c1,c2,c3;
    private Snapshot temp1,temp2;
    private GameObject pop1,pop2,pop3;
    public void save(Circus circus,Snapshot s, int i){
        if(i==0)
        {
            left.push(s);
        if( s.getObject() instanceof Ball)
            circus.setX(circus.getX()+50);
        else if(s.getObject() instanceof Plate)
            circus.setX(circus.getX()+30);
        }
        else if(i==1)
           {right.push(s);
        if( s.getObject() instanceof Ball)
            circus.setY(circus.getY()+50);
        else if(s.getObject() instanceof Plate)
            circus.setY(circus.getY()+30);
        }
    }
    public Stack<Snapshot> getRight(){
        return right;
    }
    
    public Stack<Snapshot> getLeft(){
        return left;
    }
    
    public void increaseScore(Circus circus){
        if(Clown.getCareTaker().left.size()>=3){
                
            if(Clown.getCareTaker().left.peek().getObject()instanceof Ball)
                {c1=((Ball)Clown.getCareTaker().left.peek().getObject()).getColour();
                temp1=Clown.getCareTaker().left.pop();}
            
            else if(Clown.getCareTaker().left.peek().getObject() instanceof Plate)
                {c1=((Plate)Clown.getCareTaker().left.peek().getObject()).getColour();
                temp1=Clown.getCareTaker().left.pop();}
            
            if(Clown.getCareTaker().left.peek().getObject() instanceof Ball)
                {c2=((Ball)Clown.getCareTaker().left.peek().getObject()).getColour();
                temp2=Clown.getCareTaker().left.pop();}
            
            else if(Clown.getCareTaker().left.peek().getObject() instanceof Plate)
                {c2=((Plate)Clown.getCareTaker().left.peek().getObject()).getColour();
                temp2=Clown.getCareTaker().left.pop();}
            
            if(Clown.getCareTaker().left.peek().getObject() instanceof Ball)
                c3=((Ball)Clown.getCareTaker().left.peek().getObject()).getColour();
            
            else if(Clown.getCareTaker().left.peek().getObject() instanceof Plate)
                c3=((Plate)Clown.getCareTaker().left.peek().getObject()).getColour();
            
                Clown.getCareTaker().left.push(temp2);
                Clown.getCareTaker().left.push(temp1);
            if(c1==c2 && c2==c3){
                
              update(circus);
                
            pop1=Clown.getCareTaker().left.pop().getObject();
            if(pop1 instanceof Ball){
                circus.setX(circus.getX()-50);
                ((Ball)pop1).setVisible(false);
            }
            else if(pop1 instanceof Plate){
                circus.setX(circus.getX()-30);
                ((Plate)pop1).setVisible(false);
            }
            pop2=Clown.getCareTaker().left.pop().getObject();
            if(pop2 instanceof Ball){
                circus.setX(circus.getX()-50);
                ((Ball)pop2).setVisible(false);
            }
            else if(pop2 instanceof Plate){
                circus.setX(circus.getX()-30);
                ((Plate)pop2).setVisible(false);
            }
            pop3=Clown.getCareTaker().left.pop().getObject();
            if(pop3 instanceof Ball){
                circus.setX(circus.getX()-50);
                ((Ball)pop3).setVisible(false);
            }
            else if(pop3 instanceof Plate){
                circus.setX(circus.getX()-30);
                ((Plate)pop3).setVisible(false);
            }
            
            }
            }
        if(Clown.getCareTaker().right.size()>=3){
                
            if(Clown.getCareTaker().right.peek().getObject()instanceof Ball)
                {c1=((Ball)Clown.getCareTaker().right.peek().getObject()).getColour();
                temp1=Clown.getCareTaker().right.pop();}
            
            else if(Clown.getCareTaker().right.peek().getObject() instanceof Plate)
                {c1=((Plate)Clown.getCareTaker().right.peek().getObject()).getColour();
                temp1=Clown.getCareTaker().right.pop();}
            
            if(Clown.getCareTaker().right.peek().getObject() instanceof Ball)
                {c2=((Ball)Clown.getCareTaker().right.peek().getObject()).getColour();
                temp2=Clown.getCareTaker().right.pop();}
            
            else if(Clown.getCareTaker().right.peek().getObject() instanceof Plate)
                {c2=((Plate)Clown.getCareTaker().right.peek().getObject()).getColour();
                temp2=Clown.getCareTaker().right.pop();}
            
            if(Clown.getCareTaker().right.peek().getObject() instanceof Ball)
                c3=((Ball)Clown.getCareTaker().right.peek().getObject()).getColour();
            
            else if(Clown.getCareTaker().right.peek().getObject() instanceof Plate)
                c3=((Plate)Clown.getCareTaker().right.peek().getObject()).getColour();
            
                Clown.getCareTaker().right.push(temp2);
                Clown.getCareTaker().right.push(temp1);
            if(c1==c2 && c2==c3){
                update(circus);
                
            pop1=Clown.getCareTaker().right.pop().getObject();
            if(pop1 instanceof Ball){
                circus.setY(circus.getY()-50);
                ((Ball)pop1).setVisible(false);
            }
            else if(pop1 instanceof Plate){
                circus.setY(circus.getY()-30);
                ((Plate)pop1).setVisible(false);
            }
            pop2=Clown.getCareTaker().right.pop().getObject();
            if(pop2 instanceof Ball){
                circus.setY(circus.getY()-50);
                ((Ball)pop2).setVisible(false);
            }
            else if(pop2 instanceof Plate){
                circus.setY(circus.getY()-30);
                ((Plate)pop2).setVisible(false);
            }
            pop3=Clown.getCareTaker().right.pop().getObject();
            if(pop3 instanceof Ball){
                circus.setY(circus.getY()-50);
                ((Ball)pop3).setVisible(false);
            }
            else if(pop3 instanceof Plate){
                circus.setY(circus.getY()-30);
                ((Plate)pop3).setVisible(false);
            }
            
            }
            
            }
    }

    @Override
    public void update(Circus circus) {
        circus.setScore(circus.getScore()+1);
          
    }
    
    @Override
    public void downdate(Circus circus){
        circus.setScore(circus.getScore()-1);  
    }
}
