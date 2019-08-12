import java.util.HashMap;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/12
 * Time: 22:59
 * Description:
 */
class Solution {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() == 0) return true;
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();
        int len = arrS.length;
        for (int i = 0; i < len; i++) {
            Character c = mapS.get(arrS[i]);
            if (c != null && c != arrT[i]) {
                return false;
            }
            c = mapT.get(arrT[i]);
            if (c != null && c != arrS[i]) {
                return false;
            }
            mapS.put(arrS[i], arrT[i]);
            mapT.put(arrT[i], arrS[i]);
        }
        return true;
    }

}
