package com.UDcode.RomenPride.level.tile.spawn_level;

import com.UDcode.RomenPride.Gfx.Screen;
import com.UDcode.RomenPride.Gfx.Sprite;
import com.UDcode.RomenPride.level.tile.Tile;

public class Spawn_Water_tile extends Tile {

	public Spawn_Water_tile(Sprite sprite) {
		super(sprite);
	
	}
	public void render(int x, int y, Screen screen){
		screen.renderTile(x<<4, y<<4, this);
		//do render stuff here!
	}

}
