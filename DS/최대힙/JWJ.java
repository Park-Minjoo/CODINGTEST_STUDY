import java.util.*;

public class 최대힙{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);

        int x;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            x = sc.nextInt();

            if(x==0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }

            } else{
                pq.offer(x);
            }

        }
        System.out.print(sb);


    }


}