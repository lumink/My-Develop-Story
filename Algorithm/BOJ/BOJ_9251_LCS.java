package ssafy;

import java.util.Scanner;

public class BOJ_9251_LCS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = "0" + sc.next();
		String s2 = "0" + sc.next();
		
		int[][] dp = new int[1001][1001];
		
		for (int i = 1; i < s1.length(); i++) {
			for (int j = 1; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					int max = Math.max(dp[i-1][j], dp[i][j-1]);
					dp[i][j] = max;
				}
			}
		}
		System.out.println(dp[s1.length()-1][s2.length()-1]);
	}
}
