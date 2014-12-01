import java.util.HashMap;
import java.util.Map;

public class IntToRoman {
	public static Map<Integer, Character> INT_ROMAN = new HashMap<Integer, Character> ();
	
	public static void initializeMap() {
	    INT_ROMAN.put(1, 'I');
	    INT_ROMAN.put(5, 'V');
	    INT_ROMAN.put(10, 'X');
	    INT_ROMAN.put(50, 'L');
	    INT_ROMAN.put(100, 'C');
	    INT_ROMAN.put(500, 'D');
	    INT_ROMAN.put(1000, 'M');
	}
    
    public static String intToRoman(int num) {
    	initializeMap();
        StringBuilder result = new StringBuilder(intToRomanHelper(1000, num/1000));
        result.append(intToRomanHelper(100, (num % 1000)/100));
        result.append(intToRomanHelper(10, (num % 100)/10));
        result.append(intToRomanHelper(1, (num % 10)/1));
        return result.toString();
    }
    
    // digit = 1000, counts = 3 => "MMM"
    // digit = 10, counts = 8 => "XXC"
    public static String intToRomanHelper (int digit, int counts) {
        StringBuilder result = new StringBuilder();
        if (counts == 0) {
            return result.toString();
        }
        if (counts >= 1 && counts <= 3) {
            for (int i = 0; i < counts; ++i) {
                result.append(INT_ROMAN.get(digit));
            }
        } else if (counts == 4) {
            result.append(INT_ROMAN.get(digit));
            result.append(INT_ROMAN.get(digit*5));
        } else if (counts <= 8) {
            result.append(INT_ROMAN.get(digit*5));
            for (int i = 0; i < counts - 5; ++i) {
                result.append(INT_ROMAN.get(digit));
            }
        } else {
            result.append(INT_ROMAN.get(digit));
            result.append(INT_ROMAN.get(digit*10));
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
    	System.out.println(intToRoman(518));
    }
}

