package Dynamic.RobotsOnGrid;

import java.util.ArrayList;
import java.util.HashSet;
import java.awt.Point;

public class RobotsOnGridRevised {


    public ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<Point>();
        HashSet<Point> failedPoints = new HashSet<Point>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }
    
    public boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        /* 범위를 지나갔거나 지나갈 수 없으면 false를 반환한다. */
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }
    
        Point p = new Point(row, col);
        
        /* 이미 방문했다면 false를 반환한다. */
        if (failedPoints.contains(p)) {
            return false;
        }
    
        boolean isAtOrigin = (row == 0) && (col == 0);
        
        /* 경로가 존재하면 현재 위치를 더한다. */
        if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || 
                getPath(maze, row - 1, col, path, failedPoints)) {
            
            path.add(p);
            return true;
        }
    
        failedPoints.add(p); // 캐시 결과를 저장함
        return false;
    }


}
