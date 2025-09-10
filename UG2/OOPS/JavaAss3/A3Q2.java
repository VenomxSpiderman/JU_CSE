import java.util.*;
import java.io.*;

class WordFrequency {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line;
        Map<String, Integer> wordCount = new HashMap<>();
        
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }
        reader.close();
        
        TreeMap<String, Integer> sortedMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int freqCompare = wordCount.get(b).compareTo(wordCount.get(a));
                if (freqCompare != 0) return freqCompare;
                return a.compareTo(b);
            }
        });
        
        sortedMap.putAll(wordCount);
        
        System.out.println("Word frequencies in descending order:");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("\nGreatest frequency: " + sortedMap.firstEntry());
        System.out.println("Least frequency: " + sortedMap.lastEntry());
    }
}