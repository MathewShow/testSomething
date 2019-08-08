package LeetCode;

import java.util.Arrays;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 *  你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
public class FindUnsortedSubarray581 {


    public static void main(String[] args) {

        int[] nums = {1,2,3};

        /*System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(nums));*/

        System.out.println(findUnsortedSubarray(nums));

    }


    public static int findUnsortedSubarray(int[] nums) {

        if (nums==null || nums.length<=1){
            return 0;
        }

        int length = nums.length;

        int[] copy = new int[length];
        System.arraycopy(nums,0,copy,0,length);
        Arrays.sort(nums);

        int i=0;
        int j=length-1;
        int count = 0;
        boolean bi = true;
        boolean bj = true;
        while(i<length-1 && j>0 && i<=j && (bi || bj)){
            if (nums[i] == copy[i]){
                count++;
                i++;
            }else{
                bi = false;
            }

            if (nums[j] == copy[j]){
                count++;
                j--;
            }else{
                bj = false;
            }

        }

        return (length-count)>0?(length-count):0;
    }


    /**
     * 效率高
     * @param nums
     * @return
     */
    public int findUnsortedSubarrayGood(int[] nums) {
        if(nums.length == 0)
            return 0;

        int left = 0;
        int right = -1;
        int max = nums[0];
        int min = nums[nums.length - 1];

        for(int i = 1; i < nums.length; i++)
        {
            if(max > nums[i])
                right = i;
            else
                max = nums[i];//从左往右的极大值

            if(min < nums[nums.length - 1 - i])
                left = nums.length - 1 - i;
            else
                min = nums[nums.length - 1 - i];//从右往左的极小值
        }
        return right - left + 1;
    }

}
