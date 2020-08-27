import java.util.Scanner;

public class BOJ_Nqueens {
	static int n;
	static int map[][];
	static int cur[];
	static int res = 0;
	static int row = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		cur = new int[n];

		// 열 검사
		for (int i = 0; i < n; i++) {
			map[0][i] = 1;
			cur[row] = i;// 행에 현재 위치 저장
			dfs(0, i, row+1);
			map[0][i] = 0;
		}

		System.out.println(res);
	}

	private static void dfs(int cx, int cy, int row) {
		if (row == n) {
			res++;
			return;
		}
		int nx = 0;
		int ny = 0;
		nx = cx + 1;
		ny = cy;
		for (int i = 0; i < n; i++) {
			int isLoc = 1;
		
			for (int a = 0; a < row; a++) {
				if (cur[a] == i) {// 같은열이면 안된다
					isLoc=0;
					break;
				}
				//System.out.print("대각확인"+Math.abs(a - nx ));
				//System.out.println(Math.abs(cur[a] - i));
				if (Math.abs(a - nx ) == Math.abs(cur[a] - i)) {// 대각선이면 안됩니다
					//System.out.println("대각선임");
					isLoc = 0;
					break;
				}
			}
			if (isLoc == 1) {
				//System.out.println(row+" "+i+" 에 저장");
				cur[row]=i;//현재행위 위치저장
				dfs(nx, i, row + 1);
			}
		}
		// 같은열이 아니라면 위치시킵니다

	}
}
