package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    private final ArrayList<String> directionStack = new ArrayList<>();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_W:
                upPressed = true;
                addDirection("up");
                break;
            case KeyEvent.VK_S:
                downPressed = true;
                addDirection("down");
                break;
            case KeyEvent.VK_A:
                leftPressed = true;
                addDirection("left");
                break;
            case KeyEvent.VK_D:
                rightPressed = true;
                addDirection("right");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_W:
                upPressed = false;
                directionStack.remove("up");
                break;
            case KeyEvent.VK_S:
                downPressed = false;
                directionStack.remove("down");
                break;
            case KeyEvent.VK_A:
                leftPressed = false;
                directionStack.remove("left");
                break;
            case KeyEvent.VK_D:
                rightPressed = false;
                directionStack.remove("right");
                break;
        }
    }

    private void addDirection(String dir) {
        directionStack.remove(dir);
        directionStack.add(dir);
    }

    public String getCurrentDirection() {
        if (directionStack.isEmpty()) {
            return null;
        }
        return directionStack.getLast();
    }
}
