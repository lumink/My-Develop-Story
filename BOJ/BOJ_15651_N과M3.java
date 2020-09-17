package ssafy;
import java.util.Scanner;

public class BOJ_15651_N과M3 {
	
	static int N, M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		make(0);
	}
	private static void make(int cnt) {
		
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}System.out.print("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[cnt] = i + 1;
			make(cnt+1);
		}
	}

}
