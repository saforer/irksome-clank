package com.irksome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Forer on 10/16/2015.
 */



public class Screen {
    int arrayWid = 27, arrayHei = 18;
    Tile[][] tileArray = new Tile[arrayWid][arrayHei];
    int selectedx = 0;
    int selectedy = 0;

    public Screen() {
        for (int x = 0; x < arrayWid; x++) {
            for (int y = 0; y < arrayHei; y++) {
                tileArray[x][y] = new Tile();
            }
        }

        tileArray[selectedx][selectedy].selected = true;
    }


    public void render(SpriteBatch sb) {
        sb.begin();

        for (int xx = 0; xx < arrayWid; xx++) {
            for (int yy = 0; yy < arrayHei; yy++) {
                Tile t = tileArray[xx][yy];
                Texture toDraw = t.background;
                int x = ((xx * t.width)  - (arrayWid * (t.width/2 ))) + (Gdx.graphics.getWidth() / 2) - t.width/2;
                int y = ((yy * t.height) - (arrayHei * (t.height/2))) + (Gdx.graphics.getHeight() / 2) - t.height/2;
                if (!t.selected) {
                    sb.setColor(Color.WHITE);
                } else {
                    sb.setColor(Color.BLACK);
                }
                sb.draw(toDraw, x, y);
            }
        }

        sb.end();
    }

    public void update(float dt) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            if (selectedx > 0) {
                tileArray[selectedx][selectedy].selected = false;
                selectedx--;
                tileArray[selectedx][selectedy].selected = true;
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            if (selectedx < arrayWid - 1) {
                tileArray[selectedx][selectedy].selected = false;
                selectedx++;
                tileArray[selectedx][selectedy].selected = true;
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            if (selectedy > 0) {
                tileArray[selectedx][selectedy].selected = false;
                selectedy--;
                tileArray[selectedx][selectedy].selected = true;
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (selectedy < arrayHei - 1) {
                tileArray[selectedx][selectedy].selected = false;
                selectedy++;
                tileArray[selectedx][selectedy].selected = true;
            }
        }
    }
}
