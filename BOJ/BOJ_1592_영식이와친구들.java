package ssafy;
import java.util.Scanner;

public class BOJ_1592_영식이와친구들 {

	static int N, M, L;
	static int[] table;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();

		table = new int[N];

		int ball = 0; // 현재 가진 볼 수 확인
		int count = 0; // 공을 던지 횟수 카운
		int i = 0; // 인덱스 움직일때
		boolean finalball = true;

		// 영식이가 처음 던지는거
		table[i] += 1;
		// System.out.println(table[i] + " " + i);

		if (M == 1) {
			finalball = false;
		} else {
			if (i + L < N) {
				i = i + L;
				count++;
				table[i] += 1;
				// System.out.println(table[i] + " " + i);
			} else {
				i = i + L - N;
				count++;
				table[i] += 1;
				// System.out.println(table[i] + " " + i);
			}
		}

		// 두번째 턴부터
		while (finalball) {

			// 짝수일때 반시계
			if (table[i] % 2 == 0) {
				if (i - L >= 0) {
					i = i - L;
					count++;
					table[i] += 1;
					// System.out.println(table[i] + " " + i);
				} else {
					i = N - L + i;
					count++;
					table[i] += 1;
					// System.out.println(table[i] + " " + i);
				}
			} else {
				if (i + L < N) {
					i = i + L;
					count++;
					table[i] += 1;
					// System.out.println(table[i]+ " " + i);
				} else {
					i = i + L - N;
					count++;
					table[i] += 1;
					// System.out.println(table[i] + " " + i);
				}
			}

			// 던진 이후에 파이널 볼인지 확인 맞다면
			for (int b = 0; b < N; b++) {
				if (table[i] == M) {
					finalball = false;
					break;
				}
			}

		}

		System.out.println(count);

	}

}
