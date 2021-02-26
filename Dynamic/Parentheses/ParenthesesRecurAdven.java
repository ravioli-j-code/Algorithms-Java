package Dynamic.Parentheses;

import java.util.ArrayList;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 26 오전 10:14
 */
public class ParenthesesRecurAdven {

     ArrayList<String> generateParentheses(int count) {
        char[] str = new char[count * 2] ;
        ArrayList<String> list = new ArrayList<String>();
        addParentheses(list, count, count, str, 0);
        return list;
    }

    void addParentheses(ArrayList <String> list, int leftRem, int rightRem, char[] str, int index ) {
        if (leftRem < 0 || rightRem < leftRem ) return;
        if (leftRem == 0 && rightRem == 0 ) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            addParentheses(list, leftRem - 1, rightRem, str, index + 1 );

            str[index] = ')';
            addParentheses(list, leftRem, rightRem + 1, str, index + 1 );
        }
    }

}