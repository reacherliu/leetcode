import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
	public static List<List<Integer>> threeSum(int[] num, int begin, int target) {
		num = sort(num);
		int len = num.length;
		Set<List<Integer>> results = new HashSet<List<Integer>>();
		int i = 0;
		int j = 0;
		int k = 0;
		int new_target = 0;
		for (i = begin; i < len-2; ++i) {
			new_target = target - num[i];
			j = i + 1;
			k = len - 1;
			while (j < k) {
				if (num[j] + num[k] == new_target) {
					List<Integer> item = new ArrayList<Integer>();
					item.add(num[i]);
					item.add(num[j]);
					item.add(num[k]);
					results.add(item);
					j++;
					k--;
				} else if (num[j] + num[k] < new_target) {
					j++;
				} else if (num[j] + num[k] > new_target) {
					k--;
				}
			}
		}
		return new ArrayList<List<Integer>>(results);
	}

	public static List<List<Integer>> fourSum(int[] num, int target) {
		num = sort(num);
		int len = num.length;
		Set<List<Integer>> results = new HashSet<List<Integer>>();
		if (len < 4) {
			return new ArrayList<List<Integer>>(results);
		}
		int i = 0;
		int j = 0;
		int three_sum_size = 0;
		for (i = 0; i < len - 3; ++i) {
			List<List<Integer>> three_sum_results = threeSum(num, i+1, target-num[i]);
			three_sum_size = three_sum_results.size();
			for (j = 0; j < three_sum_size; ++j) {
				List<Integer> item = new ArrayList<Integer>();
				item.add(num[i]);
				item.addAll(three_sum_results.get(j));
				results.add(item);
			}
		}
		return new ArrayList<List<Integer>>(results);
	}

	// Bubble sort.
	private static int[] sort(int[] num) {
		int len = num.length;
		int i = 0;
		int j = 0;
		for (i = len - 1; i >= 0; --i) {
			for (j = 0; j < i; ++j) {
				if (num[j] > num[j + 1]) {
					int temp = num[j + 1];
					num[j + 1] = num[j];
					num[j] = temp;
				}
			}
		}
		return num;
	}

	public static void print(List<List<Integer>> results) {
		for (int i = 0; i < results.size(); ++i) {
			for (int j = 0; j < results.get(i).size(); ++j) {
				System.out.print(results.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 0, -1, 0, -2, 2};
		print(fourSum(num, 0));
	}
}

