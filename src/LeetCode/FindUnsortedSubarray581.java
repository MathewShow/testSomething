package LeetCode;

import java.util.Arrays;

/**
 * ����һ���������飬����ҪѰ��һ�������������飬���������������������������ô�������鶼���Ϊ��������
 *
 *  ���ҵ���������Ӧ����̵ģ���������ĳ��ȡ�
 *
 * ʾ�� 1:
 *
 * ����: [2, 6, 4, 8, 10, 9, 15]
 * ���: 5
 * ����: ��ֻ��Ҫ�� [6, 4, 8, 10, 9] ��������������ô���������Ϊ��������
 *
 * ˵�� :
 *
 * ��������鳤�ȷ�Χ�� [1, 10,000]��
 * �����������ܰ����ظ�Ԫ�� �������������˼��<=��
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
     * Ч�ʸ�
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
                max = nums[i];//�������ҵļ���ֵ

            if(min < nums[nums.length - 1 - i])
                left = nums.length - 1 - i;
            else
                min = nums[nums.length - 1 - i];//��������ļ�Сֵ
        }
        return right - left + 1;
    }

}
