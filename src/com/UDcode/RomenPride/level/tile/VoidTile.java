package com.UDcode.RomenPride.level.tile;

import com.UDcode.RomenPride.Gfx.Screen;
import com.UDcode.RomenPride.Gfx.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	
	}
	public void render(int x, int y, Screen screen){
		screen.renderTile(x<<4, y<<4, this);

}
}