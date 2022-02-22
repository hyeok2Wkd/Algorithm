package P_3860_ÇÒ·ÎÀ©¹¦Áö;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Info {
	// 0 --> ÀÜµð, 1 --> ¹¦ºñ, 2--> ±Í½Å±¸¸Û
	int type;
	// ±Í½Å±¸¸ÛÀÎ °æ¿ì¸¸ ÇØ´ç
	int toX, toY;
	long time;
}

public class Main {

	static int W, H;
	static Info[][] map;
	static long[][] dist;
	static int G, E;
	static int INF = Integer.MAX_VALUE;
	static int []dx = {-1,1,0,0};
	static int []dy = {0,0,-1,1};
	static boolean isCycle = false;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/P_3860_ÇÒ·ÎÀ©¹¦Áö/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			isCycle = false;
			
			// Á¾·á
			if (W == 0 && H == 0) {
				break;
			}

			map = new Info[W][H];
			dist = new long[W][H];

			for (int i = 0; i < W; i++) {
				for(int j = 0;j<H;j++) {
					dist[i][j] = INF;
					map[i][j] = new Info();
				}
			}

			st = new StringTokenizer(br.readLine());

			G = Integer.parseInt(st.nextToken());

			for (int i = 0; i < G; i++) {
				st = new StringTokenizer(br.readLine());
				int x, y;
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				map[x][y].type = 1; // ¹¦ºñ --> 1
			}

			st = new StringTokenizer(br.readLine());
			E = Integer.parseInt(st.nextToken());

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int x1, y1, x2, y2, t;
				x1 = Integer.parseInt(st.nextToken());
				y1 = Integer.parseInt(st.nextToken());
				x2 = Integer.parseInt(st.nextToken());
				y2 = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());

				map[x1][y1].type = 2;
				map[x1][y1].toX = x2;
				map[x1][y1].toY = y2;
				map[x1][y1].time = t;
			}
			
			//º§¸¸Æ÷µå
			dist[0][0] = 0;
			
			//w*h ÃÑ ³ëµå°³¼ö¸¸Å­ µ¹¸®±â
			for(int n = 0;n<W*H;n++) {
				for(int x = 0;x<W;x++) {
					
					for(int y = 0;y<H;y++) {
						
						if(dist[x][y] == INF) continue;
						if(x == W-1 && y == H-1) continue;
						
						//ÀÜµð
						if(map[x][y].type == 0) {
							for(int i = 0;i<4;i++) {
								int nx = x + dx[i];
								int ny = y + dy[i];
								
								if(isTrue(nx,ny) && map[nx][ny].type != 1 && dist[nx][ny] > (dist[x][y] + 1)) {
									if(n == W*H-1) {
										isCycle = true;
										break;
									}
									dist[nx][ny] = dist[x][y] + 1;
								}
								
							}
						}
						//¹¦ºñ
						else if(map[x][y].type == 1) {
							continue;
						}
						//±Í½Å±¸¸Û
						else if(map[x][y].type == 2) {
							int nx = map[x][y].toX;
							int ny = map[x][y].toY;
							
							if(dist[nx][ny] > dist[x][y] + map[x][y].time) {
								if(n == W*H-1) {
									isCycle = true;
									break;
								}
								dist[nx][ny] = dist[x][y] + map[x][y].time;
							}
							
						}
					}
				}
			}
			if(isCycle) {
				sb.append("Never\n");
			}
			else {
				if(dist[W-1][H-1] == INF) {
					sb.append("Impossible\n");
				}
				else {
					sb.append(dist[W-1][H-1] + "\n");
				}
			}
		}
		System.out.println(sb);
	}
	
	static boolean isTrue(int x, int y) {
		if(x > -1 && x < W && y > -1 && y< H) return true;
		return false;
	}

}
