package com.irksome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Forer on 10/16/2015.
 */



public class Screen {
    int arrayWid = 10, arrayHei = 10;
    Tile[][] tileArray = new Tile[arrayWid][arrayHei];

    Player player;

    public Screen() {

        for (int x = 0; x < arrayWid; x++) {
            for (int y = 0; y < arrayHei; y++) {
                tileArray[x][y] = new Tile();
            }
        }

        player = new Player(new Texture("MobSpritesFull.png"), 0, 0, this);
    }


    public void render(SpriteBatch sb) {
        sb.begin();

        for (int xx = 0; xx < arrayWid; xx++) {
            for (int yy = 0; yy < arrayHei; yy++) {
                drawTile(xx, yy, sb);

            }
        }

        drawPlayer(player, sb);

        sb.end();
    }

    private void drawPlayer(Player player, SpriteBatch sb) {
        Tile t = new Tile();
        int x = ((player.x * t.width)  - (arrayWid * (t.width/2 ))) + (Gdx.graphics.getWidth() / 2) - t.width/2;
        int y = ((player.y * t.height) - (arrayHei * (t.height/2))) + (Gdx.graphics.getHeight() / 2) - t.height/2;

        sb.draw(player.img, x, y);
    }

    public void drawTile(int xx, int yy, SpriteBatch sb) {
        Tile t = tileArray[xx][yy];
        Texture toDraw = t.background;
        int x = ((xx * t.width)  - (arrayWid * (t.width/2 ))) + (Gdx.graphics.getWidth() / 2) - t.width/2;
        int y = ((yy * t.height) - (arrayHei * (t.height/2))) + (Gdx.graphics.getHeight() / 2) - t.height/2;

        sb.draw(toDraw, x, y);
    }

    public void update(float dt) {
        player.update();
    }

    public boolean canIGo(Directions dir, GameObject obj) {
        switch (dir) {
            case UP:
                if (obj.y < arrayHei -1) {
                    return true;
                }
                return false;
            case DOWN:
                if (obj.y > 0) {
                    return true;
                }
                return false;
            case LEFT:
                if (obj.x > 0) {
                    return true;
                }
                return false;
            case RIGHT:
                if (obj.x < arrayWid -1) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }
}
