package DFS2BFS;//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 哈希表 字符串 
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
            //恢复
            charArray[i] = oldChar;
        }
     return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
