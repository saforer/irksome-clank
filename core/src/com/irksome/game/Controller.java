package com.irksome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by Forer on 10/17/2015.
 */
public class Controller {
    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;
    boolean space = false;

    public void update() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            up = true;
        } else {
            up = false;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            down = true;
        } else {
            down = false;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            left = true;
        } else {
            left = false;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            right = true;
        } else {
            right = false;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            space = true;
        } else {
            space = false;
        }
    }
}
