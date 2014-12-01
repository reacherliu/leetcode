public class LongestSubstr {
	public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int count[] = new int[128];
        int start = 0;
        int i = 0;
        int maxlen = 0;
        while (start < len) {
        	while (i < len) {
        		if (count[s.charAt(i)] == 0){
        			count[s.charAt(i)]++;
        			i++;
        		} else {
//        			System.out.println(start + " " + i);
        			if (maxlen < i - start) {
        				maxlen = i - start;
        			}
        			break;
        		}
        	}
        	if (i == len) {
        		if (maxlen < len - start) {
        			maxlen = len - start;
        		}
        		break;
        	}
        	count[s.charAt(start)]--;
        	start++;
        }
        return maxlen;
    }
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar"));
	}
}

