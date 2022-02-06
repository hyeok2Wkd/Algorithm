package P_3055_탈출;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Info{
	
	int x,y;
	char ch;
	
	public Info(int x, int y, char ch) {
		super();
		this.x = x;
		this.y = y;
		this.ch = ch;
	}
}

public class Main{
	
	static int r,c;
	static char [][] map;
	static int []dx = {-1,1,0,0};
	static int []dy = {0,0,-1,1};
	static int [][] dist;
	static boolean isRight = false;
	
	public static void main(String[]args) throws Exception{
		System.setIn(new FileInputStream("src/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		dist = new int[r][c];
		
		Info temp = null;
		
		Queue<Info> q = new LinkedList<>();
		
		for(int i = 0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0;j<c;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '*') {
					q.add(new Info(i,j,'*'));
				}
				
				else if(map[i][j] == 'S') {
					temp = new Info(i,j,'S');
				}
			}
		}
		
		q.add(temp);
		
		
		while(!q.isEmpty()) {
			
			//1. 큐에서 꺼내기
			Info info = q.remove();
			//2. 목적지니?
			if(map[info.x][info.y] == 'D') {
				isRight = true;
				System.out.println(dist[info.x][info.y]);
				break;
			}
			//3. 순회
			for(int i = 0;i<4;i++) {
				int nx = info.x + dx[i];
				int ny = info.y + dy[i];
				
				if(info.ch == '*') {
					//4. 갈수있니?
					if(isTrue(nx,ny) && (map[nx][ny] == '.' || map[nx][ny] == 'S')) {
						//5. 체크인
						map[nx][ny] = '*';
						//6. 큐에넣기
						q.add(new Info(nx,ny,'*'));
					}
				}
				else if(info.ch == 'S') {
					//4. 갈수있니?
					if(isTrue(nx,ny) && dist[nx][ny] == 0 &&(map[nx][ny] == '.' || map[nx][ny] == 'D')) {
						//5. 체크인
						dist[nx][ny] = dist[info.x][info.y] + 1;
						//6. 큐에넣기
						q.add(new Info(nx,ny, 'S'));
					}
					
				}
				
				
				
			}
			
		}
		

		
		
		if(!isRight) { 
			System.out.println("KAKTUS");
		}
		
		
		
	}
	
	static boolean isTrue(int x, int y) {
		if(x > -1 && x < r && y > -1 && y < c) return true;
		else return false;
	}
	
	
}
