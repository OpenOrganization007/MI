
import java.util.*;
public class Memento<T> {
    private T state;
    public T getState() {
            return state;
        }
        
     public void setState(T state) {
            this.state = state;
        }
};

public class Originator<T> {
    private T state;
    
    public Memento<T> createMemento() {
            Memento<T> m= new Memento<T>();
            m.setState(state);
            return m;
        }
        
    public void setMemento( Memento<T> m) {
            state = m.getState();    
        }
        
    public void setState( T s) {
            state = s ;
        }
        
    public void ShowState() {
            System.out.println("Current State is "+state);
        }
        
};

public class CareTaker<T> {
    private List<Memento<T> > list = new List<Memento<T> >();
    
    public void saveState(Originator<T> orig) {
            list.add(orig.createMemento());
        }
        
    public void restoreState(Originator<T> orig, int no) {
            orig.setMemento(list[no]);
        }
        
};


public class Main{

     public static void main(String []args){
        Originator<String> orig = new Originator<String>();
        CareTaker<String> c = new CareTaker<String>();
        orig.setState("state0");
        c.saveState(orig); //save state of the originator
        orig.ShowState();

        orig.setState("state1");
        c.saveState(orig); //save state of the originator
        orig.ShowState();

        orig.setState("state2");
        c.saveState(orig); //save state of the originator
        orig.ShowState();

        //restore state of the originator
        c.restoreState(orig, 0);
        orig.ShowState();  //shows state0
     }
};
