package string;//������ʵ��һ�� myAtoi(string s) ������ʹ���ܽ��ַ���ת����һ�� 32 λ�з������������� C/C++ �е� atoi ��������
//
// ���� myAtoi(string s) ���㷨���£� 
//
// 
// �����ַ������������õ�ǰ���ո� 
// �����һ���ַ������軹δ���ַ�ĩβ��Ϊ�����Ǹ��ţ���ȡ���ַ�������У��� ȷ�����ս���Ǹ������������� ������߶������ڣ���ٶ����Ϊ���� 
// ������һ���ַ���ֱ��������һ���������ַ��򵽴�����Ľ�β���ַ��������ಿ�ֽ������ԡ� 
// ��ǰ�沽��������Щ����ת��Ϊ����������"123" -> 123�� "0032" -> 32�������û�ж������֣�������Ϊ 0 ����Ҫʱ���ķ��ţ��Ӳ��� 
//2 ��ʼ���� 
// ������������� 32 λ�з���������Χ [?231, 231 ? 1] ����Ҫ�ض����������ʹ�䱣���������Χ�ڡ�������˵��С�� ?231 ������Ӧ�ñ���
//��Ϊ ?231 ������ 231 ? 1 ������Ӧ�ñ��̶�Ϊ 231 ? 1 �� 
// ����������Ϊ���ս���� 
// 
//
// ע�⣺ 
//
// 
// �����еĿհ��ַ�ֻ�����ո��ַ� ' ' �� 
// ��ǰ���ո�����ֺ�������ַ����⣬������� �κ������ַ��� 
// 
//
// 
//
// ʾ�� 1�� 
//
// 
//���룺s = "42"
//�����42
//���ͣ��Ӵֵ��ַ���Ϊ�Ѿ�������ַ�����������ǵ�ǰ��ȡ���ַ���
//�� 1 ����"42"����ǰû�ж����ַ�����Ϊû��ǰ���ո�
//         ^
//�� 2 ����"42"����ǰû�ж����ַ�����Ϊ���ﲻ���� '-' ���� '+'��
//         ^
//�� 3 ����"42"������ "42"��
//           ^
//�����õ����� 42 ��
//���� "42" �ڷ�Χ [-231, 231 - 1] �ڣ����ս��Ϊ 42 �� 
//
// ʾ�� 2�� 
//
// 
//���룺s = "   -42"
//�����-42
//���ͣ�
//�� 1 ����"   -42"������ǰ���ո񣬵����ӵ���
//            ^
//�� 2 ����"   -42"������ '-' �ַ������Խ��Ӧ���Ǹ�����
//             ^
//�� 3 ����"   -42"������ "42"��
//               ^
//�����õ����� -42 ��
//���� "-42" �ڷ�Χ [-231, 231 - 1] �ڣ����ս��Ϊ -42 ��
// 
//
// ʾ�� 3�� 
//
// 
//���룺s = "4193 with words"
//�����4193
//���ͣ�
//�� 1 ����"4193 with words"����ǰû�ж����ַ�����Ϊû��ǰ���ո�
//         ^
//�� 2 ����"4193 with words"����ǰû�ж����ַ�����Ϊ���ﲻ���� '-' ���� '+'��
//         ^
//�� 3 ����"4193 with words"������ "4193"��������һ���ַ�����һ�����֣����Զ���ֹͣ��
//             ^
//�����õ����� 4193 ��
//���� "4193" �ڷ�Χ [-231, 231 - 1] �ڣ����ս��Ϊ 4193 ��
// 
//
// ʾ�� 4�� 
//
// 
//���룺s = "words and 987"
//�����0
//���ͣ�
//�� 1 ����"words and 987"����ǰû�ж����ַ�����Ϊû��ǰ���ո�
//         ^
//�� 2 ����"words and 987"����ǰû�ж����ַ�����Ϊ���ﲻ���� '-' ���� '+'��
//         ^
//�� 3 ����"words and 987"�����ڵ�ǰ�ַ� 'w' ����һ�����֣����Զ���ֹͣ��
//         ^
//�����õ����� 0 ����Ϊû�ж����κ����֡�
//���� 0 �ڷ�Χ [-231, 231 - 1] �ڣ����ս��Ϊ 0 �� 
//
// ʾ�� 5�� 
//
// 
//���룺s = "-91283472332"
//�����-2147483648
//���ͣ�
//�� 1 ����"-91283472332"����ǰû�ж����ַ�����Ϊû��ǰ���ո�
//         ^
//�� 2 ����"-91283472332"������ '-' �ַ������Խ��Ӧ���Ǹ�����
//          ^
//�� 3 ����"-91283472332"������ "91283472332"��
//                     ^
//�����õ����� -91283472332 ��
//���� -91283472332 С�ڷ�Χ [-231, 231 - 1] ���½磬���ս�����ض�Ϊ -231 = -2147483648 �� 
//
// 
//
// ��ʾ�� 
//
// 
// 0 <= s.length <= 200 
// s ��Ӣ����ĸ����д��Сд�������֣�0-9����' '��'+'��'-' �� '.' ��� 
// 
// Related Topics �ַ��� 
// ? 1261 ? 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_8 {
    public int myAtoi(String s) {
     int len = s.length();
     char[] charArr = s.toCharArray();
     int index = 0;
     while(index < len && charArr[index] == ' '){ //ȥ�ո�
         index++;
     }
     if(len == index){
        return 0;
     }
     int sign = 1;
     char headChar = charArr[index];
     if(headChar == '+'){
         index++;
     }else if(headChar == '-'){
         index++;
         sign = -1;
     }
     int res = 0;
     while(index < len){
         char curr = charArr[index];
         if(curr > '9' || curr < '0'){
             break;
         }
         if(res > Integer.MAX_VALUE / 10 ||(res == Integer.MAX_VALUE / 10 && (curr - '0') > Integer.MAX_VALUE %10)){
             return Integer.MAX_VALUE;
         }
         if(res < Integer.MIN_VALUE / 10 ||(res == Integer.MIN_VALUE / 10 && (curr - '0') > -(Integer.MIN_VALUE %10))){
             return Integer.MIN_VALUE;
         }
         res = res * 10 + (curr - '0') * sign;
         index++;
     }
     return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)