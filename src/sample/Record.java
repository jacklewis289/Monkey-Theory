package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Record {

    private SimpleIntegerProperty testNumber;
    private SimpleIntegerProperty attempts;
    private SimpleStringProperty word;

    public Record(String word, int testNumber, int attempts) {
        if (word.equals("1")) {
            this.word = new SimpleStringProperty("Heads");
        }
        else if (word.equals("2")) {
            this.word = new SimpleStringProperty("Tails");
        }
        else {
            this.word = new SimpleStringProperty(word);
        }
        this.testNumber = new SimpleIntegerProperty(testNumber);
        this.attempts = new SimpleIntegerProperty(attempts);
    }

    public int getTestNumber() {
        return testNumber.get();
    }

    public void setTestNumber(int testNumber) {
        this.testNumber = new SimpleIntegerProperty(testNumber);
    }

    public int getAttempts() {
        return attempts.get();
    }

    public void setAttempts(int attempts) {
        this.attempts = new SimpleIntegerProperty(attempts);
    }

    public String getWord() {
        return this.word.get();
    }

    public void setWord(int word) {
        this.attempts = new SimpleIntegerProperty(word);
    }
}
