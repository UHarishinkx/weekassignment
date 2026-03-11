import java.util.*;

class PlagiarismDetector {

    HashMap<String, Set<String>> index = new HashMap<>();

    void indexDocument(String docId, String text) {

        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 2; i++) {

            String gram = words[i] + " " + words[i+1] + " " + words[i+2];

            index.putIfAbsent(gram, new HashSet<>());
            index.get(gram).add(docId);
        }
    }

    int checkSimilarity(String text) {

        String[] words = text.split(" ");
        int matches = 0;

        for (int i = 0; i < words.length - 2; i++) {

            String gram = words[i] + " " + words[i+1] + " " + words[i+2];

            if (index.containsKey(gram))
                matches++;
        }

        return matches;
    }

    public static void main(String[] args) {

        PlagiarismDetector p = new PlagiarismDetector();

        p.indexDocument("doc1", "this is a sample plagiarism test");

        System.out.println("Matching n-grams: " +
                p.checkSimilarity("this is a sample test"));
    }
}