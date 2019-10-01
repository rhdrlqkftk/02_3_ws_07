package ssafy1001;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
public class Main_탈출 {
	static char map[][];
	static int R, C;
	static boolean[][]  visitW, visitB; 
	static int dx[] = {0,1,0,-1}; 
	static int dy[] = {1,0,-1,0};
	static int ans =0; // 출발점에서 도착점까지의 거리. 
	static Queue <pair>qW ;
	static Queue <pair>qB ;
	static boolean boundary(int x,int y)
	{
		if( x < 0 || y < 0 || x >= R || y >= C)
		{
			return false; 
		}
		return true; 
	}
	static class pair
	{
		int x; 
		int y; 
		int dist; 
		pair(int _x, int _y, int _dist)
		{
			x =_x; 
			y =_y; 
			dist= _dist; 
		}
	}
	/*
	[제한 조건]
	1. 물과 고슴도치는 돌을 통과할 수 없다. 
	2. 물은 비버 소굴로 침입 불가, 고슴도치는 물로 차있는 구역으로 이동 못한다. 
	3. 비버의 굴로 갈 수 없다면 "KAKTUS"를 출력하라.
	// 고슴도치가 비버의 굴로 이동하기 위한 최소시간을 구하라.
	 */
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String rc[]  = br.readLine().split(" "); 
		R = Integer.parseInt(rc[0]);
		C = Integer.parseInt(rc[1]); 
		map= new char[R][C];
		visitW = new boolean[R][C];
		visitB = new boolean[R][C];
		qW = new LinkedList<>();
		qB = new LinkedList<>();		
		// D = 비버의 굴 
		// S = 고슴도치의 위치 
		// * = 물이 차있는 지역 ( 여러 곳일 수 있다 )  
		// X = 돌 
		// . = 비어있는곳. 
		for(int i =0 ; i<R; i++)
		{
			map[i] = br.readLine().toCharArray();
			for(int j=0;j < C; j++)
			{
				if( map[i][j] =='S') // 고슴도치의 위치. 
				{
					qB.add( new pair(i,j,0));
					visitB[i][j] =true;
				}
				else if( map[i][j] =='*')
				{
					qW.add(new pair(i,j,0));
					visitW[i][j] = true;
				}
			}
		}
		// 지도 입력 완료. 
		bfs(); 
		
		if( ans ==0)
		{
			System.out.println("KAKTUS");
		}
		else
		{	
			System.out.println(ans);
		}
		 
		// 고슴도치가 안전하게 비버의 굴로 이동하기 위한 필요한 최소한 시간 구하기.  
		// 고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다? 즉 , 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동 불가하다.  
	}
	static void bfs()
	{
		// 비버가 이동 가능한 좌표가 남아 있다면 계속 반복할 것임
		while(!qB.isEmpty()) 
		{
			// 일단 물이 번질 예정인 곳에 비버가 못가니까 비버 이동시키기 전에 그냥 물번짐을 먼저 처리
			int waterCnt =qW.size();  
			for(int w=0 ;w<waterCnt; w++)
			{
				pair p = qW.poll(); 
				for(int d =0 ; d<4; d++)
				{
					int nx = p.x +dx[d];
					int ny = p.y +dy[d];
					if(!boundary(nx,ny)) continue;  
					if( map[nx][ny] == 'D' || map[nx][ny]  == 'X'|| visitW[nx][ny] ==true) continue; 
					qW.add(new pair( nx,ny,0)); // 다음 초에 물번짐을 위해서 큐에 넣음.  
					visitW[nx][ny] =true;  
					map[nx][ny] = '*';
				}
			}
			int MoveCnt = qB.size();  
			for(int m =0; m <MoveCnt; m++)
			{
				pair beaver = qB.poll();  
				if( map[beaver.x][beaver.y]=='D')
				{
					ans = beaver.dist; 
					return; 
				}
				for(int d=0; d<4; d++)
				{	
					int nx = beaver.x + dx[d];
					int ny = beaver.y + dy[d];
					if(!boundary(nx,ny)|| visitB[nx][ny]== true) continue; 
					if( map[nx][ny] =='D' || map[nx][ny] =='.')
					{
						qB.add(new pair(nx,ny,beaver.dist+1));
						visitB[nx][ny] = true; 
					}
				}
			}
		}
		
		// 물 번짐 한턴 진행함 . 이제 비버를 울직여야 한다. 
	
	}
}
