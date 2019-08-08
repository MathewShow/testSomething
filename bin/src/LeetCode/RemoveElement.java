package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ����һ������ nums?��һ��ֵ val������Ҫԭ���Ƴ�������ֵ����?val?��Ԫ�أ������Ƴ���������³��ȡ�
 * <p>
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 * <p>
 * Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
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
     * ���� nums = [0,1,2,2,3,0,4,2], val = 2,
     * <p>
     * ����Ӧ�÷����µĳ��� 5, ���� nums �е�ǰ���Ԫ��Ϊ 0, 1, 3, 0, 4��
     * <p>
     * ע�������Ԫ�ؿ�Ϊ����˳��
     * <p>
     * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
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
