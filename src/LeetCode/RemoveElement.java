package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个数组 nums?和一个值 val，你需要原地移除所有数值等于?val?的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {


    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int length = removeElement1(nums, val);
        System.out.println(length);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * <p>
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * <p>
     * 注意这五个元素可为任意顺序。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (val != nums[i]) {
                map.put(j++, nums[i]);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nums[entry.getKey()] = entry.getValue();
        }
        return j;
    }

    public static int removeElement1(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int i = -1;
        for(int n=0;n<nums.length;n++){
            if(nums[n] != val){
                swap(nums, ++i, n);
            }
        }
        return i+1;
    }

    public static void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a]= nums[b];
        nums[b]=tmp;

    }
}
