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
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))//put方法返回值：上一次与 key 关联的值
                return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
