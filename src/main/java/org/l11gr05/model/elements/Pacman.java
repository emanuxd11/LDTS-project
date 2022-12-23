package org.l11gr05.model.elements;

import java.io.*;

public class Pacman extends Element {
    private char direction;
    private int score;
    private int highScore;

    public Pacman(Position position, char direction, String file) {
        super(position);
        this.direction = direction;
        this.score = 0;
        this.highScore = readHighScore(file);
    }

    private int readHighScore(String filename) {
        FileReader reader;
        BufferedReader bufferedReader;
        try {
            reader = new FileReader(filename);
            bufferedReader = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int newHighScore;
        try {
            newHighScore = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return newHighScore;
    }

    private void writeHighScore(int newHighScore) {
        FileWriter writer;
        BufferedWriter bufferedWriter;

        try {
            writer = new FileWriter("src/main/resources/scores/highscore.txt");
            bufferedWriter = new BufferedWriter(writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            bufferedWriter.write(String.valueOf(newHighScore));
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getHighScore() {
        return this.highScore;
    }

    public char getDirection(){
        return this.direction;
    }

    public void setDirection(char a){
        this.direction = a;
    }

    public int getScore() {
        return this.score;
    }

    public void increaseScore(int increase) {
        this.score += increase;
        if (this.score > this.highScore) {
            this.highScore = this.score;
            writeHighScore(this.highScore);
        }
    }
}
