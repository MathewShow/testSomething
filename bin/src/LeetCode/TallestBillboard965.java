package LeetCode;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * �����ڰ�װһ������ƣ���ϣ�����߶����������ƽ�����������֧�ܣ����߸�һ����ÿ����֧�ܵĸ߶ȱ�����ȡ�
 * <p>
 * ����һ�ѿ��Ժ�����һ��ĸֽ� rods���ٸ����ӣ�����ֽ�ĳ���Ϊ 1��2 �� 3������Խ����Ǻ�����һ���γɳ���Ϊ 6 ��֧�ܡ�
 * <p>
 * ���ع���Ƶ������ܰ�װ�߶ȡ����û����װ����ƣ��뷵�� 0��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺[1,2,3,6]
 * �����6
 * ���ͣ��������������ཻ���Ӽ� {1,2,3} �� {6}�����Ǿ�����ͬ�ĺ� sum = 6��
 * ʾ�� 2��
 * <p>
 * ���룺[1,2,3,4,5,6]
 * �����10
 * ���ͣ��������������ཻ���Ӽ� {2,3,5} �� {4,6}�����Ǿ�����ͬ�ĺ� sum = 10��
 * ʾ�� 3��
 * <p>
 * ���룺[1,2]
 * �����0
 * ���ͣ�û����װ����ƣ����Է��� 0��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= rods.length <= 20
 * 1 <= rods[i] <= 1000
 * �ֽ�ĳ����ܺ����Ϊ 5000
 */
public class TallestBillboard965 {

    public static void main(String[] args) {

    }

    /**
     * 956. ��ߵĹ����
     *
     * @param rods
     * @return
     */
    public int tallestBillboard(int[] rods) {
        List<Integer> same = new ArrayList<Integer>();
        List<Integer> diff = new ArrayList<Integer>();
        //ȥ����ͬ��
        for (int i = 0; i < rods.length - 1; i++) {
            if (rods[i] == rods[i + 1]) {
                same.add(rods[i]);
                rods[i] = 0;
                rods[i + 1] = 0;
                i++;
            } else {
                diff.add(rods[i]);
            }
        }
        Integer[] diffArr = (Integer[]) diff.toArray();

        int maxLength = 0;

        //��� �Ƚ�


        return 0;
    }
}
