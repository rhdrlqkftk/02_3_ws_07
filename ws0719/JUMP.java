package com.ssafy.edu;

 

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.Scanner;

import java.util.StringTokenizer;

 

public class Jump {

	static int X, Y, N, Sum;

	static int[] dx = new int[] { 0, 1, 0, -1 };

	static int[] dy = new int[] { 1, 0, -1, 0 };

	static int[][] Map;

	static Party p[];

 

	static class Party {

		int Px, Py, Pn, money;

 

		Party(int px, int py, int pn) {

			this.Px = px;

			this.Py = py;

			this.Pn = pn;

			this.money = -1000;

		}

	}

 

	static boolean boundary(int x, int y) {

		if (x <= 0 || y <= 0 || x > X || y > Y) {

			return false;

		}

		return true;

	}

 

	static int make(int r, int c, int cnt) {

		int money = 0;

		for (int i = 0; i < cnt; i++) {

			int k = Map[r][c];

			if (k == 0) {

				money = -1000;

				return money;

			}

			int dir = k / 10; // ����

			dir = dir - 1;

			int CN = k % 10; // �̵� ĭ��.

			r = r + CN * dx[dir]; // x��ǥ.

			c = c + CN * dy[dir]; // y��ǥ.

			if (boundary(r, c) == false) {

				money = -1000;

				return money;

			}

		}

		money = Map[r][c] * 100 - 1000;

		return money;

	}

 

	public static void main(String[] args)throws Exception {

		Scanner sc = new Scanner(System.in);

 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine()); // �ְ��� ����. (�빮��)

		// �� �ͼ����Ѵٴ°��� ..?

		for (int t = 1; t <= T; t++) {

 

			Map = new int[21][21];

			Sum = 0;

			X = sc.nextInt(); // �迭 ũ��

			Y = sc.nextInt();

			N = sc.nextInt();

			for (int i = 1; i <= X; i++) {

				for (int j = 1; j <= Y; j++) {

					Map[i][j] = sc.nextInt();

				}

			}

			// ���� ��ġ ��, ��,���� Ƚ���� ����.

			p = new Party[N];

			for (int i = 0; i < N; i++) {

				int r = sc.nextInt();

				int c = sc.nextInt();

				int J_C = sc.nextInt();

				p[i] = new Party(r, c, J_C);

			}

			int z = sc.nextInt();

			for (int i = 0; i < z; i++) {

				int r = sc.nextInt();

				int c = sc.nextInt();

				Map[r][c] = 0; // �����κ�.

			}

			// �Է� �Ϸ�.. .

 

			for (int i = 0; i < p.length; i++) {

				int px = p[i].Px;

				int py = p[i].Py;

				int pn = p[i].Pn;

				Sum += make(px, py, pn);

 

			}

			System.out.println("#"+t +" "+ Sum );

		}

	}

 

}


