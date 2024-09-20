import java.util.*;

/** 
* @Description:
* @Author: Urey Lou
* @Date: 2024-09-19
* @Param: 
* @return: 
*/
public class neetcode_005 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer>[] counts = new List[nums.length + 1];
        for (int i=0;i<counts.length;i++) counts[i] = new ArrayList<>();
        for (int i : map.keySet()) counts[map.get(i)].add(i);
        int[] result = new int[k];
        int index = 0;
        for (int i = counts.length - 1; i > 0; i--)
            if (!counts[i].isEmpty()) {
                for (int j : counts[i]) {
                    result[index] = j;
                    index++;
                }
                if (index == k) break;
            }
        return result;
    }

}
