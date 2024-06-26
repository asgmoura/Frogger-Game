package io.codeforall.bootcamp;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        GameController gameController = new GameController();

        gameController.runMainMenu();

        gameController.gameInit();

    }
}