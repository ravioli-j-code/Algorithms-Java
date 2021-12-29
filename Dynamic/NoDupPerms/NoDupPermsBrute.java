package Dynamic.NoDupPerms;

import java.util.ArrayList;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 24 오전 9:48
 */
public class NoDupPermsBrute {

    // str : qwert

    ArrayList <String> getPerms(String str) {
        if (str == null) return null; // substring 하니까 null에 대한 인자값 처리

        ArrayList<String> permutations = new ArrayList<String>();
        if (str.length() == 0) { // remainder 가 빈문자열일 경우
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); // 첫번재 문자를 알아낸다. q > w > e > r > t

        String remainder = str.substring(1); // wert > ert > rt > t > ''
        ArrayList<String> words = getPerms(remainder);

        for (String word: words ) {
            for ( int j = 0; j <= word.length() ; j++ ) {
                String s = insertCharAt(word, first, j);
                // ("", t, 0) : t [t] > (t, r, 0) : r, (t, r, 1) : tr [ r, tr ] >
                // (r, e, 0) : e, (r, e, 1): re, (tr, e, 0) : etr , (tr, e, 1) : ter , (tr, e, 2) : tre  [e, re, etr, ter, tre ] .....

                permutations.add(s);
            }
        }
        return permutations;
    }

    /* 문자 c 를 i번째 인덱스에 넣는다. */
    String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i); // i 가 0 경우 ""
        String end = word.substring(i); // i 가 0  인 경우 ""
        return start + c + end; // i 가 0인 경우 c 그대로 리턴됨.
    }

}