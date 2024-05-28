import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    /**
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            st = new StringTokenizer(s, ".");
            st.nextToken();
            String now = st.nextToken();

            if (!map.containsKey(now)) {
                map.put(now, 1);
                list.add(now);
            } else {
                Integer integer = map.get(now);
                map.replace(now, integer + 1);
            }

        }

        list.sort(Comparator.naturalOrder());
        int size = map.size();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            String ext = list.get(i);
            sb.append(ext + " " + map.get(ext) + "\n");
        }

        System.out.println(sb.toString());
    }

    public static class ext {
        String name;
        int count;

    }

}







/*
8
sbrus.txt
spc.spc
acm.icpc
korea.icpc
sample.txt
hello.world
sogang.spc
example.txt

*/

