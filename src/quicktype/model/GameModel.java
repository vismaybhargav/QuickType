package quicktype.model;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Random;

public class GameModel {
    private final String[] WORDS = {
            "cat", "dog", "bat", "cow", "fox", "owl", "bee", "ant", "pig", "hen",
            "apple", "grape", "lemon", "mango", "peach", "berry", "melon", "plum",
            "banana", "orange", "tomato", "carrot", "celery", "pepper", "radish",
            "house", "table", "chair", "sofa", "bench", "stool", "shelf", "lamp",
            "happy", "sad", "angry", "bored", "tired", "sleepy", "excited", "proud",
            "quick", "slow", "large", "small", "tall", "short", "heavy", "light",
            "water", "earth", "storm", "ocean", "river", "beach", "mountain", "valley",
            "sunny", "cloudy", "rainy", "stormy", "windy", "foggy", "snowy", "clear"
    };
    private final Random RANDOM = new Random();
    private int focusedWordIndex = 0;
    private final Label[] gameWords;

    public GameModel(int numWords) {
        gameWords = new Label[numWords];
        generateWords();

        gameWords[0].setBackground(Background.fill(Color.RED)); // Highlight the first word because it is focused.
    }

    private void generateWords() {
        for(int i = 0; i < gameWords.length; i++) {
            String word = getRandomWord();

            // Make sure that there aren't any duplicates in the list of words
            while(i > 0 && gameWords[i - 1].getText().equals(word)) {
                word = getRandomWord();
            }

            gameWords[i] = new Label(word);
            setLabelConfigs(gameWords[i]);
        }
    }

    public void moveToNextWord() {
        // Clamp the index of the (focused word + 1) to valid range of list
        focusedWordIndex = Math.clamp(++focusedWordIndex, 0, gameWords.length - 1);

        // Focus the next word in the list and set all others to be unfocused
        for(int i = 0; i < gameWords.length; i++) {
            gameWords[i].setBackground(Background.fill(i == focusedWordIndex ? Color.RED : Color.TRANSPARENT));
        }
    }

    private void setLabelConfigs(Label label) {
        label.setFont(Font.font(50));
    }

    private String getRandomWord() {
        return WORDS[RANDOM.nextInt(0, WORDS.length)];
    }
}
