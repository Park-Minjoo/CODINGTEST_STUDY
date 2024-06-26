import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    private final static char Q = 'q';
    private final static char U = 'u';
    private final static char A = 'a';
    private final static char C = 'c';
    private final static char K = 'k';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] quack = new int[5];

        char[] charArray = br.readLine().toCharArray();
        int maxDuck = 0;
        int countDuck = 0;


        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];

            if (ch == Q) {
                quack[0]++;
                countDuck++;
            } else if (ch == U) {
                quack[1]++;
                if (quack[0] < quack[1]) {
                    maxDuck = -1;
                    break;
                }
            } else if (ch == A) {
                quack[2]++;
                if (quack[1] < quack[2]) {
                    maxDuck = -1;
                    break;
                }
            } else if (ch == C) {
                quack[3]++;
                if (quack[2] < quack[3]) {
                    maxDuck = -1;
                    break;
                }
            } else if (ch == K) {
                quack[4]++;
                if (quack[3] < quack[4]) {
                    maxDuck = -1;
                    break;
                }
                maxDuck = Math.max(maxDuck, countDuck);
                countDuck--;

            }
        }

        if (quack[0] != quack[4])
            System.out.println(-1);
        else
            System.out.println(maxDuck);
            
    }


}


/*
quqacukqauackck
2개
 */