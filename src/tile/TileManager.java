package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {
    GamePanel gamePanel;
    public Tile[] tile;
    public int[][] mapTileNumber;

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tile = new Tile[36];
        mapTileNumber = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        getTileImage();
        loadMap("/maps/world1.txt");
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/base-tile.png")));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook1.png")));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook2.png")));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook3.png")));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook4.png")));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook5.png")));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook6.png")));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook7.png")));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook8.png")));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook9.png")));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook10.png")));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook11.png")));
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook12.png")));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook13.png")));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook14.png")));
            tile[14].collision = true;

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook15.png")));
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/rook16.png")));
            tile[16].collision = true;

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-tile1.png")));
            tile[17].collision = true;

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-tile2.png")));
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-tile-koi.png")));
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/tree.png")));
            tile[20].collision = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream inputStream =
                    getClass().getResourceAsStream(filePath);
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(Objects
                            .requireNonNull(inputStream)));

            int col = 0;
            int row = 0;
            while (col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow) {
                String line = bufferedReader.readLine();

                while (col < gamePanel.maxWorldCol) {
                    String[] numbers = line.trim().split("\\s+");

                    int num  = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row] = num;
                    col++;
                }

                if (col == gamePanel.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            bufferedReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) {

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow) {
            int tileNumber = mapTileNumber[worldCol][worldRow];

            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX
                    && worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX
                    && worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY
                    && worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
                graphics2D.drawImage(tile[tileNumber].image, screenX, screenY,
                        gamePanel.tileSize, gamePanel.tileSize, null);
            }
            worldCol++;

            if (worldCol == gamePanel.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
