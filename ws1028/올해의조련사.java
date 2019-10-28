package ws1028;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class ���������û� {
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
				 if( start - end == 0) // ������쿡�� ����������? 
				 {
					 int tempL = 0; 
					 int tempR = l.size()-1;
					 while(tempL <tempR && l.get(++tempL) == l.get(--tempR))
					 {
						 continue;
					 }
					 if( tempL == tempR ) // ������ ���ٴ°Ŵϱ�? 
					 {
						 System.out.print(end);
						 l.removeLast();
					 }
					 else 
					 {
						 // left�� �������� right�� ��������? 
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
					 l.removeLast();  //�־��ذ� ���� �������.
				 }
				 else 
				 {
					 System.out.print(start);
					 l.removeFirst();  //�־��ذ� ���� �������.
				 }
			}
			System.out.println();
		}
	}
}
// (first, last) = get, remove, add