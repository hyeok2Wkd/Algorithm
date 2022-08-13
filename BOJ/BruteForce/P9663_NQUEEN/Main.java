package P9663_NQUEEN;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int [][] visited;
	static int [] dx = {1,1,1};
	static int [] dy = {-1,0,1};
	static int answer;
	static List<int[]> list = new ArrayList();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		
		visited = new int[N][N];
		
		for(int y = 0;y<N;y++) {
			DFS(0,y);
			isOpen(0, y);
		}
		
		System.out.println(answer);
		
	}
	
	static void DFS(int x, int y) {
		
		//1.체크인
		isClosed(x, y);
		//2.목적지니
		if(x == N-1) {
			answer++;
			return;
		}
		//3.순회
		for(int j = 0;j<N;j++) {
			
			//4.갈수있니
			if(visited[x+1][j] == 0) {
				//5.간다
				DFS(x+1,j);
				//6.체크아웃
				isOpen(x+1, j);
			}
			
		}
		
	}
	
	static void isClosed(int x, int y) {
		
		visited[x][y]++;
		
		for(int i = 0;i<3;i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			while(nx > -1 && nx < N && ny > -1 && ny < N) {
				
				visited[nx][ny]++;
				
				nx = nx + dx[i];
				ny = ny + dy[i];
			}
			
		}
	}
	
	static void isOpen(int x, int y) {
		visited[x][y]--;
		
		for(int i = 0;i<3;i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			while(nx > -1 && nx < N && ny > -1 && ny < N) {
				
				visited[nx][ny]--;
				
				nx = nx + dx[i];
				ny = ny + dy[i];
			}
			
		}
	}

}
