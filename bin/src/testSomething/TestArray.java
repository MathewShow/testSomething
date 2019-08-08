package testSomething;

/**
 * 数组的生命定义方式
 */
public class TestArray {

    public static void main(String[] args) {
        /**
         * 数组动态初始化：
         *
         * 数据类型 [] 数组名称 = new 数据类型[长度];
         * 数据类型 数组名称[] = new 数据类型[长度];
         *
         *
         * 数组静态初始化
         *
         * 数据类型[] 数组名称 = {值, 值,…}
         * 数据类型[] 数组名称 = new 数据类型[] {值, 值,…}
         */

        int[] arr1 = new int[2];
        arr1[0] = 10;
        arr1[1] = 20;

        System.out.println();

    }

}
