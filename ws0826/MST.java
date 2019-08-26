
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution{
	static int V, E; 
	static int arr[];
	static ArrayList<edge> mst;
	static PriorityQueue<edge> q = new PriorityQueue<edge>(new Comparator<edge>() {

		@Override
		public int compare(edge o1, edge o2) {
			// TODO Auto-generated method stub
			return o1.val -o2.val;
		}
	});
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for( int t = 1; t<=T; t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			V = Integer.parseInt(st.nextToken()); //정점의 갯수
			E = Integer.parseInt(st.nextToken()); //간선의 갯수
			
			arr = new int[V+1];
			// 가중치를 가진다.	
			for(int i =1 ; i<= E; i++)
			{
				st = new StringTokenizer(br.readLine()); 
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				q.add( new edge(x,y,v));
			}
			kruskal();
			long sum =0;
			for(int i =0; i<mst.size();i++)
			{
				sum += mst.get(i).val;
			}
			bw.write("#"+ t+ " "+ sum+ "\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void kruskal()
	{
		mst = new ArrayList<>();  // 어레이 리스트 를 슨다. 
		for(int i=1 ; i <= V;i++)
		{
			arr[i] = i;
		}
		while( mst.size() < (V-1))
		{
			edge e = q.poll();  
	//		System.out.println(e);	
			// x, y의 수에서 .부모를 찾는다. 같지 않다면? 
			// 연결해준다. 
			if( find(e.x )!= find(e.y))
			{
				union(e.x,e.y);
				mst.add(e);
			}
		}

	}
	static int find(int x)
	{
		if(arr[x] ==x)
		{
			return x; 
		}
		arr[x]= find( arr[x]);
		return arr[x]; 
	}
	static void union(int a, int b)
	{
		// 최상위 개념을 연결해준다.
		if( find(a) != find(b))
		{
			arr[find(a)] = find(b);
		}
		
	}
	static class edge
	{
		int x; 
		int y; 
		int val;  
		edge( int x1, int y1, int val1)
		{
			x = x1; 
			y = y1; 
			val = val1;
		}
	}
}

/*
1
3 3
1 2 1
2 3 2
1 3 3
*/