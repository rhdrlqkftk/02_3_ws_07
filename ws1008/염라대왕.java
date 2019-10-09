package ws1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
public class 염라대왕 {
	static TreeSet<String> treset;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc =1; tc<= T; tc++)
		{
			int N = Integer.parseInt(br.readLine());
			treset= new TreeSet<String>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {

					if( o1.length() == o2.length()) //길이가 같다면. 
					{
						return o1.compareTo(o2); // 사전순으로 한다는거 
					}
					else
					{
						return o1.length() -o2.length(); // 길이 짧은 순서 부터 한다는거. 
						// 오름차순으로 하겠다라는 말이야 그냥. 
					}
				}
			}); 
			treset.clear();
			for(int i = 0; i <N;i++)
			{
				treset.add(br.readLine()); 
			}
			System.out.println("#" +tc);	
			for( String f : treset)
			{
				System.out.println(f);
			}
		}
	}
}
/*
 * 사용 collection  = TreeSet( 중복 제거, 정렬 )// 정렬 기준은 내가 잡아줬다. 
 * 특징
 * 1. 같은 이름 중복을 제거합니다.
 * 2. 길이가 짧은 순서로 합니다. 
 * 3. 길이가 같다면 사전 순으로 앞에 있는거로! 
 * 2가지 버전으로 해보자 // 시간된다면. 
 * ( 1번 라이브러리를  쓰지않고 2번 라이브러리를 쓰고 ) 
 * */