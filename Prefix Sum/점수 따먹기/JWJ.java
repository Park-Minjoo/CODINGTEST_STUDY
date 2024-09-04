package org.woojin.etc;

import java.util.*;

public class 점수따먹기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        long[][] S = new long[n+1][m+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(sc.nextLine());
            for(int j=1; j<=m; j++){
                int now = Integer.valueOf(st.nextToken());
                S[i][j] = now + S[i-1][j] + S[i][j-1] - S[i-1][j-1];
            }
        }

        long max = Long.MIN_VALUE, sum;

        for(int p=1; p<=n; p++){
            for(int q=1; q<=m; q++){
                for(int i=p; i<=n; i++){
                    for(int j=q; j<=m; j++){
                        //왜 여기서 p-1, q-1이지...?
                        sum = S[i][j] - S[i][q-1] - S[p-1][j] + S[p-1][q-1];

                        if(sum > max){
                            max = sum;
                        }
                    }

                }

            }
        }

        System.out.println(max);

    }
}
