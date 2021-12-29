package Dynamic.Parentheses;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 26 오전 10:13
 */
public class ParenthesesRecur {

    Set <String> generatePatterns(int remaining) {

        Set<String> set = new HashSet <>();

        if(remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generatePatterns(remaining - 1);
            for (String str : prev ) {
                for (int i= 0; i < str.length() ; i++ ) {
                    if ( str.charAt(i) == '(') {
                        String s  = insertInside(str, i);
                        set.add(s);
                    }
                }
            }
        }
        return set;
    }

    String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1) ;
        String right = str.substring(leftIndex + 1, str.length() ) ;
        return left + "()" + right;
    }

}