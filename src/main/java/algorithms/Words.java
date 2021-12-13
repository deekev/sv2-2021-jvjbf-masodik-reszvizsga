package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {
        if (word.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        }
        if (!word.equals(word.toLowerCase())) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        for (int i = 0; i < words.size(); i++) {
            if (words.subList(i + 1, words.size()).contains(words.get(i))) {
                return true;
            }
        }
        return false;
    }
}