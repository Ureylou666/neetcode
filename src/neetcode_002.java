import java.util.HashMap;

/** 
* @Description:
* @Author: Urey Lou
* @Date: 2024-09-19
* @Param: 
* @return: 
*/
public class neetcode_002 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c:s.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        for (Character c:t.toCharArray()) if (!map.containsKey(c)) return false; else {
            map.put(c, map.get(c)-1);
            if (map.get(c) < 0) return false;
        }
        return true;
    }
}
