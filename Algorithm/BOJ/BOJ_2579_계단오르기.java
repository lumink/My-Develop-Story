package ssafy;
import java.util.Scanner;

public class BOJ_2579_계단오르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] memo = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		
		memo[1] = arr[1]; //1까지의 최대값은 1을 밟았을때 
		if (n >= 2) {
			memo[2] = arr[1] + arr[2]; //2까지의 최대값은 1 + 2를 밟았을 때 
		}
 	
		//점화식을 이용하여 2개의 식을 유도함
		//연속적 3개의 계단을 제거하기 위하여 2개의 식을 이용하여 최대값을 구함 
		for (int i = 3; i <= n; i++) {
			memo[i] = Math.max(memo[i-3] + arr[i-1] + arr[i],
					memo[i-2] + arr[i]);
		}
		System.out.println(memo[n]);
	}
}
