package ssafy;
import java.util.Arrays;
import java.util.Scanner;

public class B0J_11399_ATM {

	static int N;
	static int[] pi;
	static int[] sum;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		int[] pi = new int[N];
		sum = new int[N];
		int finalsum = 0;
		
		for (int i = 0; i < N; i++) {
			pi[i] = sc.nextInt();
		}
		
		Arrays.sort(pi);
		
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				sum[i] = pi[i];
			} else {
				sum[i] = sum[i-1] + pi[i];
			}
		}

		for (int i = 0; i < N; i++) {
			finalsum += sum[i];
		}

		System.out.println(finalsum);

	}

}
