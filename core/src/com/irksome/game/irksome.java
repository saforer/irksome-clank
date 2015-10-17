package com.irksome.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class irksome extends ApplicationAdapter {
	Screen currentScreen;
	SpriteBatch sb;
	Texture img;
	float ticks;


	@Override
	public void create () {
		currentScreen = new Screen();
		sb = new SpriteBatch();
	}

	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		currentScreen.render(sb);

	}

	void update(float dt) {
		ticks+=dt;
		currentScreen.update(dt);
	}
}
