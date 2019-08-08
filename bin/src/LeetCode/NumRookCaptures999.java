package LeetCode;

/**
 * ��һ�� 8 x 8 �������ϣ���һ����ɫ����rook����Ҳ�����пշ��飬��ɫ����bishop���ͺ�ɫ���䣨pawn�������Ƿֱ����ַ� ��R������.������B�� �� ��p�� ��������д�ַ���ʾ���壬Сд�ַ���ʾ���塣
 *
 * �������������еĹ����ƶ�����ѡ���ĸ����������е�һ�����������������ϣ���Ȼ���Ǹ������ƶ���ֱ����ѡ��ֹͣ���������̵ı�Ե���ƶ���ͬһ����������÷�������ɫ�෴���䡣���⣬�������������ѷ�����ɫ�������ͬһ������
 *
 * ���س��ܹ���һ���ƶ��в��񵽵����������
 *
 * ��ʾ:
 * board.length == board[i].length == 8
 * board[i][j] ������?'R'��'.'��'B'?��?'p'
 * ֻ��һ�������ϴ���?board[i][j] == 'R'
 *
 */
public class NumRookCaptures999 {

    public static void main(String[] args) {
        char[][] board = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},
                {'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        System.out.println(numRookCaptures(board));
    }

    public static int numRookCaptures(char[][] board) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j]=='R'){//�ҵ�R
                    int rowRight = j+1;
                    int rowLeft = j-1;
                    int columnTop = i-1;
                    int columnBottom = i+1;

                    while(rowRight<8 || rowLeft>=0){
                        if (rowRight<8){
                            if ( board[i][rowRight]=='B'){
                                rowRight=8;
                            }else if(board[i][rowRight]=='p'){
                                count++;
                                rowRight=8;
                            }else{
                                rowRight++;
                            }
                        }
                        if (rowLeft>=0){
                            if (board[i][rowLeft]=='B'){
                                rowLeft=-1;
                            }else if (board[i][rowLeft]=='p'){
                                count++;
                                rowLeft=-1;
                            }else{
                                rowLeft--;
                            }
                        }
                    }
                    while(columnBottom<8 || columnTop>=0){
                        if (columnBottom<8){
                            if ( board[columnBottom][j]=='B'){
                                columnBottom=8;
                            }else if(board[columnBottom][j]=='p'){
                                count++;
                                columnBottom=8;
                            }else{
                                columnBottom++;
                            }
                        }
                        if (columnTop>=0){
                            if (board[columnTop][j]=='B'){
                                columnTop=-1;
                            }else if (board[columnTop][j]=='p'){
                                count++;
                                columnTop=-1;
                            }else{
                                columnTop--;
                            }
                        }
                    }
                    break;
                }
            }

        }


        return count;
    }

}
