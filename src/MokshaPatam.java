/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        Queue<Integer> toSearch = new LinkedList<Integer>();
        Queue<Integer> nextLevel = new LinkedList<Integer>();
        int level = 0;

        int[] info = new int[boardsize + 1];
        boolean[] visited = new boolean[boardsize + 1];
        int[] depth = new int[boardsize + 1];

        int current = 1;
        toSearch.add(1);
        depth[1] = 1;

        for(int i = 0; i < ladders.length; i++){
            info[ladders[i][0]] = ladders[i][1];
        }
        for(int i = 0; i < snakes.length; i++){
            info[snakes[i][0]] = snakes[i][1];
        }

        while (current != boardsize) {
            if(toSearch.isEmpty()){
                toSearch = nextLevel;
                nextLevel = new LinkedList<Integer>();
                level ++;
            }
            current = toSearch.remove();
            if(current + 6 >= boardsize){
                level ++;
                break;
            }
            for (int i = current + 1; i <= current + 5; i++) {
                if (info[i] != 0 && !visited[i]) {
                    if(info[i] == boardsize){
                        level ++;
                        return level;
                    }
                    nextLevel.add(info[i]);
                    visited[i] = true;
                }
            }
            if(info[current + 6] != 0 && visited[current+ 6] == false){
                nextLevel.add(current + 6);
                visited[current + 6] = true;
            }
            else {
                nextLevel.add(current + 6);
            }
        }

        return level;
    }

}
