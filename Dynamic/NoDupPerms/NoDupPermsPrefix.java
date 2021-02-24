package Dynamic.NoDupPerms;

import java.util.ArrayList;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 24 오전 9:55
 */
public class NoDupPermsPrefix {

    ArrayList <String> getPerms(String str) {
        ArrayList<String> result = new ArrayList<String>();
        getPerms("", str, result);
        return result;
    }

    void getPerms(String prefix, String remainder, ArrayList<String> result) {
        if (remainder.length() == 0) result.add(prefix);
        int len = remainder.length();

        for(int i = 0; i < len ; i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            char c = remainder.charAt(i);
            getPerms(prefix + c, before + after, result);
        }
    }

}