package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。说明：解集不能包含重复的子集。
 * 排列的定义：从n个不同元素中，任取m(m≤n,m与n均为自然数,下同）个元素按照一定的顺序排成一列，叫做从n个不同元素中取出m个元素的一个排列；
 * 从n个不同元素中取出m(m≤n）个元素的所有排列的个数，叫做从n个不同元素中取出m个元素的排列数，用符号 A(n,m）表示。
 * 
 * 组合的定义：从n个不同元素中，任取m(m≤n）个元素并成一组，叫做从n个不同元素中取出m个元素的一个组合；
 * 从n个不同元素中取出m(m≤n）个元素的所有组合的个数，叫做从n个不同元素中取出m个元素的组合数。用符号 C(n,m) 表示。
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
