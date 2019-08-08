package LeetCode;

import java.util.ArrayList;
import java.util.List;


/**
 * 1104. 二叉树寻路
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * <p>
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * <p>
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
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
     * 示例 1：
     * <p>
     * 输入：label = 26
     * 输出：[1,2,6,10,26]
     * <p>
     * 思路 : 奇行改偶
     *       偶行改奇
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
