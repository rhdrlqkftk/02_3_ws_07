package ssafy1001;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
public class Main_빵집 {
	static char map[][];
	static boolean visited[][];
	static int R, C;
	static int dx[] ={-1,0,1};
	static int dy[] ={ 1,1,1};
	static int ans =0; // 출발점에서 도착점까지의 거리. 
	static boolean boundary(int x,int y)
	{
		if( x < 0 || y < 0 || x >= R || y >= C)
		{
			return false; 
		}
		return true; 
	}
	
	public static void main(String[] args)throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String rc[]  = br.readLine().split(" "); 
		R = Integer.parseInt(rc[0]);
		C = Integer.parseInt(rc[1]); 
		map= new char[R][C];
		visited = new boolean[R][C];
		for(int i=0 ; i< R; i++)
		{
			map[i] = br.readLine().toCharArray(); 
		}
		for(int i=0 ; i < R; i++)
		{
			ans += pipe(i,0);
		}
		System.out.println(ans);
	}
	static int pipe(int x,int y)
	{
		map[x][y] = 'x';
		if( y == C-1)
		{
			return 1;
		}
		for(int i =0 ; i <3; i++)
		{
			int nx = x+ dx[i];
			int ny = y+ dy[i];
			if( !boundary(nx,ny)) continue;  
			if( map[nx][ny] =='x') continue;  
			if(pipe(nx,ny)== 1) return 1; 
		}
		return 0;
	}
}
