package ssafy;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1062_가르침 {

	static int N, K, output;
	static boolean[] check;
	static ArrayList<String> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		check = new boolean[26];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			s = s.replace("a", "");
			s = s.replace("c", "");
			s = s.replace("i", "");
			s = s.replace("n", "");
			s = s.replace("t", "");
			list.add(s);
		}

		if (K < 5) {
			output = 0;
		} else if (K == 26) {
			output = N;
		} else {
			check[0] = true;
			check[2] = true;
			check[8] = true;
			check[13] = true;
			check[19] = true;
			K = K - 5;
			output = 0;
			learn(0, 0);
		}
		
		System.out.println(output);

	}

	private static void learn(int start, int cnt) {

		if (cnt == K) {
			int count = 0;
			int max = 0;
			
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.get(i).length(); j++) {
					if (check[list.get(i).charAt(j) - 97]) {
						count++;
					}
				}
				if (count == list.get(i).length()) {
					max++;
				}
				count = 0;
			}

			if (max > output) {
				output = max;
			}

			return;
		}

		for (int i = start; i < check.length; i++) {
			if (!check[i]) {
				check[i] = true;
				learn(i + 1, cnt + 1);
				check[i] = false;
			}
		}
	}

}