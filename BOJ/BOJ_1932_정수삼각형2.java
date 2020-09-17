package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형2 {

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

		int temp = 0, sum = 0, result = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int k = 0; k < 2; k++) {
					temp = 0;
					if (k == 0 && j < arr[i].length - 1) {
						temp = copy[i-1][j] + arr[i][j];
					} else if (k == 1 && j - 1 >= 0) {
						temp = copy[i-1][j-1] + arr[i][j];
					}
					sum = Math.max(copy[i][j], temp);
					copy[i][j] = sum;
				}
				// if (i == arr.length -1) {
				// result = Math.max(copy[i][j], result);
				// }
			}
		}

		for (int j = 0; j < copy[n-1].length; j++) {
			result = Math.max(copy[n-1][j], result);
		}

		System.out.println(result);
	}

}