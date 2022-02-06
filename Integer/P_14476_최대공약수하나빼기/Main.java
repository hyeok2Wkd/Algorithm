package P_14476_�ִ������ϳ�����;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int []nums;
	static int [] lToR;
	static int [] rToL;
	static int maxGcd = -1; //���� ū �ִ�����
	static int maxK = 0; //K
	
	public static void main(String []args) throws Exception{
		
		System.setIn(new FileInputStream("������/P_14476_�ִ������ϳ�����/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int n = 0;n<N;n++) {
			nums[n] = Integer.parseInt(st.nextToken());
		}
		
		lToR = new int[N];
		rToL = new int[N];
		
		lToR[0] = nums[0];
		
		
		for(int i = 1;i<N;i++) {
			int gcdResult = gcd(lToR[i-1], nums[i]);
			lToR[i] = gcdResult;
		}
		
		rToL[N-1] = nums[N-1];
		for(int i = N-2;i>=0;i--) {
			int gcdResult = gcd(nums[i], rToL[i+1]);
			rToL[i] = gcdResult;
		}
		
		
		//�ϳ�����
		for(int k = 0;k<N;k++) {
			
			//�Ǿ�
			if(k == 0) {
				int a = rToL[1];
				if(nums[k] % a != 0) {
					if(a > maxGcd) {
						maxGcd = a;
						maxK = nums[k];
					}
				}
			}
			//�ǵ�
			else if(k == N-1) {
				int a = lToR[N-2];
				if(nums[k] % a != 0) {
					if(a > maxGcd) {
						maxGcd = a;
						maxK = nums[k];
					}
				}
			}
			//������
			else {
				int a = lToR[k-1];
				int b = rToL[k+1];
				int gcdResult = gcd(a,b);
				if(nums[k] % gcdResult != 0) {
					if(gcdResult > maxGcd) {
						maxGcd = gcdResult;
						maxK = nums[k];
					}
				}
				
			}
			
			
			
		}
		
		if(maxGcd == -1) {
			System.out.println(-1);
		}
		else {
			System.out.println(maxGcd + " "+maxK );
		}
		
		
	}
	
	static int gcd(int a, int b) {
		
		while(b!=0) {
			
			int r = a%b;
			a = b;
			b = r;			
			
		}
		
		return a;
		
	}
}
