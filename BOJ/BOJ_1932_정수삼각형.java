package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][];
		int[][] copy = new int[n][];

		for (int i = 0; i < n; i++) {
			arr[i] = new int[i+1];
			copy[i] = new int[i+1];

			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		copy[0][0] = arr[0][0];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j == 0) {
					copy[i][j] = copy[i-1][j] + arr[i][j];
				} else if (j == i) {
					copy[i][j] = copy[i-1][j-1] + arr[i][j];
				} else {
					copy[i][j] = arr[i][j] + Math.max(copy[i-1][j], copy[i-1][j-1]);
				}
			}
		}

		int result = 0;
		for (int j = 0; j < copy[n-1].length; j++) {
			result = Math.max(copy[n-1][j], result);
		}

		System.out.println(result);
	}

}
