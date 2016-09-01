package com.UDcode.RomenPride.level.tile;

import com.UDcode.RomenPride.Gfx.Screen;
import com.UDcode.RomenPride.Gfx.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite);
		
	}
	public void render(int x, int y, Screen screen){
		screen.renderTile(x<<4, y<<4, this);
}
	public boolean solid(){
		return true;
}
}