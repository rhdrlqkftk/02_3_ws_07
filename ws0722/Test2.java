import java.util.Scanner;

public class Test2 {
		static int N;
		static int map[][] = new int[100][100];
		static int dx[] = new int[] {  0, 0 };
		static int dy[] = new int[] {  1,-1 };
		static boolean boundary(int x, int y) {
			if (x < 0 || y < 0 || x >= 100 || y >= 100) {
				return false;
			}
			return true;
		}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
		//	int T = sc.nextInt(); // 주관식 문제. (대문자)
			for (int t = 1; t <= 10; t++) 
			{
				int x=0, y=0;
				N=  sc.nextInt();
				for (int i = 0; i < 100; i++)
				{
					for (int j = 0; j < 100; j++)
					{
						map[i][j] = sc.nextInt();
						if( map[i][j] ==2)
						{
							x = i;
							y = j;
						}
					}
				}
				int nx ,ny,flag =0;
				while(x>0)
				{	
					x =  x - 1;
					for( int i =0 ; i< 2; i++)
					{
						flag=0;
						nx = x+ dx[i];
						ny = y+ dy[i];
						while(boundary(nx, ny)==true && map[nx][ny] ==1)
						{
							flag = 1;
							nx = nx + dx[i]; 
							ny = ny + dy[i];
						}
						if( flag == 1)
						{
							x = nx-dx[i]; 
							y = ny-dy[i]; 
							break;	
						}
					}
					
				}
				System.out.println("#" + t + " " + y);
			}
		}
	}
/*
	int N; 
		
		int [] arr= new int [] {}; 
		for(int i=0; i<(1<<arr.length); i++)
		{
			System.out.print(i+": {");
			for (int j = 0; j < arr.length; j++) {
				if(( i & (1<<j)) != 0)
				{
						System.out.print(arr[j]+" ");
				}
			}
			System.out.println("}");
		}

 */