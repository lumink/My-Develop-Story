package ssafy;
import java.util.Scanner;

public class B0J_11399_ATM2 {

	static int N;
	static int[] perm;
	static int output;
	static int[] sum;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		int[] pi = new int[N];
		perm = new int[N];
		sum = new int[N];
		
		for (int i = 0; i < N; i++) {
			pi[i] = sc.nextInt();
		}

		output = Integer.MAX_VALUE;

		permutation(pi, 0, 0);
		System.out.println(output);

	}

	public static void permutation(int[] pi, int flag, int count) {

		if (count == N) {

			int finalsum = 0;

			for (int i = 0; i < N; i++) {
				System.out.print(perm[i] + " ");
			}
			System.out.println();

			for (int i = 0; i < N; i++) {
				if (i == 0) {
					sum[i] = perm[i];
				} else {
					sum[i] = sum[i-1] + perm[i];
				}
			}

			for (int i = 0; i < N; i++) {
				finalsum += sum[i];
			}

			output = Math.min(output, finalsum);

			return;
		}

		for (int i = 0; i < N; i++) {

			if ((flag & 1 << i) != 0) {
				continue;
			}

			if ((flag & 1 << i) == 0) {
				perm[count] = pi[i];
				permutation(pi, flag | 1 << i, count + 1);
			}

		}

	}

}
