	package ws1028;
	
	import java.util.Comparator;
	import java.util.PriorityQueue;
	import java.util.Scanner;
	
	//11 : 23 분 시작. 
	public class NUMBER1 {
		public static void main(String[] args) 
		{
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();  
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() 
			{
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
			});
			for(int tc =1; tc<= T; tc++)
			{
				int N = sc.nextInt();
				for(int i =0; i < N; i++)
				{
					pq.add(sc.nextInt());			
				}
				int tt = 1;
				int sum =0;
				while(!pq.isEmpty())
				{
					int G = pq.poll();
					if( tt ==3)
					{
						tt=1;
						continue;
					}
					sum += G;
					tt++;
				}
				System.out.println("#"+tc+" "+ sum);
			}
		}
	}
