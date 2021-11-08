package DFS2BFS;//һ������������һ������8���ַ����ַ�����ʾ������ÿ���ַ������� "A", "C", "G", "T"�е�����һ����
//
// ��������Ҫ����һ���������еı仯��һ�λ���仯��ζ��������������е�һ���ַ������˱仯�� 
//
// ���磬����������"AACCGGTT" �仯�� "AACCGGTA" ��������һ�λ���仯�� 
//
// ���ͬʱ��ÿһ�λ���仯�Ľ��������Ҫ��һ���Ϸ��Ļ��򴮣����ý������һ������⡣ 
//
// ���ڸ���3������ �� start, end, bank���ֱ������ʼ�������У�Ŀ��������м�����⣬���ҳ��ܹ�ʹ��ʼ�������б仯ΪĿ�����������������ٱ�
//������������޷�ʵ��Ŀ��仯���뷵�� -1�� 
//
// ע�⣺ 
//
// 
// ��ʼ��������Ĭ���ǺϷ��ģ�����������һ��������ڻ�����С� 
// ���һ����ʼ����������Ҫ��α仯����ô��ÿһ�α仯֮��Ļ������ж������ǺϷ��ġ� 
// �ٶ���ʼ����������Ŀ����������ǲ�һ���ġ� 
// 
//
// 
//
// ʾ�� 1�� 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//����ֵ: 1
// 
//
// ʾ�� 2�� 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//����ֵ: 2
// 
//
// ʾ�� 3�� 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//����ֵ: 3
// 
// Related Topics ����������� ��ϣ�� �ַ��� 
// ? 88 ? 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_433 {
    public static void main(String[] args) {

    }
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        Set<String> bankSet = new HashSet<String>();
        for(String b : bank){
            bankSet.add(b);
        }
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        int step = 0;
        Set<String> visited = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.addFirst(start);
        visited.add(start);
        while(!queue.isEmpty()){
            int curSize = queue.size();
            for(int k = 0; k < curSize; k++){
                String curString = queue.removeLast();
                if(curString.equals(end)) return step;
                char[] charArr = curString.toCharArray();
                for(int i = 0; i < end.length(); i++){
                    char oldChar = charArr[i];
                    for(int j = 0; j < charSet.length; j++){
                        charArr[i] = charSet[j];
                        String next = String.valueOf(charArr);
                        if(!visited.contains(next) && bankSet.contains(next)){
                             visited.add(next);
                             queue.addFirst(next);
                        }
                        charArr[i] = oldChar;
                    }
                }
                step++;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
