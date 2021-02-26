package ProgrammersQues.PickCraneDolls;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 26 오후 1:52
 */
public class PickCrainDolls {

     public int getRemovedDollCount(int[][] board, int[] moves) {
        int removedDollCount = 0;
        int prev = -1;

        for(int i = 0; i < moves.length ; i++ ) {
            int inner = -2;
            int move = moves[i]-1;
            for(int j = 0; j < board.length ; j++ ) {
                if (inner > 0) {
                    inner = board[j][move];
                    board[j][move] = 0;
                    continue;
                };
            }
            if (prev == inner) {
                removedDollCount += 1;
                prev = -1; // 초기화
            } else {
                prev = inner;
            }
        }
        return removedDollCount;
    }

}