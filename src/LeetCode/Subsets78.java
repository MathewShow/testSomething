package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����˵�����⼯���ܰ����ظ����Ӽ���
 * ���еĶ��壺��n����ͬԪ���У���ȡm(m��n,m��n��Ϊ��Ȼ��,��ͬ����Ԫ�ذ���һ����˳���ų�һ�У�������n����ͬԪ����ȡ��m��Ԫ�ص�һ�����У�
 * ��n����ͬԪ����ȡ��m(m��n����Ԫ�ص��������еĸ�����������n����ͬԪ����ȡ��m��Ԫ�ص����������÷��� A(n,m����ʾ��
 * 
 * ��ϵĶ��壺��n����ͬԪ���У���ȡm(m��n����Ԫ�ز���һ�飬������n����ͬԪ����ȡ��m��Ԫ�ص�һ����ϣ�
 * ��n����ͬԪ����ȡ��m(m��n����Ԫ�ص�������ϵĸ�����������n����ͬԪ����ȡ��m��Ԫ�ص���������÷��� C(n,m) ��ʾ��
 * @author hy513
 *
 */
public class Subsets78 {

	public static void main(String[] args) {

		int[] nums = {1,2,3};
		subsets(nums);
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> arr = null;
		list.add(new ArrayList<Integer>());
		for(int i=0;i<nums.length;i++) {
			int size = list.size();
			for(int j=0;j<size;j++) {
				arr = new ArrayList<Integer>();
				arr.addAll(list.get(j));
				arr.add(nums[i]);
				list.add(arr);
			}
		}
		for(List<Integer> a : list) {
			System.out.println(a.toString());
		}
		
		return list;
	}
	
	

}
