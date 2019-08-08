package LeetCode;

import java.util.ArrayList;
import java.util.List;


/**
 * 1104. ������Ѱ·
 * ��һ�����޵Ķ������ϣ�ÿ���ڵ㶼�������ӽڵ㣬���еĽڵ� ���� ���ΰ� ��֮�� ���ν��б�ǡ�
 * <p>
 * ����ͼ��ʾ���������У�������һ�С������С������С������У��������ҵ�˳����б�ǣ�
 * <p>
 * ��ż���У������ڶ��С������С������С������У������ҵ����˳����б�ǡ�
 */
public class PathInZigZagTree {

    public static void main(String[] args) {

        /*PathInZigZagTree tree = new PathInZigZagTree();
        List<Integer> list = tree.pathInZigZagTree(26);
        System.out.println(list.toString());
        list = tree.pathInZigZagTree(14);
        System.out.println(list.toString());*/


        int level = 32;
        int min = 1 << (level - 1);
        System.out.println(min);



    }

    /**
     * ʾ�� 1��
     * <p>
     * ���룺label = 26
     * �����[1,2,6,10,26]
     * <p>
     * ˼· : ���и�ż
     *       ż�и���
     *
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {

        List<Integer> list = new ArrayList<Integer>();

        while (label > 0) {
            list.add(0, label);
            label = label / 2;
        }
        int size = list.size();
        if (size <= 2) {
            return list;
        }
        if (size % 2 == 0) {
            for (int i = 3; i < size; i = i + 2) {
                swap(i, list);
            }
        } else {
            for (int i = 2; i < size; i = i + 2) {
                swap(i, list);
            }
        }
        return list;
    }

    private void swap(int i, List<Integer> list) {
        int value = (int) (Math.pow(2, i - 1) * 3 - 1-list.get(i-1));
        list.set(i-1, value);
    }

}
