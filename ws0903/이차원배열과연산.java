import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5{
	static int r,c,k;
	static int rsize, csize; 
	static int CntChk[];
	static int Map[][];

	static class pair implements Comparable<pair>
	{
		int value; 
		int time; 
		pair(int val,int t )
		{
			value = val; 
			time=t; 
		}
		@Override
		public int compareTo(pair o2) {
			if( this.time == o2.time)
			{
				return this.value - o2.value ; // 오름 차순. 
			}
			return this.time- o2.time;
		}
		
	}
	static PriorityQueue<pair> qu; 
//	static class Mycomp implements Comparator<pair>
//	{
//	    @Override
//		public int compare(pair o1, pair o2) {
//			if( o1.time == o2.time)
//			{
//				return o1.value - o2.value ; // 오름 차순. 
//			}
//			return o1.time- o2.time; // 오름 차순. 
//		}
//	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		qu= new PriorityQueue<pair>();
		Map = new int[100][100];
		CntChk = new int[101];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1; 
		k = Integer.parseInt(st.nextToken());

		rsize = 3; 
		csize = 3; 
		for( int i =0 ; i < rsize; i++)
		{
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < csize; j++) 
			{
				Map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		int time =0;
		boolean chk =false;
		for(int tm = 0; tm <=100;tm++)
		{
			if( Map[r][c] == k)
			{
				chk =true;
				time = tm;
				break;
			}
			if( rsize >= csize)
			{
				
				for( int i =0 ; i < rsize; i++)
				{
					for (int j = 0; j < csize; j++) 
					{
						if( Map[i][j] == 0) continue;
						CntChk[Map[i][j]]++; 
					}
					for( int j=1;j < CntChk.length;j++)
					{
						if( CntChk[j] !=0 )
						{
							qu.add(new pair( j, CntChk[j]));
						}
					}
					int idx= 0; 
					while(!qu.isEmpty())
					{
						pair p = qu.poll();
						if( idx >100)break; 
						Map[i][idx++] = p.value; 
						Map[i][idx++] = p.time;
					}
					while( !qu.isEmpty())
					{
						qu.poll();
					}
					csize = Math.max( csize, idx);
					if( idx <100)
					{
						for(int kk = idx; kk<100;kk++)
						{
							Map[i][kk] =0;
						}						
					}
					Arrays.fill(CntChk, 0);
				}				
			}
			else if( rsize < csize)
			{
				for (int j = 0; j < csize; j++) 
				{
					for( int i =0 ; i < rsize; i++)
					{
						if(Map[i][j] == 0) continue;						
						CntChk[Map[i][j]]++; 
					}
					for( int i=1; i < CntChk.length;i++)
					{
						if( CntChk[i] !=0 )
						{
							qu.add(new pair( i, CntChk[i]));
						}
					}
					int idx =0;
					while(!qu.isEmpty())
					{
						pair p = qu.poll();
						if( idx > 100) break;
						Map[idx++][j] = p.value; 
						Map[idx++][j] = p.time;
					}
					while( !qu.isEmpty())
					{
						qu.poll();
					}
					rsize = Math.max( rsize, idx);
					if( idx <100)
					{
						for(int kk =idx; kk<100;kk++)
						{
							Map[kk][j] =0;
						}
					}
					Arrays.fill(CntChk, 0);
				}
			}
			time++;
		}
		if( chk == false)
		{
			time = -1;
		}
		bw.write(time +"\n");
		bw.flush();
		bw.close();
	}

}
