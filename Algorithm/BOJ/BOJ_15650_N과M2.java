package ssafy;
import java.util.Scanner;

public class BOJ_15650_N과M2 {

	static int N, M;
	static int[] com;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		com = new int[M];
		visited = new boolean[N];
		
		combi(0,0);

	}
	private static void combi(int start, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(com[i] + " ");
			}System.out.print("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				com[cnt] = i + 1;
				combi(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}

}
