package com.irksome.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Forer on 10/16/2015.
 */
public class Tile {
    Texture background;
    boolean selected;
    int width = 25;
    int height = 25;
    public Tile () {
        selected = false;
        background = new Texture("exampletile.png");
    }
}
