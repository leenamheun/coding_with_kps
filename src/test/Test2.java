package test;

import java.util.Scanner;


public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		String[] scores = sc.next().split(",");
		
		int[][] map = new int[y][x];
		int[][][] dp = new int[y][x+2][x+2];
		
		for(int i=0; i<scores.length; i++) {
			String s = scores[i];
			int row = i/x;
			int col = i%x;
			int score = Integer.parseInt(s);
			map[row][col] = score;
			
		}
		
		dp[0][1][x] = map[0][0] + map[0][x-1];
		int result = 0;
		
		for(int row=1; row<y; row++) {
			for(int j=1; j <= x; j++) {
				for(int k=1; k <= x; k++) {
					int w = map[row][j-1];
					if(j != k) w += map[row][k-1];
					
					int maxPrev = 0;
					for(int nx=-1; nx<=1; nx++) {
						int neoCol = j + nx;
						for(int px=-1; px<=1; px++) {
							int prodoCol = k + px;
							
							maxPrev = Math.max(maxPrev, dp[row-1][neoCol][prodoCol]);
						}
					}
					dp[row][j][k] = maxPrev + w;
					result = Math.max(result, dp[row][j][k]);
				}
			}
		}
		
		System.out.println(result);
	}
	
	
}
