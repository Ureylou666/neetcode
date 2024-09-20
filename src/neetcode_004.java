import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/** 
* @Description:
* @Author: Urey Lou
* @Date: 2024-09-19
* @Param: 
* @return: 
*/
public class neetcode_004 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) return result;
        for (int i = 0; i<strs.length; i++) {
            String s = convert(strs[i]);
            if (map.containsKey(s)) {
                List<Integer> temp = map.get(s);
                temp.add(i);
                map.put(s, temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(s,temp);
            }
        }
        for (String key : map.keySet()) {
            List<String> temp = new ArrayList<>();
            for (int i:map.get(key)) temp.add(strs[i]);
            result.add(temp);
        }
        return result;
    }

    private String convert(String s){
        int[] a = new int[26];
        Arrays.fill(a, 0);
        for (Character c: s.toCharArray()) a[c-'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<26;i++) {
            sb.append('a'+i);
            sb.append(a[i]);
        }
        return sb.toString();
    }

}