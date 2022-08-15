package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2294_동전2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coin);
		
//		for (int i = 0; i < n; i++) {
//			for (int j = n-1; j >= 0; j--) {
//				coin[i] = coin[j];
//			}
//		}
		
		Arrays.fill(dp, 100000);
		
		dp[0] = 0;
		
		int sum = 0;
		for (int i = 0; i < coin.length; i++) {
			for (int j = coin[i]; j < k+1; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}
		
		if (dp[k] != 100000) {
			System.out.println(dp[k]);
		} else {
			System.out.println(-1);
		}
		
	}

}
