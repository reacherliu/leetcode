import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public static List<List<Integer>> combinationSum (int[] candidates, int target) {
		candidates = sort(candidates);
        return combinationSumHelp(candidates, 0, target);
    }
	
	public static List<List<Integer>> combinationSumHelp (int[] candidates, int i, int target) {
        int len = candidates.length;
        if (i >= len) {
        	return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        int num = target / candidates[i];
        int j = 0;
        int k = 0;
        int l = 0;
    	if (num * candidates[i] == target) {
    		List<Integer> listFull = new ArrayList<Integer>();
    		for (j = 0; j < num; ++j) {
    			listFull.add(candidates[i]);
    		}
    		results.add(listFull);
    	}
        for (j = 0; j < num; ++j) {
        	List<List<Integer>> listTail = combinationSumHelp(candidates, i+1, target - candidates[i]*j);
        	int listLen = listTail.size();
        	for (k = 0; k < listLen; ++k) {
        		List<Integer> listFull = new ArrayList<Integer>();
        		for (l = 0; l < j; ++l) {
        			listFull.add(candidates[i]);
        		}
        		listFull.addAll(listTail.get(k));
        		results.add(listFull);
        	}
        }
        return results;
    }
	
	// Bubble sort.
	public static int[] sort(int[] num) {
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
	
	public static void main(String[] args) {
		int[] candidates = {8,7,4,3};
		List<List<Integer>> list = combinationSum(candidates, 11);
		for (int i = 0; i < list.size(); ++i) {
			for (int j = 0; j < list.get(i).size(); ++j) {
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}


