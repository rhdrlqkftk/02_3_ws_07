package ws1028;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class 올해의조련사 {
	static int N; 
	static LinkedList<Character> l = new LinkedList<>();
	static PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {

		@Override
		public int compare(Character o1, Character o2) {
			// TODO Auto-generated method stub
			return o1-o2;
		}
	});
	static LinkedList<Character> n2 = new LinkedList<>();
	static LinkedList<Character> result = new LinkedList<>();


	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int tc= 1; tc<= T; tc++)
		{
			N = sc.nextInt(); 
			for(int i=0;i <N ; i++)
			{
				char s = sc.next().charAt(0);
				l.add(s);
			}
			System.out.print("#" +tc + " ");
			char start; 
			char end;
			while(!l.isEmpty())
			{
				 start = l.getFirst();
				 end   = l.getLast();	
				 if( start - end == 0) // 같을경우에는 어떻게해줘야해? 
				 {
					 int tempL = 0; 
					 int tempR = l.size()-1;
					 while(tempL <tempR && l.get(++tempL) == l.get(--tempR))
					 {
						 continue;
					 }
					 if( tempL == tempR ) // 끝까지 같다는거니까? 
					 {
						 System.out.print(end);
						 l.removeLast();
					 }
					 else 
					 {
						 // left를 넣을꺼야 right를 넣을꺼야? 
						 if( l.get(tempL)-l.get(tempR) >0)
						 {
							 System.out.print(end);
							 l.removeLast();
						 }
						 else 
						 {
							 System.out.print(start);
							 l.removeFirst(); 
						 }
					 }			 
				 }
				 else if( start - end > 0)
				 {
					 System.out.print(end);
					 l.removeLast();  //넣어준건 제거 해줘야지.
				 }
				 else 
				 {
					 System.out.print(start);
					 l.removeFirst();  //넣어준건 제거 해줘야지.
				 }
			}
			System.out.println();
		}
	}
}
// (first, last) = get, remove, add