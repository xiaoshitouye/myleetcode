package DFS2BFS;//���ֵ� wordList ��ɴӵ��� beginWord ������ endWord ת����һ����ʾ�˹��̵� ת������ ����ʽ���� beginWord -> s
//1 -> s2 -> ... -> sk �����ĵ������У������㣺 
//
// 
// 
// 
// ÿ�����ڵĵ���֮����е�����ĸ��ͬ�� 
// ת�������е�ÿ������ si��1 <= i <= k���������ֵ� wordList �еĵ��ʡ�ע�⣬beginWord �������ֵ� wordList �еĵ�
//�ʡ� 
// sk == endWord 
// 
//
// ������������ beginWord �� endWord ���Լ�һ���ֵ� wordList �������ҳ����������д� beginWord �� endWord ��
// ���ת������ �����������������ת�����У�����һ�����б�ÿ�����ж�Ӧ���Ե����б� [beginWord, s1, s2, ..., sk] ����ʽ���ء� 
//
// 
//
// ʾ�� 1�� 
//
// 
//���룺beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//�����[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
//���ͣ����� 2 ����̵�ת�����У�
//"hit" -> "hot" -> "dot" -> "dog" -> "cog"
//"hit" -> "hot" -> "lot" -> "log" -> "cog"
// 
//
// ʾ�� 2�� 
//
// 
//���룺beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//�����[]
//���ͣ�endWord "cog" �����ֵ� wordList �У����Բ����ڷ���Ҫ���ת�����С�
// 
//
// 
//
// ��ʾ�� 
//
// 
// 1 <= beginWord.length <= 7 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord��endWord �� wordList[i] ��СдӢ����ĸ��� 
// beginWord != endWord 
// wordList �е����е��� ������ͬ 
// 
// 
// 
// Related Topics ����������� ��ϣ�� �ַ��� ���� 
// ? 505 ? 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;

public class Solution_126 {
    public static void main(String[] args) {
        List<List<String>> res = findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(res);
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        // ��Ϊ��Ҫ�����ж���չ���ĵ����Ƿ��� wordList ������Ҫ�� wordList �����ϣ����������Ϊ���ֵ䡹
        Set<String> dict = new HashSet<>(wordList);
        // ���������ж�
        if (!dict.contains(endWord)) {
            return res;
        }
        // ��Ϊ�� beginWord ��ʼ��չ����� dict ��һ���������� beginWord
        dict.remove(beginWord);
        // �� 1 ����������ȱ�������ͼ
        // Ϊ�˱����¼����Ҫ�ıߣ�������Ҫ��¼��չ���ĵ������ڵڼ�����չ��ʱ��õ��ģ�key�����ʣ�value���ڹ�����ȱ����ĵڼ���
        // steps ��¼���Ѿ����ʹ��� word ���ϣ�ͬʱ��¼���ڵڼ�����ʵ�
        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        // ��¼�˵����Ǵ���Щ������չ������key�����ʣ�value�������б���Щ���ʿ��Ա任�� key ��������һ�Զ��ϵ��dfs ��ʱ����õ�
        Map<String, Set<String>> from = new HashMap<>();
        boolean found = bfs(beginWord, endWord, dict, steps, from);
        // �� 2 ����������ȱ����ҵ����н⣬�� endWord �ָ��� beginWord ������ÿ�γ��Բ��� path �б��ͷ��
        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            dfs(from, path, beginWord, endWord, res);
        }
        return res;
    }


    private static boolean bfs(String beginWord, String endWord, Set<String> dict, Map<String, Integer> steps, Map<String, Set<String>> from) {
        int wordLen = beginWord.length();
        int step = 0;
        boolean found = false;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] charArray = currWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char origin = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        // ��ÿһλ�滻�� 26 ��СдӢ����ĸ
                        charArray[j] = c;
                        String nextWord = String.valueOf(charArray);
                        // ע�⣺�⼸�д�����߼��Ⱥ�˳��
                        if (steps.containsKey(nextWord) && steps.get(nextWord) == step) {
                            from.get(nextWord).add(currWord);
                        }
                        if (!dict.contains(nextWord)) {
                            continue;
                        }
                        dict.remove(nextWord);// dict �� steps �е����Ѿ����ʵĹ���
                        queue.offer(nextWord);
                        // ά�� from��steps��found �Ķ���
                        from.putIfAbsent(nextWord, new HashSet<>());
                        from.get(nextWord).add(currWord);
                        steps.put(nextWord, step);
                        if (nextWord.equals(endWord)) {
                            // ע�⣺�����ж���·������ endWord �ҵ��Ժ��������˳���ֻ��Ҫ���� found = true ����
                            found = true;
                        }
                    }
                    charArray[j] = origin;
                }
            }
            if (found) {
                break;
            }
        }
        return found;
    }

    private static void dfs(Map<String, Set<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
        if (cur.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String precursor : from.get(cur)) {
            path.addFirst(precursor);
            dfs(from, path, beginWord, precursor, res);
            path.removeFirst();
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
