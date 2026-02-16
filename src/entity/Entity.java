package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY;
    public int speed;
    public BufferedImage[] front, back, left, right;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNumber = 1;
    public Rectangle hitbox;
    public boolean collision = true;
}
