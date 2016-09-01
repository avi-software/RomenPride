package com.UDcode.RomenPride.level.tile;

import com.UDcode.RomenPride.Gfx.Screen;
import com.UDcode.RomenPride.Gfx.Sprite;
import com.UDcode.RomenPride.level.tile.spawn_level.Spawn_Dirt_tile;
import com.UDcode.RomenPride.level.tile.spawn_level.Spawn_Floor_tile;
import com.UDcode.RomenPride.level.tile.spawn_level.Spawn_Grass_tile;
import com.UDcode.RomenPride.level.tile.spawn_level.Spawn_Grass_tile2;
import com.UDcode.RomenPride.level.tile.spawn_level.Spawn_Tree_tile;
import com.UDcode.RomenPride.level.tile.spawn_level.Spawn_Wall_tile;
import com.UDcode.RomenPride.level.tile.spawn_level.Spawn_Wall_tile2;
import com.UDcode.RomenPride.level.tile.spawn_level.Spawn_Water_tile;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile dirt = new DirtTile(Sprite.dirt);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile spawn_grass_tile = new Spawn_Grass_tile(Sprite.spawn_grass);
	public static Tile spawn_grass_tile2 = new Spawn_Grass_tile2(Sprite.spawn_grass2);
	public static Tile spawn_spawn_water_tile = new Spawn_Water_tile(Sprite.spawn_water);
	public static Tile spawn_wall_tile = new Spawn_Wall_tile(Sprite.spawn_wall);
	public static Tile spawn_floor_tile = new Spawn_Floor_tile(Sprite.spawn_floor);
	public static Tile spawn_dirt_tile = new Spawn_Dirt_tile(Sprite.spawn_dirt);
	public static Tile spawn_wall_tile2 = new Spawn_Wall_tile2(Sprite.spawn_wall2);
	public static Tile spawn_tree_tile = new Spawn_Tree_tile(Sprite.spawn_tree);
	//setting the color to pick from the level file
	public static final int col_spawn_grass = 0xFF00FF21;
	public static final int col_spawn_wall = 0xFF808080;
	public static final int col_spawn_wall2 = 0xFF100600;
	public static final int col_spawn_floor = 0xFF7F3300;
	public static final int col_spawn_player = 0xFF0094FF;
	public static final int col_spawn_tree = 0xFF003F07;
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
		
	}
	public void render(int x, int y, Screen screen){
		
	}
	public boolean solid(){
		return false;
	}

}
