import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 보석도둑 1202번
public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static class Jewel implements Comparable<Jewel> {
        int weight;
        int price;

        @Override
        public int compareTo(Jewel other) {
            // 무게가 같으면 가격도 비교
            if(this.weight == other.weight)
                return other.price - this.price;
            return this.weight - other.weight;
        }

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    /**
     *   *** 가방에 들어갈수 있는 보석중 가장 가치가 높은 보석을 뽑으면 된다 ***
     *
     *   que -> 가방에 들어갈수 있는 크기의 보석 후보들
     *
     *  가방과 보석을 무게순으로 정렬하고
     *  우선순위 큐를 사용해서
     *  무게가 충족되는 보석들을 가격 우선순위로 큐에 넣음
     *
     *  큐에서 하나 꺼내서 total에 더함 (우선순위 큐이므로 가치가 가장 높은 보석이 나옴)
     *
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 보석
        int k = Integer.parseInt(st.nextToken()); // 가방

        ArrayList<Integer> bagList = new ArrayList<>();
        ArrayList<Jewel> jewelList = new ArrayList<>();

        // 보석 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewelList.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 가방 입력
        for (int i = 0; i < k; i++) {
            bagList.add(Integer.parseInt(br.readLine()));
        }

        bagList.sort(Comparator.naturalOrder());
        jewelList.sort(Comparator.naturalOrder());

        long total = 0;
        int idx = 0;    // 한번 큐에 들어간 보석은 다시 검색할 필요가 없다
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 가격이 높은게 우선순위 (내림차순)

        // 가방을 순서대로 탐색
        for (int i = 0; i < k; i++) {
            while (idx < n) {
                // 가방이 더 작으면 넘어가
                if (bagList.get(i) < jewelList.get(idx).weight) {
                    break;
                }
                // 가격을 우선순위로 넣어라
                pq.add(jewelList.get(idx).price);
                idx++;
            }
            if(!pq.isEmpty())
                total = total + pq.poll();
        }

        System.out.println(total);
    }

}