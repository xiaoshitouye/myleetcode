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
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))//put��������ֵ����һ���� key ������ֵ
                return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
