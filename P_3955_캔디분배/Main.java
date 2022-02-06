package P_3955_캔디분배;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class EGResult {
	long s;
	long t;
	long r;

	public EGResult(long s, long t, long r) {
		super();
		this.s = s;
		this.t = t;
		this.r = r;
	}
}

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("정수론/P_3955_캔디분배/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		for (int n = 0; n < N; n++) {

			st = new StringTokenizer(br.readLine());

			long a, b;
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());

			// 1. gcd(a, b) != 1 --> 해 X
			if (gcd(a, b) != 1) {

				System.out.println("IMPOSSIBLE");
			}
			// 2. gcd(a, b) == 1
			else {

				EGResult eg = ExtendGcd(a, b);
				long x0 = eg.s;
				long y0 = eg.t;
				long r0 = eg.r;
				

				// x = x0 + bk
				// y = y0 - ak

				// k < -x0/b
				// (y0-1e9) / a <= k < y0/a
				
				long kFromX = (long)Math.ceil((double)-x0 / b)-1;
				long kFromY = (long)Math.ceil((double)y0 / a)-1;
				long kLimt = (long)Math.ceil((double)(y0-1e9) / a);
				long k = Math.min(kFromX, kFromY);
				if(kLimt <= k) {
					System.out.println(y0 - a*k);
				}
				else {
					System.out.println("IMPOSSIBLE");
				}
				
			
				 
			}

		}

	}

	static long gcd(long a, long b) {

		while (b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}

		return a;
	}

	static EGResult ExtendGcd(long a, long b) {
		long s0 = 1, t0 = 0, r0 = a;
		long s1 = 0, t1 = 1, r1 = b;

		long temp;
		while (r1 != 0) {
			long q = r0 / r1;

			temp = r0 - q * r1;
			r0 = r1;
			r1 = temp;

			temp = s0 - q * s1;
			s0 = s1;
			s1 = temp;

			temp = t0 - q * t1;
			t0 = t1;
			t1 = temp;
		}
		return new EGResult(s0, t0, r0);

	}
}
