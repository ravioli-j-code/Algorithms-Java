package Dynamic.DupPerms;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 24 오전 10:46
 */
public class DupPerms {

    ArrayList <String> pringPerms(String s) {
        ArrayList <String> result = new ArrayList <String>();
        HashMap <Character, Integer> map = buildFreqTable(s);
        printPerms(map, "", s.length(), result);
        return result;
    }

    /**
     * 문자열의 빈도를 세는 함수
     * @param s
     * @return
     */
    HashMap <Character, Integer> buildFreqTable(String s) {
        HashMap <Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1); // 문자열이 한번 출현하면 value는 1
        }
        return map;
    }

    /**
     *
     * @param map 문자열과 빈도가 기록된 매핑 정보
     * @param prefix
     * @param remaining 문자열의 사이즈
     * @param result 리턴할 집합
     */
    void printPerms(HashMap <Character, Integer> map, String prefix, int remaining, ArrayList <String> result) {
        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        // distinct 한 문자열 목록을 가져온다.
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1); // 문자열이 중복인 경우 해당 문자열의 빈도를 낮추고 재귀호출한다.
                printPerms(map, prefix + c, remaining - 1, result);
                map.put(c, count); // 원상복구함
            }
        }
    }

}