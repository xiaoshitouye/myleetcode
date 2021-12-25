package string;//����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��
//
// 
//
// ʾ���� 
//
// ���룺"Let's take LeetCode contest"
//�����"s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// ��ʾ�� 
//
// 
// ���ַ����У�ÿ�������ɵ����ո�ָ��������ַ����в������κζ���Ŀո� 
// 
// Related Topics ˫ָ�� �ַ��� 
// ? 358 ? 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_557 {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take    LeetCode    contest"));
    }
    public static String reverseWords(String s)
    {
        char[] s1 = s.toCharArray();
        int i = 0;
        for(int j = 0; j < s1.length; j++)
        {
            if(s1[j] == ' ')
            {
                reverse(s1, i, j - 1);
                i = j + 1;
            }
        }
        reverse(s1, i, s1.length - 1);
        return new String(s1);
    }

    public static void reverse(char[] s, int l, int r)
    {
        while(l < r)
        {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++; r--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
