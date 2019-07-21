package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_73_Robot {

	static int T,N; 
	static char[][] robot; //�����迭. 
	boolean boundary(int x, int y)
	{
		if (x < 0 || y < 0 || x >= N || y >= N)
		{
			return false; 
		}
		return true; 
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null; 
		T = Integer.parseInt(br.readLine()); //�ְ��� ����. (�빮��) 
		// �� �ͼ����Ѵٴ°��� ..? 
		for (int t = 1; t <= T; t++) 
		{
			N = Integer.parseInt(br.readLine());
			// Integer���� ������ ����. 
		    robot = new char[N][N];		    
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				// line = " S A W W W A A A A "
				st = new StringTokenizer(line, " "); // ������ �� �� ����.
				for (int j = 0; j < N; j++) 
				{	
					robot[i][j] = st.nextToken().charAt(0); // char�迭�� �ٲ��ش�					
				}
			}
			print(robot);
			System.out.println("#"+t +" " );
		}
	}
	static public void print(char[][] ro)
	{
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < N; j++)
			{
				System.out.printf("%c ",ro[i][j]);
			}
			System.out.println();
		}				
	}
}


/*
3
6
S A S S W S
S W A S C S
S W S W S S
S W S S W S
S B S S W S
S S S S S S
3
S S A
B W W
S W C
10
C S S S S S S S S C
S W S S S S S S W S
S S W S S S S W S S
A S S W S S W S S A
S S S S S B S S S S
S S S S B S S S S S
A S S W S S W S S A
S S W S S S S W S S
S W S S S S S S W S
C S S S S S S S S C
*/
