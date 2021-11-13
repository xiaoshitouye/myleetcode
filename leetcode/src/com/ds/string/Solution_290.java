package string;//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 字符串 
// ? 398 ? 0
/*
put(K key, V value)

返回：上一次与 key 关联的值，如果没有针对 key 的映射关系，则返回 null。（如果该实现支持 null 值，则返回 null 也可能表示此映射以前将 null 与 key 关联）
        Map<String, Integer> map = new HashMap<String, Integer>();
        System.out.println(map.put("a", 1));
        System.out.println(map.put("b", 2));
        System.out.println(map.put("a", 3));
        System.out.println(map.put("b", 4));
        System.out.println(map.put("c", 22));
        运行结果:
        null
        null
        1
        2
        null
 */


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba" ,"dog cat cat dog"));
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(strs.length != pattern.length()){
            return false;
        }
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            char ch = pattern.charAt(i);
            if(str2ch.containsKey(str) && str2ch.get(str) != ch){
                return  false;
            }
            if(ch2str.containsKey(ch) && !ch2str.get(ch).equals(str)){//string判断用equals
                return false;
            }
            str2ch.put(str, ch);
            ch2str.put(ch, str);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
