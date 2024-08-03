import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Yeonkkk {

    private static String solution(int n, String[] files) {
        Map<String, Integer> extensionCounter = new HashMap<>();

        for (String file : files) {
            String extension = file.split("\\.")[1];
            extensionCounter.put(extension, extensionCounter.getOrDefault(extension, 0) + 1);
        }

        return extensionCounter.keySet().stream()
                .sorted()
                .map(key -> key + " " + extensionCounter.get(key))
                .collect(Collectors.joining("\n"));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            int n = Integer.parseInt(reader.readLine());
            String[] files = new String[n];

            for (int i = 0; i < n; i++) {
                files[i] = reader.readLine().strip();
            }

            System.out.println(solution(n, files));
        }
    }
}
