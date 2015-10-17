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

    //player temp info
    int selectedx = 0;
    int selectedy = 0;
    Texture playerSprite = new Texture("MobSpritesFull.png");

    public Screen() {
        for (int x = 0; x < arrayWid; x++) {
            for (int y = 0; y < arrayHei; y++) {
                tileArray[x][y] = new Tile();
            }
        }

        tileArray[selectedx][selectedy].player = true;
    }


    public void render(SpriteBatch sb) {
        sb.begin();

        for (int xx = 0; xx < arrayWid; xx++) {
            for (int yy = 0; yy < arrayHei; yy++) {
                Tile t = tileArray[xx][yy];
                Texture toDraw = t.background;
                int x = ((xx * t.width)  - (arrayWid * (t.width/2 ))) + (Gdx.graphics.getWidth() / 2) - t.width/2;
                int y = ((yy * t.height) - (arrayHei * (t.height/2))) + (Gdx.graphics.getHeight() / 2) - t.height/2;

                sb.draw(toDraw, x, y);

                x = ((selectedx * t.width)  - (arrayWid * (t.width/2 ))) + (Gdx.graphics.getWidth() / 2) - t.width/2;
                y = ((selectedy * t.height) - (arrayHei * (t.height/2))) + (Gdx.graphics.getHeight() / 2) - t.height/2;

                sb.draw(playerSprite, x, y);
            }
        }

        sb.end();
    }

    public void update(float dt) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            playerMoveRight();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            playerMoveLeft();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            playerMoveUp();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            playerMoveDown();
        }
    }

    void playerMoveRight() {
        if (selectedx < arrayWid -1) {
            selectedx++;
        }
    }

    void playerMoveLeft() {
        if (selectedx > 0) {
            selectedx--;
        }
    }

    void playerMoveUp() {
        if (selectedy < arrayHei -1) {
            selectedy++;
        }
    }

    void playerMoveDown() {
        if (selectedy > 0) {
            selectedy--;
        }
    }
}
