package week3;
public class Game {
    private int maximumGuesses;
    private int numberToGuess;
    private int currentGuesses;
    public void setNumberToGuess(int numberToGuess, int maximumGuesses) {
        if (numberToGuess < 0 || numberToGuess > 100) {
            throw new IllegalArgumentException("Number must be between 0 and 100");
        }
        if (maximumGuesses < 1 || maximumGuesses > 10) {
            throw new IllegalArgumentException("Maximum guess must be between 0 and 10");
        }
        this.maximumGuesses = maximumGuesses;
        this.numberToGuess = numberToGuess;
        this.currentGuesses = 0;
    }

    public String guess(int numberGuessed) {
        if (numberGuessed < 0 || numberGuessed > 100) {
            throw new IllegalArgumentException("Number must be between 0 and 100");
        }
        currentGuesses++;

        if (currentGuesses > maximumGuesses) {
            return "LOST";
        }

        if (numberGuessed == numberToGuess) {
            return "CORRECT";
        } else if (numberGuessed > numberToGuess) {
            return "LOWER";
        } else {
            return "HIGHER";
        }
    }

}
