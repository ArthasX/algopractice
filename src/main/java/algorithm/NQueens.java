package algorithm;

import java.util.Arrays;

/**
 * Created by KJB-001064 on 2017/5/25
 * 以行为单位进行排序 queens[x]=y 代表了 Queen的摆放坐标（x,y)
 */
public class NQueens {

    int qNum;
    int[] queens;
    int[] out;
    int count = 0;

    public NQueens(int qNum) {
        this.qNum = qNum;
        queens = new int[qNum];
        Arrays.fill(queens, -1);
        out = new int[qNum];
        System.out.println("Queens number is :" + qNum);
        System.out.println("[queens]:" + Arrays.toString(queens));
        System.out.println("[out]:" + Arrays.toString(out));
    }

    //i:row   j:col
    public void placeQueen(int i) {

        if (i == qNum) {
            count++;
            print();
        } else {
            for (int col = 0; col < qNum; col++) {
                if (!isSameLine(i, col)) {
                    queens[i] = col;
                    placeQueen(i + 1);
                }
            }
        }
    }

    public void placeQueen() {
        int row = 0;
        int col = 0;
        while (row < qNum) {
            while (col < qNum) {
                if (!isSameLine(row, col)) {
                    queens[row] = col;//在放置在(row,col)
                    col = 0;//置零从第一列开始重新查找
                    break;
                } else {
                    col++;
                }
            }
            if (queens[row] == -1) {
                if (row == 0)
                    break;
                row--;
                col = queens[row] + 1;
                queens[row] = -1;
                continue;
            }
            if (row == qNum - 1) {
                count++;
                print();
                col = queens[row] + 1;
                queens[row] = -1;
                continue;
            }
            row++;
        }
    }


    public void print() {
        System.out.println("第" + count + "个解:");
        System.out.println("一维解：");
        System.out.println(Arrays.toString(queens));
        System.out.println("二维解:");
        for (int i : queens) {
            out[i] = 1;
            System.out.println(Arrays.toString(out));
            out = new int[qNum];
        }
        System.out.println("-----------------");
    }

    //放第一个的时候不需要check
    private boolean isSameLine(int row, int col) {
        for (int i = 0; i < row; i++) {
            if ((queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens(20);
        nQueens.placeQueen();
    }
}
