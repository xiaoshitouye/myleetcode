package hash;

import java.util.*;

class Solution_49 {
    public static void main(String[] args) {
//        List<List<String>> groupAnagrams = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        List<List<String>> groupAnagrams = groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(Arrays.toString(new List[]{groupAnagrams}));

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        if(strs == null || strs.length ==0) return new ArrayList<>();
        Map<String, List<String>> resmap = new HashMap<>();
        for(String str : strs){
            char[] chararray = str.toCharArray();
            Arrays.sort(chararray);
            String key = String.valueOf(chararray);
            if(!resmap.containsKey(key)) resmap.put(key, new ArrayList<>());
            resmap.get(key).add(str);
        }
        return new ArrayList<>(resmap.values());
    }
}