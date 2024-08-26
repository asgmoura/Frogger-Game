package io.codeforall.bootcamp.controls;

import io.codeforall.bootcamp.GameController;
import io.codeforall.bootcamp.gameObject.Frog;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements KeyboardHandler {

    /**
     * Variable Declaration
     */
    //Keyboard
    public Keyboard keyboard;

    //Frog holder
    public Frog frog;

    //Game Controller
    public GameController gameController;

    public Controls(Frog frog, GameController gameController) {
        this.frog = frog;
        keyboard = new Keyboard(this);
        this.gameController = gameController;
        createKeyboardEvents();
    }

    //Keyboard events
    public void createKeyboardEvents() {
        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(keyboardEventUp);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(keyboardEventDown);

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(keyboardEventSpace);

        KeyboardEvent keyboardEventQ = new KeyboardEvent();
        keyboardEventQ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventQ.setKey(KeyboardEvent.KEY_Q);
        keyboard.addEventListener(keyboardEventQ);

    }


    //Keyboard Events while Key Pressed
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                frog.moveRight();
                break;

            case KeyboardEvent.KEY_LEFT:
                frog.moveLeft();
                break;

            case KeyboardEvent.KEY_UP:
                frog.moveUp();
                break;

            case KeyboardEvent.KEY_DOWN:
                frog.moveDown();
                break;

            case KeyboardEvent.KEY_SPACE:
                gameController.hideMainMenu();
                break;

            case KeyboardEvent.KEY_Q:
                System.exit(1);
                break;

        }

    }

    //Keyboard Events while Key Released
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
