package io.codeforall.bootcamp.gameObject;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle {

    private int speed;

    private Picture obstaclePicture;

    private boolean moveLeft;

    private Picture background;



    public Obstacle(int x, int y, boolean moveLeft, Picture background) {
        this.obstaclePicture = new Picture(x,y,"resources/images/log.png");
        obstaclePicture.draw();
        this.speed = 5;
        this.moveLeft = moveLeft;
        this.background = background;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

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

    public void draw() {
        obstaclePicture.draw();
    }


}
