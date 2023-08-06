package Graphs.DFS;

//https://leetcode.com/problems/robot-room-cleaner/

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {

    class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 31*hash + this.row;
            hash = 31*hash + this.col;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            Pair o = (Pair) obj;
            return this.hashCode() == o.hashCode();
        }
    }

    public void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    void clean(int row, int col, int direction, Set<Pair> visited, Robot robot){
        int[][] directions = {{-1, 0},{0, 1},{1, 0},{0, -1}};
        robot.clean();
        visited.add(new Pair(row, col));

        for(int i=0; i<4; i++){
            int newDir = (direction + i) % 4;
            int newRow = row + directions[newDir][0], newCol = col + directions[newDir][1];
            if(!visited.contains(new Pair(newRow, newCol))) {
                if(robot.move()){
                    clean(newRow, newCol, newDir, visited, robot);
                    goBack(robot);

                }
            }
            robot.turnRight();
        }


    }

    public void cleanRoom(Robot robot) {
        Set<Pair> visited = new HashSet<>();
        clean(0, 0, 0, visited, robot);
    }

    interface Robot {
        public boolean move();
        public void turnLeft();
        public void turnRight();
        public void clean();
    }
}

