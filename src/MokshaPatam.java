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
        int current = 1;

        while (current != boardsize) {
            for (int i = current + 1; i <= current + 6; i++) {
                if (i <= boardsize) {
                    for(int j = 0; j < ladders.length; j++) {
                        if (ladders[j][0] == i) {
                            toSearch.add(ladders[j][1]);
                        }
                    }
                    for(int j = 0; j < snakes.length; j++) {
                        if (snakes[j][0] == i) {
                            toSearch.add(snakes[j][1]);
                        }
                    }
                }

            }
        }

        return 0;
    }


}
