import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 문제명 파일 정리
 * 메모리: 140728 KB
 * 시간: 1568 ms
 *
 * https://www.acmicpc.net/problem/20291
 */

public class Ksy {

    public static final String EXTENSION_DELIMITER = "\\.";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            List<String> fileNames = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                fileNames.add(reader.readLine());
            }

            System.out.println(solution(fileNames));
        }
    }

    private static String solution(List<String> fileNames) {
        SortedMap<String, Integer> extensionCount = countExtension(fileNames);
        StringBuilder result = new StringBuilder();

        for (Entry<String, Integer> entry : extensionCount.entrySet()) {
            result.append(String.format("%s %d%s", entry.getKey(), entry.getValue(), "\n"));
        }

        return result.toString();
    }

    private static SortedMap<String, Integer> countExtension(List<String> fileNames) {
        SortedMap<String, Integer> extensionCount = new TreeMap<>();

        for (String fileName : fileNames) {
            String extension = fileName.split(EXTENSION_DELIMITER)[1];
            extensionCount.put(extension, extensionCount.getOrDefault(extension, 0) + 1);
        }

        return extensionCount;
    }
}
