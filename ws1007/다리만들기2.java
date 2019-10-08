package ssafy1007;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 다리만들기3 {
	static boolean boundary(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= M) {
			return false;
		}
		return true;
	}

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int N, M, cnt;
	static ArrayList<edge> mst;
	static int chk[];
	static int Map[][];
	static boolean visit[][];
	static PriorityQueue<edge> pq;

//	static class edgeComparator implements Comparator<edge>
//	{
//		@Override
//		public int compare(edge o1, edge o2) 
//		{
//			return o1.value - o2.value; //가중치로 비교하겠다. 
//		}
//	}
	static class edge implements Comparable<edge> {
		int start;
		int end;
		int value;

		edge(int _start, int _end, int _value) {
			start = _start;
			end = _end;
			value = _value;
		}

		@Override
		public int compareTo(edge o) {
			return this.value - o.value;
		}
	}

	static void kruskal() {
		int size = cnt;// 1~4
		chk = new int[size + 1]; // 정점의 갯수..
		for (int i = 1; i <= size; i++) {
			chk[i] = i;
		}
		while (!pq.isEmpty() && mst.size() < size - 1) {
			edge e = pq.poll();
			if (find(e.start) != find(e.end)) {
				union(e.start, e.end);
				mst.add(e);
			}
		}
	}

	// 부모가 있는지 찾는다.
	static int find(int n) {
		if (chk[n] == n) {
			return n;
		}
		chk[n] = find(chk[n]);
		return chk[n];
	}

	// 합친다.
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		if (p1 != p2) // 부모가 같지 않다면 합친다. !!
		{
			chk[p1] = p2;
		}
	}
	///////// find함수, union 함수 만들어주기.

	static class pair {
		int x;
		int y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs(int x, int y) {
		Queue<pair> q = new LinkedList<pair>();
		Map[x][y] = cnt;
		visit[x][y] = true;
		q.add(new pair(x, y));
		while (!q.isEmpty()) {
			pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (!boundary(nx, ny))
					continue;
				if (visit[nx][ny] || Map[nx][ny] == 0)
					continue;
				visit[nx][ny] = true;
				Map[nx][ny] = cnt;
				q.add(new pair(nx, ny));
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		pq = new PriorityQueue<edge>();

		N = sc.nextInt();
		M = sc.nextInt();
		Map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Map[i][j] = sc.nextInt();
			}
		}
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (Map[i][j] == 1 && visit[i][j] == false) {
					++cnt;
					bfs(i, j);
				}
			}
		}

			
		int rechk[][] = new int[cnt + 1][cnt + 1]; // 4개라면 rechk는 5까지 배열을 만들어줌.
		for (int i = 1; i <= cnt; i++) {
			for (int j = 1; j <= cnt; j++) {
				rechk[i][j] = 9;
			}
		}
		//
		// 자 이제 연결을 만들어주자. 그리고 MST이다.
		// 완탐으로 돌리고 일단.
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (Map[i][j] == 0)
					continue;
				int tk = Map[i][j];
				for (int idx = 0; idx < 4; idx++) {
					int nx = i + dx[idx];
					int ny = j + dy[idx];
					if (!boundary(nx, ny))
						continue;
					if (Map[nx][ny] == tk)
						continue;
					int td = 0;
					while (true) {
						if (!boundary(nx, ny))
							break;
						if (Map[nx][ny] != 0 && Map[nx][ny] != tk) {
							if (td >= 2 && rechk[tk][Map[nx][ny]] > td) {
								rechk[tk][Map[nx][ny]] = td;
							}
							break;
						}
						if(Map[nx][ny] == tk) break;
						td += 1;
						nx += dx[idx];
						ny += dy[idx];
					}
				}
			}
		}
		
		
		//// 크루스칼 다시 보자.//////
		for (int i = 1; i <= cnt; i++) {
			for (int j = 1; j <= cnt; j++) {
				if (rechk[i][j] != 9) {
					pq.add(new edge(i, j, rechk[i][j]));
				}
			}
		}
		
//		for (int i = 1; i <= cnt; i++) {
//			for (int j = 1; j <= cnt; j++) {
//				System.out.print(rechk[i][j]+" ");
//			}
//			System.out.println();
//			
//		}
		
		mst = new ArrayList<>();
		if (!pq.isEmpty() && pq.size()/2 >= cnt - 1) {
			kruskal();
		}
		int sum = 0;
		if (mst.size() != cnt - 1) {
			System.out.println(-1);
		} else {
			for (int i = 0; i < mst.size(); i++) {
				sum += mst.get(i).value;
			}
			System.out.println(sum);
		}

		return;
		
	}
}