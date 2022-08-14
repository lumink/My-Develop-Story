package ssafy;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11404_플로이드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] D = new int[n+1][n+1];
		int max = 10000001;
		
		for (int i = 0; i <= n; i++) {
			Arrays.fill(D[i], max);
		}
		
		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int w = sc.nextInt();
			if (D[from][to] > w) {
				D[from][to] = w;
			} 
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (k == i) continue;
				for (int j = 1; j <= n; j++) {
					if (k == j || i == j) continue;
					if (D[i][k] != max && D[k][j] != 0 && D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (D[i][j] == max || i == j) {
					D[i][j] = 0;
				}
				System.out.print(D[i][j] + " ");
			}System.out.println();
		}
	}

}
