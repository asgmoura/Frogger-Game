package io.codeforall.bootcamp;

import io.codeforall.bootcamp.gameObject.Frog;
import io.codeforall.bootcamp.gameObject.Obstacle;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameController {

    private Obstacle[] obstacles;

    private Frog frog;

    private Picture background;

    private Rectangle higherBoundary;

    private Rectangle sideBoundary;

    private boolean endGame;

    private static Picture menu;

    private int lives;

    private int level;

    private static int levelMax = 1;

    private static boolean OnMenu = true;

    private Sound menuSound;

    private Sound gameSound;

    private Sound crashSound;

    private Sound gameOverSound;

    private Sound winSound;

    private Picture gameOverPicture;

    private Picture winGamePicture;



    public GameController() {

        this.background = new Picture(10, 10, "resources/images/Map.jpg");

        this.higherBoundary = new Rectangle(10, 900, background.getWidth(), 0);

        this.sideBoundary = new Rectangle(10, 900, background.getHeight(), 0);

        this.lives = 3;

        this.levelMax = levelMax;

        background.draw();

        this.obstacles = new Obstacle[4];

        obstacles[0] = new Obstacle(100, 120, true, background);
        obstacles[1] = new Obstacle(300, 220, false, background);
        obstacles[2] = new Obstacle(250, 360, true, background);
        obstacles[3] = new Obstacle(150, 520, false, background);
    }


    public void runMainMenu() {

        createFrog();

        menu = new Picture(10, 10, "resources/images/Menu.jpg");
        menuSound = new Sound("/resources/sounds/menuSound.wav");
        menu.draw();
        this.menuSound.play(true);
        this.menuSound.setLoop(-1);


        while (OnMenu) {
            System.out.println("");

        }
    }

    public void hideMainMenu() {
        menu.delete();
        OnMenu = false;
    }

    public void gameInit() throws InterruptedException {

        this.menuSound.stop();
        gameSound = new Sound("/resources/sounds/gameSound.wav");
        this.gameSound.play(true);
        this.gameSound.setLoop(-1);

        for (Obstacle obstacle : obstacles) {
            obstacle.draw();
        }

        runGame();

    }

    public void runGame() {

        while (!endGame) {
            moveObstacles();
            if(frogReachesTop()){
                break;
            }
            checkCollision();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("GameOver");

    }

    public void moveObstacles() {
        for (Obstacle obstacle : obstacles) {
            obstacle.moveSideways();
        }
    }

    public boolean frogReachesTop() {
        if (frog.getY() == 0) {
            if (level >= levelMax) {
                endGame = true;
                System.out.println("");
                winGame();
                return true;
            } else {
                level++;
                for (Obstacle obstacle : obstacles) {
                    obstacle.setSpeed(12);
                }
                frog.delete();
                createFrog();
                return false;
            }
        }
        return false;
    }

    public void checkCollision() {

        for (Obstacle obstacle : obstacles) {
            if (isCollision(frog, obstacle)) {
                frog.delete();

                if (lives == 0) {
                    endGame = true;
                    frog.delete();
                    gameOver();
                } else {
                    crashSound = new Sound("/resources/sounds/crashSound.wav");
                    this.crashSound.play(true);

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    createFrog();
                }
                break;
            }
        }

    }

    public void winGame() {
        winGamePicture = new Picture(10, 10, "resources/images/winGame.jpg");
        winGamePicture.draw();
        frog.delete();
        gameSound.stop();

        winSound = new Sound("/resources/sounds/winGameSound.wav");
        this.winSound.play(true);
    }


    public void gameOver() {
        frog.delete();
        
        gameOverPicture = new Picture(10, 10, "resources/images/gameOver.jpg");
        gameOverPicture.draw();

        this.gameSound.stop();
        gameOverSound = new Sound("/resources/sounds/GO.wav");
        this.gameOverSound.play(true);

    }


    public boolean isCollision(Frog frog, Obstacle obstacle) {
        int frogX = frog.getX();
        int frogY = frog.getY();
        int frogWidth = frog.getWidth();
        int frogHeight = frog.getHeight();

        int obstacleX = obstacle.getX();
        int obstacleY = obstacle.getY();
        int obstacleWidth = obstacle.getWidth();
        int obstacleHeight = obstacle.getHeight();

        return frogX < obstacleX + obstacleWidth &&
                frogX + frogWidth > obstacleX &&
                frogY < obstacleY + obstacleHeight &&
                frogY + frogHeight > obstacleY;
    }

    public void createFrog() {
        this.frog = new Frog(450, 700, background);
        Controls handler = new Controls(frog, this);
        lives--;
    }
}







