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
    Player player;

    public Screen() {

        for (int x = 0; x < arrayWid; x++) {
            for (int y = 0; y < arrayHei; y++) {
                tileArray[x][y] = new Tile();
            }
        }

        player = new Player(new Texture("MobSpritesFull.png"), 0, 0);
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

                x = ((player.x * t.width)  - (arrayWid * (t.width/2 ))) + (Gdx.graphics.getWidth() / 2) - t.width/2;
                y = ((player.y * t.height) - (arrayHei * (t.height/2))) + (Gdx.graphics.getHeight() / 2) - t.height/2;

                sb.draw(player.img, x, y);
            }
        }

        sb.end();
    }

    public void update(float dt) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            if (player.x < arrayHei -1) {
                player.Move(Directions.RIGHT);
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            if (player.x > 0) {
                player.Move(Directions.LEFT);
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (player.y < arrayHei -1) {
                player.Move(Directions.UP);
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            if (player.y > 0) {
                player.Move(Directions.DOWN);
            }
        }
    }
}
