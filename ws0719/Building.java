package com.ssafy.edu;

 

import java.util.Scanner;

 

public class Building {

 

	static int N;

	static int Max;

	static int[] dx = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };

	static int[] dy = new int[] { 1, 1, 0, -1, -1, -1, 0, 1 };

	static char[][] Map;

 

	static boolean boundary(int x, int y) {

		if (x < 0 || y < 0 || x >= N || y >= N) {

			return false;

		}

		return true;

	}

 

	static int chk(int x, int y) {

		int cnt = 0;

		for (int i = 0; i < N; i++) {

			if (Map[i][y] == 'B') {

				cnt++;

			}

		}

		for (int i = 0; i < N; i++) {

			if (Map[x][i] == 'B') {

				cnt++;

			}

		}

		return cnt - 1;

	}

 

	static void make(int x, int y) {

		int nx, ny;

		int flag = 0;

		for (int i = 0; i < 8; i++) {

			nx = x + dx[i];

			ny = y + dy[i];

			if (boundary(nx, ny) == false)

				continue;

			if (Map[nx][ny] != 'B') {

				flag = 1;

				break;

			}

		}

		if (flag == 0) {

			int k = chk(x, y);

			if (k > Max)

				Max = k;

		}

	}

 

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

 

		int T = sc.nextInt(); // 주관식 문제. (대문자)

		for (int t = 1; t <= T; t++) {

			Max = 0;

			Map = new char[21][21];

 

			N = sc.nextInt();

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {

					Map[i][j] = sc.next().charAt(0);

				}

			}

 

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {

					if (Map[i][j] == 'B') {

						make(i, j);

					}

				}

			}

			System.out.println("#" + t + " " + Max);

		}

	}

}