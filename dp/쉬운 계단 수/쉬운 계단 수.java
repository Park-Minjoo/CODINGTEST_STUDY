import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader ( System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		long[][] dp =  new long[n+1][11];		//dp[n][1] n번째 줄에 1이 올수 있는 경우의 수
		
		for(int i = 1 ; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		// dp[i][j] =  dp[i-1][j-1] + dp[i-1][j+1];
		
		for(int i = 2; i < n+1; i++) {
			
			dp[i][0] = dp[i-1][1]%1000000000;			//0일때 처리
			
			for(int j = 1; j < 9 ; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]; 
				dp[i][j] = dp[i][j]%1000000000;
			}
			
			dp[i][9] = dp[i-1][8]%1000000000;		//9일때 처리
			
		}

		
		long sum = 0;
		
		for(int i = 0; i < 10; i++) {
			sum += dp[n][i];
		}
		
		System.out.println(sum%1000000000);
		
		

	}
}
