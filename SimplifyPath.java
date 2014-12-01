import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
	public static void main(String[] args) {
		System.out.println(simplifyPath(
				"/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
	}

	public static String simplifyPath(String path) {
		Deque<String> stack = new ArrayDeque<String> ();
		// Notice: a/b//c///d/ is split into: "a", "b", "", "c", "", "", "d"
		String[] dirs = path.split("/");
		String res = "";
		int len = dirs.length;
		int i = 0;
		for (i = 0; i < len; i++) {
			if (dirs[i].equals("") || dirs[i].equals(".")) {
				continue;
			}
			if (dirs[i].equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(dirs[i]);
			}
		}
		if (stack.isEmpty()) {
			return "/";
		}
		while (!stack.isEmpty()) {
			res = res + "/" + stack.pollLast();
		}
		return res;
	}
}

