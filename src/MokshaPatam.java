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
        toSearch.add(1);

        int[][] info = new int[boardsize][2];
        for(int i = 0; i < boardsize; i++){
            info[i][0] = -1;
            info[i][1] = 0;
        }
        for(int i = 0; i < ladders.length; i++){
            info[ladders[i][0] - 1][0] = ladders[i][1];
        }
        for(int i = 0; i < snakes.length; i++){
            info[snakes[i][0] - 1][0] = snakes[i][1];
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
                if (info[i - 1][0] != -1 && info[i - 1][1] == 0) {
                    nextLevel.add(info[i - 1][0]);
                    info[i - 1][1] = 1;
                }
            }
            if(info[current + 6][0] != -1 && info[current+ 6][1] == 0){
                nextLevel.add(info[current + 6 - 1][0]);
                info[current + 6][1] = 1;
            }
            else {
                nextLevel.add(current + 6);
            }
        }

        return level;
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
