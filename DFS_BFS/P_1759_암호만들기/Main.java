package P_1759_��ȣ�����;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int L,C;
	static char [] alpha;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("�˰������/P_1759_��ȣ�����/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<C;i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha);
		
		for(int i = 0;i<C;i++) {
			if(alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u') {
				String str = "";
				str += alpha[i];
				DFS(i,1,0,1,str);
			}
			else {
				String str = "";
				str += alpha[i];
				DFS(i,1,1,0,str);
			}
		}
	}
	
	static void DFS(int now, int cnt, int jaum, int moum, String result) {
		
		//1. üũ��
		//2. ��������?
		if(cnt == L) {
			if(jaum >= 2 && moum >= 1) {
				System.out.println(result);
			}
			return;
		}
		//3. ��ȸ
		for(int i = now+1;i<C;i++) {
			//4. �����ִ�?
			if(alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u') {
				//5. ����
				DFS(i, cnt+1, jaum, moum+1, result+alpha[i]);
			}
			else {
				//5. ����
				DFS(i, cnt+1, jaum+1, moum, result+alpha[i]);
			}
		}
		
		
		//6. üũ�ƿ�
		
		
		
	}
}
