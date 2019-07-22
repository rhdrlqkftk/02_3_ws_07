package com.ssafy.edu;

import java.util.Scanner;

public class Test {
	static int N, C, ans;
	static int visited[][] = new int[][] {};
	static int map[][] = new int[][] {};
	static int flag = 0;
	static int dx[] = new int[] { 0, 1, 0 };
	static int dy[] = new int[] { 0, 0, 1 };
	static boolean boundary(int x, int y) {
		if (x <= 0 || y <= 0 || x > N || y > N) {
			return false;
		}
		return true;
	}
	static void make(int id, int x, int y, int dir)
	{
		int c = 3;
		if (map[x][y] != 0)
		{
			ans = id;
			flag = 1;
			return;
		}
		else
		{
			map[x][y] = id;
		}
		while (c!=0) {
			x = x + dx[dir] * c;
			y = y + dy[dir] * c;
			if (boundary(x, y) == false) {
				return;
			}

			if (map[x][y] != 0)
			{
				ans = id;
				flag = 1;
				return;
			}
			map[x][y] = id;
			c--;
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 주관식 문제. (대문자)
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int C = sc.nextInt();
			int x, y, dir;

			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					map[i][j] = 0;
				}
			}
			ans = 0;
			flag = 0;
			for (int i = 1; i <= C; i++)
			{
				x = sc.nextInt();
				y = sc.nextInt();
				dir =sc.nextInt();
				make(i, x, y, dir);
				if (flag == 1)break;
			}
			System.out.println("#" + t + " " + ans);
		}

	}
}
