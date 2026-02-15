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
    Tile[] tile;
    int[][] mapTileNumber;

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tile = new Tile[33];
        mapTileNumber = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        getTileImage();
        loadMap("/maps/world1.txt");
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-tile1.png")));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-tile2.png")));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-tile3.png")));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-tile4.png")));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/stone-tile.png")));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-tile1.png")));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-tile2.png")));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-tile3.png")));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-stone1.png")));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-stone2.png")));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-stone3.png")));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-stone4.png")));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-stone5.png")));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-stone6.png")));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-stone7.png")));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-stone8.png")));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-stone9.png")));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-stone10.png")));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-stone11.png")));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/grass-stone12.png")));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-grass1.png")));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-grass2.png")));

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-grass3.png")));

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-grass4.png")));

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-grass5.png")));

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-grass6.png")));

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-grass7.png")));

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-grass8.png")));

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-grass9.png")));

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-grass10.png")));

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-grass11.png")));

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/water-grass12.png")));

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/sprites/tiles/stone-bridge.png")));
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

            graphics2D.drawImage(tile[tileNumber].image,
                    screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
            worldCol++;

            if (worldCol == gamePanel.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
