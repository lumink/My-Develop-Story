package ssafy;
import java.util.Scanner;

public class BOJ_15649_N과M1 {

	static int[] p;
	static boolean[] visitied;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		visitied = new boolean[N];
		p = new int[M];
		perm(N, M, 0);
	}

	private static void perm(int n, int m, int cnt) {
		
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(p[i] + " ");
			}System.out.println();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visitied[i]) {
				visitied[i] = true;
				p[cnt] = i+1;
				perm(n, m, cnt+1);
				visitied[i] = false;
			}
		}
		
	}
}