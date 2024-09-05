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

        int current = 1;

        int[] sAndL = new int[boardsize];
        for(int i = 0; i < boardsize; i++){
            sAndL[i] = -1;
        }
        for(int i = 0; i < ladders.length; i++){
            sAndL[ladders[i][0] - 1] = ladders[i][1];
        }
        for(int i = 0; i < snakes.length; i++){
            sAndL[snakes[i][0] - 1] = snakes[i][1];
        }

        while (current != boardsize) {
            if(toSearch.isEmpty()){
                toSearch = nextLevel;
                nextLevel = new LinkedList<Integer>();
                level ++;
            }
            if(current + 6 < boardsize){
                break;
            }
            for (int i = current + 1; i < current + 5; i++) {
                if (sAndL[i] != -1) {
                    toSearch.add(sAndL[i]);
                }
                else{
                    break;
                }
            }
            if(sAndL[current + 6 - 1] != -1){
                toSearch.add(sAndL[current + 6]);
            }
            else {
                toSearch.add(current + 6);
            }
            current = toSearch.remove();
        }

        return 0;
    }

//    public void checkSpace(Space Parent, Queue toSearch, Space space, int boardsize){
//        if (space.getNum() <= boardsize) {
//            for(int j = 0; j < ladders.length; j++) {
//                if (ladders[j][0] == i) {
//                    toSearch.add(ladders[j][1]);
//                }
//            }
//            for(int j = 0; j < snakes.length; j++) {
//                if (snakes[j][0] == i) {
//                    toSearch.add(snakes[j][1]);
//                }
//            }
//        }
//        else{
//            break;
//        }
//    }


}
