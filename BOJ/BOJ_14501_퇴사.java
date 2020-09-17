package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {

	static int N;
	static int[][] consult;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		consult = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				consult[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < 2; j++) {
//				System.out.print(consult[i][j]);
//			}
//		}
		
		max = 0;
		for (int i = 0; i < N; i++) {
			dfs(i, consult[i][0], consult[i][1]);
		}
		
		System.out.println(max);
	}
	private static void dfs(int current, int plusday, int value) {
		
		if (current + plusday > N) {
			return;
		}
		
		if (current + plusday <= N) {
			if (value > max) {
				max = value;
			}
		}
		
		for (int i = 0; i < N; i++) {
			int newCurrent = current + plusday + i;
			if (newCurrent < N) {
				dfs(newCurrent, consult[newCurrent][0], value + consult[newCurrent][1]);	
			}	
		}
	}

}
