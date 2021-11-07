package DFS2BFS;//�ֵ� wordList �дӵ��� beginWord �� endWord �� ת������ ��һ������������γɵ����У�
//
// 
// �����е�һ�������� beginWord �� 
// ���������һ�������� endWord �� 
// ÿ��ת��ֻ�ܸı�һ����ĸ�� 
// ת�������е��м䵥�ʱ������ֵ� wordList �еĵ��ʡ� 
// 
//
// ������������ beginWord �� endWord ��һ���ֵ� wordList ���ҵ��� beginWord �� endWord �� ���ת������ ��
//�� ������Ŀ �����������������ת�����У����� 0�� 
// 
//
// ʾ�� 1�� 
//
// 
//���룺beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//�����5
//���ͣ�һ�����ת�������� "hit" -> "hot" -> "dot" -> "dog" -> "cog", �������ĳ��� 5��
// 
//
// ʾ�� 2�� 
//
// 
//���룺beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//�����0
//���ͣ�endWord "cog" �����ֵ��У������޷�����ת���� 
//
// 
//
// ��ʾ�� 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord��endWord �� wordList[i] ��СдӢ����ĸ��� 
// beginWord != endWord 
// wordList �е������ַ��� ������ͬ 
// 
// Related Topics ����������� ��ϣ�� �ַ��� 
// ? 877 ? 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Set<String> wordSet = new HashSet<String>(wordList);
       if(wordSet.size() == 0 || !wordSet.contains(endWord)){
           return 0;
       }
       wordSet.remove(beginWord);
        LinkedList<String> queue = new LinkedList<>();
       queue.addLast(beginWord);
       Set<String> visited = new HashSet<String>();
       visited.add(beginWord);
       int step = 1;
       while(!queue.isEmpty()){
           int currsize = queue.size();
           for(int i = 0; i < currsize; i++){
               String currWord = queue.removeFirst();
               if(changeWordEveryPosition(currWord, endWord, visited, wordSet, queue)){
                   return step + 1;
               }
           }
           step++;
       }
       return 0;
    }

    private boolean changeWordEveryPosition(String currWord, String endWord, Set<String> visited,
                                            Set<String> wordSet, LinkedList<String> queue){
        char[] charArray = currWord.toCharArray();
        for(int i = 0; i < endWord.length(); i++){
            char oldChar = charArray[i];
            for(char j = 'a'; j <= 'z'; j++){
               if(oldChar == j){
                   continue;
               }
               charArray[i] = j;
               String nextWord = String.valueOf(charArray);
               if(wordSet.contains(nextWord)){
                   if(nextWord.equals(endWord)){
                      return true;
                   }
                   if(!visited.contains(nextWord)){
                       queue.addLast(nextWord);
                       visited.add(nextWord);
                   }
               }
            }
            //�ָ�
            charArray[i] = oldChar;
        }
     return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
