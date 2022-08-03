package D4_쇠막대기자르기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Stick {
	int start;
	int end;

	public Stick(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

}

public class Solution {

	static int T;
	static String str;
	static int answer;
	static List<Integer> lazers;
	static List<Stick> sticks;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			answer = 0;

			str = br.readLine();

			Stack<Integer> s = new Stack<>();
			lazers = new ArrayList();
			sticks = new ArrayList();

			int idx = 0;

			while (idx < str.length()) {

				char ch = str.charAt(idx);

				if (ch == '(') {

					// 레이저
					if (str.charAt(idx + 1) == ')') {
						lazers.add(idx);
						idx += 2;
					}
					// 막대기
					else {
						s.push(idx);
						idx++;
					}

				} else {
					int start = s.pop();
					sticks.add(new Stick(start, idx));
					idx++;
				}
			}

			for (int i = 0; i < sticks.size(); i++) {

				Stick stick = sticks.get(i);
				int cnt = 0;

				if (stick.start > lazers.get(lazers.size() - 1) || stick.end < lazers.get(0)) {
					answer += 1;
				} else {
					// bst
					answer += lowerBound(stick.end) - upperBound(stick.start) + 1;
				}

				answer += cnt + 1;
			}

			sb.append("#").append(t).append(" ").append(answer).append("\n");
		} // end of testCase

		System.out.println(sb);

	}// end of main

	static int upperBound(int target) {

		int start = 0;
		int end = lazers.size() - 1;

		int left = 0;

		while (start <= end) {

			int mid = (start + end) / 2;

			if (lazers.get(mid) > target) {
				left = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}

		return left;
	}

	static int lowerBound(int target) {

		int start = 0;
		int end = lazers.size() - 1;

		int right = 0;

		while (start <= end) {

			int mid = (start + end) / 2;

			if (lazers.get(mid) < target) {
				right = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		return right;
	}

}
