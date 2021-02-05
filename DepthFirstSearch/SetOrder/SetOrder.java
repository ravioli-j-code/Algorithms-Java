package DepthFirstSearch.SetOrder;

import java.util.ArrayList;
import java.util.Stack;

public class SetOrder {
    
    Stack findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    Stack orderProjects(ArrayList<Project> projects) {
        Stack stack = new Stack();
        for (Project project: projects) {
            if(project.getState() == Project.State.BLANK) {
                if (!doDFS(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }


    boolean doDFS(Project project, Stack stack ) {
        if (project.getState() == Project.State.PARTIAL) {
            return false; // cycle
        }
        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL) ;
            ArrayList<Project> children = project.getChildren();
            for (Project child : children) {
                if (!doDFS(child, stack)) {
                    return false;
                }
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }

    Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    


}
