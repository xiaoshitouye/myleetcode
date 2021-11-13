package string;
//���������ַ��� s �� p���ҵ� s ������ p �� ��λ�� ���Ӵ���������Щ�Ӵ�����ʼ�����������Ǵ������˳��
//
// ��λ�� ָ����ͬ��ĸ�������γɵ��ַ�����������ͬ���ַ������� 
//
// 
//
// ʾ�� 1: 
//
// 
//����: s = "cbaebabacd", p = "abc"
//���: [0,6]
//����:
//��ʼ�������� 0 ���Ӵ��� "cba", ���� "abc" ����λ�ʡ�
//��ʼ�������� 6 ���Ӵ��� "bac", ���� "abc" ����λ�ʡ�
// 
//
// ʾ�� 2: 
//
// 
//����: s = "abab", p = "ab"
//���: [0,1,2]
//����:
//��ʼ�������� 0 ���Ӵ��� "ab", ���� "ab" ����λ�ʡ�
//��ʼ�������� 1 ���Ӵ��� "ba", ���� "ab" ����λ�ʡ�
//��ʼ�������� 2 ���Ӵ��� "ab", ���� "ab" ����λ�ʡ�
// 
//
// 
//
// ��ʾ: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s �� p ������Сд��ĸ 
// 
// Related Topics ��ϣ�� �ַ��� �������� 
// ? 643 ? 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_438 {
    private  Map<Character, Integer> map;
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
    public static  List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {
            char chr = s.charAt(i);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }
        int start = 0, end = 0;
        while (start < s.length() && end < s.length()) {
            if (end - start < p.length()) {
                end++;
            } else {
                start++;// �������ַ������ȵ����ַ���p�ĳ���,����С���߽�
            }
            if (end - start == p.length() && isAnagrams(s.substring(start, end), map)) {
                resultList.add(start);
            }
        }
        return resultList;
    }
    private static  boolean isAnagrams(String window, Map<Character, Integer> pmap) {
        Map<Character, Integer> winMap = new HashMap<Character, Integer>();
        for(int j = 0; j < window.length(); j++) {
            char chr = window.charAt(j);
            winMap.put(chr, winMap.getOrDefault(chr, 0) + 1);
        }
        for(char chrO : pmap.keySet()){
            if(winMap.get(chrO) != pmap.get(chrO)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
