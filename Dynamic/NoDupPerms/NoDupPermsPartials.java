package Dynamic.NoDupPerms;

import java.util.ArrayList;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 24 오전 9:53
 */
public class NoDupPermsPartials {

    ArrayList <String> getPerms(String remainder) {

        int len = remainder.length();
        ArrayList<String> result = new ArrayList<String>();

        if (len == 0) {
            result.add("");
            return result;
        }

        for (int i=0; i < len; i++) {
            // 문자열의 문자를 하나씩 뺀 나머지의 부분집합을 구해서 뺀 아이를 다시 넣어줌
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            ArrayList<String> partials = getPerms(before + after);

            for( String partial : partials) {
              result.add(remainder.charAt(i) + partial);
            }
        }

        return result;
    }

}