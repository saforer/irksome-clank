package com.irksome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Forer on 10/17/2015.
 */


public class Player extends Mob {
    public Player (Texture img, int x, int y, Screen screen) {
        super(img, x, y, screen);
    }

    public void update() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            if (screen.canIGo(Directions.RIGHT, this)) {
                Move(Directions.RIGHT);
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            if (screen.canIGo(Directions.LEFT, this)) {
                Move(Directions.LEFT);
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (screen.canIGo(Directions.UP, this)) {
                Move(Directions.UP);
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            if (screen.canIGo(Directions.DOWN, this)) {
                Move(Directions.DOWN);
            }
        }
    }
}

/*


 */