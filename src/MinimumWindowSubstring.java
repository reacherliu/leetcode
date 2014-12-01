public class MinimumWindowSubstring {
	public static String minWindow(String S, String T) {
        int[] t_counts = new int[128];
        int[] s_counts = new int[128];
        int t_len = T.length();
        int s_len = S.length();
        int start = 0;
        int i = 0;
        int counts = 0;
        int min_len = s_len + 1;
        int min_start = 0;
        int min_end = 0;

        for (i = 0; i < t_len; i++) {
        	t_counts[T.charAt(i)]++;
        }
        for (i = 0; i < s_len; i++) {
        	if (t_counts[S.charAt(i)] > 0) {
            	s_counts[S.charAt(i)]++;
            	if (s_counts[S.charAt(i)] <= t_counts[S.charAt(i)]) {
            		counts++;
            	}
        		if (counts == t_len) {
        			while (start < i) {
        				if (t_counts[S.charAt(start)] == 0 || 
        						(t_counts[S.charAt(start)] <= (--s_counts[S.charAt(start)]))) {
        					start++;
        				} else {
        					break;
        				}
        			}
        			if (i - start + 1 < min_len) {
        				min_len = i - start + 1;
        				min_start = start;
        				min_end = i;
        			}
        			counts--;
        			start++;
        		}
        	}
        }
        if (min_len == s_len + 1) {
        	return "";
        }
        return S.substring(min_start, min_end + 1);
    }
	
	public static void main(String[] args) {
		String S = "bdab";
		String T = "ab";
		System.out.println(minWindow(S, T));
	}
}

