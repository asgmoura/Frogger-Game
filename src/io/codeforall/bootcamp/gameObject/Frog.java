package io.codeforall.bootcamp.gameObject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Frog {

    private Picture frogImage;

    private Picture background;


    public Frog(int x, int y, Picture background) {
        this.frogImage = new Picture((double) x / 2, y, "resources/images/frog.png");
        frogImage.draw();
        this.background = background;
    }

    public void moveRight() {
        if (frogImage.getX() + frogImage.getWidth() + 10 <= background.getWidth()) {
            frogImage.translate(10, 0);
        }
    }

    public void moveLeft() {
        if (frogImage.getX() - 10 >= 0) {
            frogImage.translate(-10, 0);
        }
    }

    public void moveUp() {
        if (frogImage.getY() - 10 >= 0) {
            frogImage.translate(0, -10);
        }
    }

    public void moveDown() {
        if (frogImage.getY() + frogImage.getHeight() + 10 <= background.getHeight()) {
            frogImage.translate(0, 10);
        }
    }

    public int getX() {
        return frogImage.getX();
    }

    public int getY() {
        return frogImage.getY();
    }

    public int getWidth() {
        return frogImage.getWidth();
    }

    public int getHeight() {
        return frogImage.getHeight();
    }

    public void draw() {
        frogImage.draw();
    }

    public void delete(){
        this.frogImage.delete();
    }
}
