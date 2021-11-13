package string;//����һ�ֹ��� pattern ��һ���ַ��� str ���ж� str �Ƿ���ѭ��ͬ�Ĺ��ɡ�
//
// ����� ��ѭ ָ��ȫƥ�䣬���磬 pattern ���ÿ����ĸ���ַ��� str �е�ÿ���ǿյ���֮�������˫�����ӵĶ�Ӧ���ɡ� 
//
// ʾ��1: 
//
// ����: pattern = "abba", str = "dog cat cat dog"
//���: true 
//
// ʾ�� 2: 
//
// ����:pattern = "abba", str = "dog cat cat fish"
//���: false 
//
// ʾ�� 3: 
//
// ����: pattern = "aaaa", str = "dog cat cat dog"
//���: false 
//
// ʾ�� 4: 
//
// ����: pattern = "abba", str = "dog dog dog dog"
//���: false 
//
// ˵��: 
//����Լ��� pattern ֻ����Сд��ĸ�� str �������ɵ����ո�ָ���Сд��ĸ�� 
// Related Topics ��ϣ�� �ַ��� 
// ? 398 ? 0
/*
put(K key, V value)

���أ���һ���� key ������ֵ�����û����� key ��ӳ���ϵ���򷵻� null���������ʵ��֧�� null ֵ���򷵻� null Ҳ���ܱ�ʾ��ӳ����ǰ�� null �� key ������
        Map<String, Integer> map = new HashMap<String, Integer>();
        System.out.println(map.put("a", 1));
        System.out.println(map.put("b", 2));
        System.out.println(map.put("a", 3));
        System.out.println(map.put("b", 4));
        System.out.println(map.put("c", 22));
        ���н��:
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
            if(ch2str.containsKey(ch) && !ch2str.get(ch).equals(str)){//string�ж���equals
                return false;
            }
            str2ch.put(str, ch);
            ch2str.put(ch, str);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
