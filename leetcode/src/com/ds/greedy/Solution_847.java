package greedy;//��������һ�����޴�С�� XY ����ƽ�������ߣ��ӵ� (0, 0) ����ʼ���������򱱷����û����˿��Խ��������������͵����� commands ��
//
// 
// -2 ������ת 90 �� 
// -1 ������ת 90 �� 
// 1 <= x <= 9 ����ǰ�ƶ� x ����λ���� 
// 
//
// ����������һЩ���ӱ���Ϊ�ϰ��� obstacles ���� i ���ϰ���λ������� obstacles[i] = (xi, yi) �� 
//
// �������޷��ߵ��ϰ����ϣ�������ͣ�����ϰ����ǰһ�����񷽿��ϣ�����Ȼ���Լ������Խ��и�·�ߵ����ಿ�֡� 
//
// ���ش�ԭ�㵽���������о�����·���㣨����Ϊ�����������ŷʽ�����ƽ�����������������Ϊ 5 ���򷵻� 25 �� 
//
// 
// 
// 
// 
// 
// 
//
// 
// ע�⣺ 
//
// 
// ����ʾ +Y ���� 
// ����ʾ +X ���� 
// �ϱ�ʾ -Y ���� 
// ����ʾ -X ���� 
// 
// 
// 
// 
// 
//
// 
//
// ʾ�� 1�� 
//
// 
//���룺commands = [4,-1,3], obstacles = []
//�����25
//���ͣ�
//�����˿�ʼλ�� (0, 0)��
//1. ���ƶ� 4 ����λ������ (0, 4)
//2. ��ת
//3. ���ƶ� 3 ����λ������ (3, 4)
//����ԭ����Զ���� (3, 4) ������Ϊ 32 + 42 = 25 
//
// ʾ�� 2�� 
//
// 
//���룺commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//�����65
//���ͣ������˿�ʼλ�� (0, 0)��
//1. ���ƶ� 4 ����λ������ (0, 4)
//2. ��ת
//3. ���ƶ� 1 ����λ��Ȼ��λ�� (2, 4) ���ϰ����赲��������ͣ�� (1, 4)
//4. ��ת
//5. ���� 4 ����λ������ (1, 8)
//����ԭ����Զ���� (1, 8) ������Ϊ 12 + 82 = 65 
//
// 
//
// ��ʾ�� 
//
// 
// 1 <= commands.length <= 104 
// commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9]. 
// 0 <= obstacles.length <= 104 
// -3 * 104 <= xi, yi <= 3 * 104 
// �𰸱�֤С�� 231 
// 
// Related Topics ���� ģ�� 
// ? 155 ? 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_847 {
    public static void main(String[] args) {
        int ans =robotSim(new int[]{4,-1,4,-2,4}, new int[][] {{2 , 4}});
        System.out.println(ans);

    }
    public static int robotSim(int[] commands, int[][] obstacles) {
      int res = 0, x = 0, y = 0, direction = 0;
      int[] directX = new int[] {0, 1, 0, -1};
      int[] directY = new int[] {1, 0, -1, 0};
      //�ϰ���
        Set<String> obstacleseSet = new HashSet<String>();
        for(int i =0; i < obstacles.length; i++){
            obstacleseSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        for(int com : commands){
           if(com == -2){ //left
               direction = (direction + 3) % 4;
           }else if(com == -1){
               direction = (direction + 1) % 4;
           }else{

               //ֱ�������ϰ���
             while(com-- >0 && !obstacleseSet.contains((x + directX[direction]) + "," + (y + directY[direction]))){//һ��Ҫ��()����Ȼ�ᵱ���ַ���
//                 System.out.println(x + directX[direction] + "," + y + directY[direction]);
                x += directX[direction];
                y += directY[direction];
             }
             res = Math.max(res, x * x + y * y);
           }
        }
        return  res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
