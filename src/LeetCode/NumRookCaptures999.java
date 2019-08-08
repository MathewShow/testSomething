package LeetCode;

/**
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 *
 * 提示:
 * board.length == board[i].length == 8
 * board[i][j] 可以是?'R'，'.'，'B'?或?'p'
 * 只有一个格子上存在?board[i][j] == 'R'
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
                if(board[i][j]=='R'){//找到R
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
