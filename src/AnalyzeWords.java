import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class AnalyzeWords {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lemon", "mango", "nectarine");
        Future<Double> averageWordLength = service.submit(new AverageWordLength(words));
        Future<String> longestWord = service.submit(new LongestWord(words));
        Future<Character> mostFrequentLetter = service.submit(new FrequentLetter(words));

        try {
            System.out.println("Average word length: " + averageWordLength.get());
            System.out.println("Longest word: " + longestWord.get());
            System.out.println("Most frequent letter: " + mostFrequentLetter.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}

class AverageWordLength implements Callable<Double> {
    private List<String> words;

    public AverageWordLength(List<String> words) {
        this.words = words;
    }

    @Override
    public Double call() {
        double totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }
        return totalLength / words.size();
    }
}

class LongestWord implements Callable<String> {
    private List<String> words;

    public LongestWord(List<String> words) {
        this.words = words;
    }

    @Override
    public String call() {
        String greatestWord = "";
        for (String word : words) {
            if (word.length() > greatestWord.length()) {
                greatestWord = word;
            }
        }
        return greatestWord;
    }
}

class FrequentLetter implements Callable<Character> {
    private List<String> words;

    public FrequentLetter(List<String> words) {
        this.words = words;
    }

    @Override
    public Character call() {
        int[] letterCounts = new int[26];
        for (String str : words) {
            for (char c : str.toCharArray()) {
                if (Character.isLetter(c)) {
                    letterCounts[Character.toLowerCase(c) - 'a']++;
                }
            }
        }
        char mostFrequent = '\0';
        int highestCount = 0;
        for (int i = 0; i < letterCounts.length; i++) {
            if (letterCounts[i] > highestCount) {
                mostFrequent = (char) (i + 'a');
                highestCount = letterCounts[i];
            }
        }
        return mostFrequent;
    }
}
