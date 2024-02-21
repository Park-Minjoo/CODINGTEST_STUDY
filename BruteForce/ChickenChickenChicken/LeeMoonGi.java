
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 치킨치킨치킨 16439번
public class ChickenChickenChicken {


    public static void main(String[] args) throws IOException {
        mySolution();
    }


    /**
     *  순열로 전부 확인 후
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int member = Integer.parseInt(st.nextToken()); // 회원수
        int chicken = Integer.parseInt(st.nextToken()); // 치킨 종류

        for (int i = 0; i < member; i++) {
            st.nextToken();
        }



    }




    public static void answer() throws IOException {
    }
}