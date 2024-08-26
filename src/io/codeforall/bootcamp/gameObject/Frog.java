package io.codeforall.bootcamp.gameObject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Frog {

    /**
     * Variable Declaration
     */

    //Frog Image
    private Picture frogImage;

    //Background Image
    private Picture background;

    /**
     * Construtor
     */

    //Frog Constructor
    public Frog(int x, int y, Picture background) {

        //Assign the image to the Frog
        this.frogImage = new Picture((double) x / 2, y, "resources/images/frog.png");

        //Draw the Frog
        frogImage.draw();

        //Initialize background
        this.background = background;
    }

    /**
     * Getters and Setters
     */

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

    /**
     * Methods
     */

    //Frog moves right
    public void moveRight() {
        if (frogImage.getX() + frogImage.getWidth() + 10 <= background.getWidth()) {
            frogImage.translate(10, 0);
        }
    }

    //Frog moves left
    public void moveLeft() {
        if (frogImage.getX() - 10 >= 0) {
            frogImage.translate(-10, 0);
        }
    }

    //Frog moves up
    public void moveUp() {
        if (frogImage.getY() - 10 >= 0) {
            frogImage.translate(0, -10);
        }
    }

    //Frog moves down
    public void moveDown() {
        if (frogImage.getY() + frogImage.getHeight() + 10 <= background.getHeight()) {
            frogImage.translate(0, 10);
        }
    }

    //Draw Frog
    public void draw() {
        frogImage.draw();
    }

    //Delete Frog
    public void delete(){
        this.frogImage.delete();
    }
}
