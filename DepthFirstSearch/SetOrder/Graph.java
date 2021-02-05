package DepthFirstSearch.SetOrder;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private ArrayList nodes= new ArrayList();
    private HashMap map = new HashMap();

    public Project getOrCreateNode(String name) {
        if ( !map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return (Project) map.get(name);
    }
    
    public void addEdge(String startName, String endName){
        Project start = getOrCreateNode(startName);
        Project end  = getOrCreateNode(endName);
        start.addNeighbor(end);
    }
    public ArrayList getNodes() {return nodes;}
}
