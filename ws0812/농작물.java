import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution{
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int dx[] = { 0, -1, 0, 1 };
    static int dy[] = { -1, 0, 1, 0 };
    static int Map[][];
    static int sum = 0;
 
    static boolean boundary(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }
        return true;
    }
 
    static boolean visited[][];
    static Queue<Produce> q = new LinkedList<>();
 
    static void bfs(int x, int y) {
        while (!q.isEmpty()) {
            int r = q.peek().x;
            int c = q.peek().y;
            int cnt = q.peek().cnt;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];
                if (boundary(nx, ny) == false)
                    continue;
                if (visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    sum += Map[nx][ny];
                    if (cnt == 2) {
                        continue;
                    } else {
                        q.add(new Produce(nx, ny, cnt - 1));
                    }
                }
            }
 
        }
    }
 
    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int test = 1; test <= T; test++) {
            N = sc.nextInt();
            Map = new int[N][N];
            visited = new boolean[N][N];
 
            for (int i = 0; i < N; i++) {
                String ss = sc.next();
                for (int j = 0; j < N; j++) {
                    Map[i][j] = ss.charAt(j) - '0';
                }
            }
            int cnt = (N + 1) / 2;
            sum = Map[N / 2][N / 2];
            visited[N / 2][N / 2] = true;
            if (cnt != 0) {
                q.add(new Produce(N / 2, N / 2, cnt));
            }
            bfs(N / 2, N / 2);
            System.out.println("#" + test+ " "+sum);
        }
    }
}
 
class Produce {
    int x;
    int y;
    int cnt;
 
    public Produce(int x, int y, int cnt) {
         
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}