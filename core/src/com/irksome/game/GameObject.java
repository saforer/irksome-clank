package com.irksome.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Forer on 10/17/2015.
 */
public class GameObject {
    Texture img;
    int x;
    int y;
    public GameObject (Texture img, int x, int y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public void Move(Directions dir) {
        switch (dir) {
            case UP:
                y++;
                break;
            case DOWN:
                y--;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }
    }
}
