package com.irksome.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class irksome extends ApplicationAdapter {
	Sprite[][] tileArray = new Sprite[32][32];
	static Texture blankTexture;
	static Texture personTexture;
	SpriteBatch sb;
	float timer = 0;

	@Override
	public void create () {
		sb = new SpriteBatch();

		blankTexture = new Texture("blank.png");
		personTexture = new Texture("person.png");
		for (int i = 0; i < tileArray.length; i++) {
			for (int j = 0; j < tileArray.length; j++) {
				Sprite s = new Sprite(blankTexture);
				s.setX(16 * i);
				s.setY(16 * j);
				tileArray[i][j] = s;
			}
		}

		tileArray[0][0] = new Sprite(personTexture);

	}

	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sb.begin();
		for (Sprite[] sA : tileArray) {
			for (Sprite s : sA) {
				s.draw(sb);
			}
		}
		sb.end();
	}

	void update (float dt) {
		final float count = .03f;
		timer += dt;
		if (timer >= count) {
			//Update Loop goes here.
		}
	}
}

