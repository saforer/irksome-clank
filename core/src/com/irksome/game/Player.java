package com.irksome.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Forer on 10/17/2015.
 */


public class Player extends Mob {
    public Player (Texture img, int x, int y) {
        super(img, x, y);
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
