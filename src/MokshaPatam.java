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
        // Queue to store spaces to search for BFS
        Queue<Integer> toSearch = new LinkedList<Integer>();

        // Arrays which hold information about each space that can be checked with constant time
        int[] info = new int[boardsize + 1];
        boolean[] visited = new boolean[boardsize + 1];
        int[] depth = new int[boardsize + 1];

        // int to store the current space
        int current;

        // Add the first square to the queue
        toSearch.add(1);
        // Give starting depth of 0
        depth[1] = 0;

        // Fill in ladder and snake arrays
        for(int i = 0; i < ladders.length; i++){
            info[ladders[i][0]] = ladders[i][1];
        }
        for(int i = 0; i < snakes.length; i++){
            info[snakes[i][0]] = snakes[i][1];
        }

        // Main loop, traverses a simplified version of the game tree
        do {
            // If the queue runs out, the board has an infinite loop, so return -1
            if(toSearch.isEmpty()){
                return -1;
            }
            // Change to new current square
            current = toSearch.remove();
            // If within one roll, return current depth + 1
            if(current == boardsize){
                return depth[current];
            }
            if(current + 6 >= boardsize){
                return depth[current] + 1;
            }
            // Check the next 6 spaces for snakes and ladders
            for (int i = current + 1; i <= current + 6; i++) {
                // Check if the space is a snake or ladder, and if it has been visited
                if (info[i] != 0 && !visited[i]) {
                    toSearch.add(info[i]);
                    visited[i] = true;
                    depth[info[i]] = depth[current] + 1;
                }
            }
            // Add the further possible space that isn't a snake or ladder to the queue
            for (int i = current + 6; i > current; i--){
                if(!visited[i] && info[i] == 0){
                    toSearch.add(i);
                    visited[i] = true;
                    depth[i] = depth[current] + 1;
                    break;
                }
            }
            // Continue looping until current is the last space
        } while (current != boardsize);
        // Return the depth of the current space
        return depth[current];
    }


}