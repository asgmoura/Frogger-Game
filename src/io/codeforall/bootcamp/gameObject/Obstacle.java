package io.codeforall.bootcamp.gameObject;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle {

    /**
     * Variable Declaration
     */
    //Obstacle speed
    private int speed;

    //Obstacle Picture
    private Picture obstaclePicture;

    //Move left boolean
    private boolean moveLeft;

    //Background picture
    private Picture background;

    /**
     * Constructor
     */
    //Obstacle constructor
    public Obstacle(int x, int y, boolean moveLeft, Picture background) {
        this.obstaclePicture = new Picture(x,y,"resources/images/log.png");
        obstaclePicture.draw();
        this.speed = 5;
        this.moveLeft = moveLeft;
        this.background = background;
    }

    /**
     * Getters and Setters
     */

    public int getX() {
        return obstaclePicture.getX();
    }

    public int getY() {
        return obstaclePicture.getY();
    }

    public int getWidth() {
        return obstaclePicture.getWidth();
    }

    public int getHeight() {
        return obstaclePicture.getHeight();
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Methods
     */

    //Obstacle moves sideways
    public void moveSideways() {

        if(moveLeft) {
            this.obstaclePicture.translate(-speed,0);
        } else {
            this.obstaclePicture.translate(speed,0);
        }

        if(obstaclePicture.getX() <= 0 || obstaclePicture.getX() + obstaclePicture.getWidth() >= background.getWidth()) {
            moveLeft = !moveLeft;
        }
    }

    //Obstacle draw
    public void draw() {
        obstaclePicture.draw();
    }


}
