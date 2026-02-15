package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        front = new BufferedImage[3];
        back  = new BufferedImage[3];
        left  = new BufferedImage[3];
        right = new BufferedImage[3];

        screenX = gamePanel.screenWidth / 2 - (gamePanel.tileSize / 2);
        screenY = gamePanel.screenHeight / 2 - (gamePanel.tileSize / 2);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gamePanel.tileSize * 24;
        worldY = gamePanel.tileSize * 24;
        speed = 720 / gamePanel.fps;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            front[0] = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/player/idle-front.png")));
            front[1] = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/player/step1-front.png")));
            front[2] = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/player/step2-front.png")));
            back[0] = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/player/idle-back.png")));
            back[1] = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/player/step1-back.png")));
            back[2] = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/player/step2-back.png")));
            left[0] = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/player/idle-left.png")));
            left[1] = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/player/step1-left.png")));
            left[2] = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/player/step2-left.png")));
            right[0] = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/player/idle-right.png")));
            right[1] = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/player/step1-right.png")));
            right[2] = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/player/step2-right.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        boolean moving = false;

        if (keyHandler.upPressed) {
            direction = "up";
            worldY -= speed;
            moving = true;
        }
        else if (keyHandler.downPressed) {
            direction = "down";
            worldY += speed;
            moving = true;
        }
        else if (keyHandler.leftPressed) {
            direction = "left";
            worldX -= speed;
            moving = true;
        }
        else if (keyHandler.rightPressed) {
            direction = "right";
            worldX += speed;
            moving = true;
        }

        if (moving) {
            spriteCounter++;

            if (spriteCounter > 30) {
                spriteNumber = (spriteNumber + 1) % front.length;
                spriteCounter = 0;
            }
        } else {
            spriteNumber = 1;
        }
    }

    public void draw(Graphics2D graphics2D) {
        BufferedImage image = switch (direction) {
            case "up" -> switch (spriteNumber) {
                case 0 -> back[1];
                case 1 -> back[0];
                case 2 -> back[2];
                default -> null;
            };
            case "down" -> switch (spriteNumber) {
                case 0 -> front[1];
                case 1 -> front[0];
                case 2 -> front[2];
                default -> null;
            };
            case "left" -> switch (spriteNumber) {
                case 0 -> left[1];
                case 1 -> left[0];
                case 2 -> left[2];
                default -> null;
            };
            case "right" -> switch (spriteNumber) {
                case 0 -> right[1];
                case 1 -> right[0];
                case 2 -> right[2];
                default -> null;
            };
            default -> null;
        };
        graphics2D.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
