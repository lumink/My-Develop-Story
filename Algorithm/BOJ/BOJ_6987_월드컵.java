package ssafy;

import java.util.Scanner;

public class BOJ_6987_월드컵 {

	static int N = 6;
	static int[][] match;
	static int[] com, win, mo, lose;
	static int g;
	static boolean possible;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		com = new int[2];
		match = new int[15][2];
		combination(N, 2, 0, 0);

		for (int t = 0; t < 4; t++) {

			win = new int[N];
			mo = new int[N];
			lose = new int[N];
			possible = false;

			for (int i = 0; i < N; i++) {
				win[i] = sc.nextInt();
				mo[i] = sc.nextInt();
				lose[i] = sc.nextInt();
			}

			int sum = 0, w = 0, l = 0;
			for (int i = 0; i < N; i++) {
				w += win[i];
				l += lose[i];
				sum += lose[i] + win[i] + mo[i];
			}

			if ((w - l) == 0 && sum == 30) {
				dfs(0);
			}

			sb.append((possible ? 1 : 0) +" ");

		}
		
		System.out.println(sb.toString());

	}

	private static void combination(int n, int r, int start, int count) {

		if (count == r) {
			match[g][0] = com[0];
			match[g][1] = com[1];
			g++;
			return;
		}

		for (int i = start; i < n; i++) {
			com[count] = i;
			combination(n, r, i + 1, count + 1);
		}

	}

	private static void dfs(int game) {
		
		if (possible) {
			return;
		}

		if (game == 15) {
			possible = true;
			return;
		}

		int t1 = match[game][0];
		int t2 = match[game][1];

		if (win[t1] > 0 && lose[t2] > 0) {
			win[t1]--;
			lose[t2]--;
			dfs(game + 1);
			win[t1]++;
			lose[t2]++;
		}

		if (lose[t1] > 0 && win[t2] > 0) {
			lose[t1]--;
			win[t2]--;
			dfs(game + 1);
			lose[t1]++;
			win[t2]++;
		}

		if (mo[t1] > 0 && mo[t2] > 0) {
			mo[t1]--;
			mo[t2]--;
			dfs(game + 1);
			mo[t1]++;
			mo[t2]++;
		}

	}
}
