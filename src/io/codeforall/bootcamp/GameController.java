package io.codeforall.bootcamp;

import io.codeforall.bootcamp.controls.Controls;
import io.codeforall.bootcamp.controls.Sound;
import io.codeforall.bootcamp.gameObject.Frog;
import io.codeforall.bootcamp.gameObject.Obstacle;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameController {

    /**
     * Variable Declaration
     */

    //Background Image
    private Picture background;

    //Frog
    private Frog frog;

    //Obstacles array
    private Obstacle[] obstacles;

    //Game over boolean
    private boolean endGame;

    //Menu Image
    private static Picture menu;

    //Frog lives
    private int lives;

    //Level
    private int level;

    //Max Level
    private static int levelMax = 1;

    //On Menu Boolean
    private static boolean OnMenu = true;

    //Menu Sound
    private Sound menuSound;

    //Game Sound
    private Sound gameSound;

    //Crash Sound
    private Sound crashSound;

    //Game Over Sound
    private Sound gameOverSound;

    //Win Sound
    private Sound winSound;

    //Game Over Picture
    private Picture gameOverPicture;

    //Win Game Picture
    private Picture winGamePicture;

    /**
     * Constructors
     */

    //Game Controller Constructor
    public GameController() {

        //Assign a Background Image
        this.background = new Picture(10, 10, "resources/images/Map.jpg");

        //Initialize lives
        this.lives = 3;

        this.levelMax = levelMax;

        background.draw();

        //Set obstacles array length
        this.obstacles = new Obstacle[4];

        obstacles[0] = new Obstacle(100, 120, true, background);
        obstacles[1] = new Obstacle(300, 220, false, background);
        obstacles[2] = new Obstacle(250, 360, true, background);
        obstacles[3] = new Obstacle(150, 520, false, background);
    }

    /**
     * Methods
     */

    //Run Main Menu
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

    //Hide Main Menu
    public void hideMainMenu() {
        menu.delete();
        OnMenu = false;
    }

    //Game Initializer
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

    //Run Game
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

    //Move Obstacles
    public void moveObstacles() {
        for (Obstacle obstacle : obstacles) {
            obstacle.moveSideways();
        }
    }

    //Check if Frog reaches top
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

    //Check Collisions
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

    //Win Game
    public void winGame() {
        winGamePicture = new Picture(10, 10, "resources/images/winGame.jpg");
        winGamePicture.draw();
        frog.delete();
        gameSound.stop();

        winSound = new Sound("/resources/sounds/winGameSound.wav");
        this.winSound.play(true);
    }

    //Game Over
    public void gameOver() {
        frog.delete();
        
        gameOverPicture = new Picture(10, 10, "resources/images/gameOver.jpg");
        gameOverPicture.draw();

        this.gameSound.stop();
        gameOverSound = new Sound("/resources/sounds/GO.wav");
        this.gameOverSound.play(true);

    }

    //Check collisions between Frog and obstacles
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

    //Create Frog
    public void createFrog() {
        this.frog = new Frog(450, 700, background);
        Controls handler = new Controls(frog, this);
        lives--;
    }
}







