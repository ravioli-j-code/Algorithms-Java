package DepthFirstSearch.SetOrder;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {

    public enum State {COMPLETE, PARTIAL, BLANK};
    private State state = State.BLANK;
    public State getState() {return state;}
    public void setState(State st) {
        state = st;
    }
    
    private ArrayList children = new ArrayList();
    private HashMap map = new HashMap();
    private String name;
    
    public Project(String n) {name = n;}
    public void addNeighbor(Project node){
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
        }
    }

    public String getName() {return name;}
    public ArrayList getChildren() {return children;}
    

}
