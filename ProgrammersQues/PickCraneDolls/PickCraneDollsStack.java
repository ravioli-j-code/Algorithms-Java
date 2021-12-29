package ProgrammersQues.PickCraneDolls;

import java.util.*;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 26 오후 2:58
 */
public class PickCraneDollsStack {

    public int getRemovedDollCount(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();

        for(int i = 0; i < moves.length ; i++ ) {
            if (moves[i] == 0) continue;
            int doll = getDoll(board, moves[i] - 1, 0);
            if (doll == 0) continue;
            if (!bucket.empty() && bucket.peek() == doll) {
                answer += 2;
                bucket.pop();
            } else {
                bucket.push(doll);
            }
        }
        return answer;
    }

    int getDoll(int[][] board, int move, int index){
        // 리턴 조건
        if (board.length - 1 < index) return 0;
        int d = board[index][move];
        if (d == 0) {
            return getDoll(board, move, index + 1);
        } else {
            board[index][move] = 0;
            return d;
        }
    }

}