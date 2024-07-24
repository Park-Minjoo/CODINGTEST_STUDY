import java.io.*;
import java.util.*;

public class Main {

	private static char[] arr;
	private static int answer = 0;
	private static int tmp = 1;
	private static Stack<Character> stack = new Stack<Character>();

	private static char OPEN1 = '[';
	private static char OPEN2 = '(';
	private static char CLOSE1 = ']';
	private static char CLOSE2 = ')';

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine().toCharArray();

		for (int i = 0; i < arr.length; i++) {
			char current = arr[i];

			if (current == OPEN1) {
				stack.push(current);
				tmp *= 3;
			} else if (current == OPEN2) {
				stack.push(current);
				tmp *= 2;
			} else if (current == CLOSE1) {
				if (stack.empty() || stack.peek() != OPEN1) {
					answer = 0;
					break;
				}
				stack.pop();
				if(arr[i-1] == OPEN1) answer += tmp;
				tmp /= 3;
			} else if (current == CLOSE2) {
				if (stack.empty() || stack.peek() != OPEN2) {
					answer = 0;
					break;
				}
				stack.pop();
				if(arr[i-1] == OPEN2) answer += tmp;
				tmp /= 2;
			}

		}

		if (!stack.empty()) {
			System.out.println(0);
		} else {
			System.out.println(answer);

		}
	}

}

/*
(()[[]])([])
((((((((((
()()()
 */
