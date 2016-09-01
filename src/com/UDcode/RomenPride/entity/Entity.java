package com.UDcode.RomenPride.entity;

import java.util.Random;

import com.UDcode.RomenPride.Gfx.Screen;
import com.UDcode.RomenPride.Gfx.Sprite;
import com.UDcode.RomenPride.level.Level;

public abstract class Entity {
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();

	
	
	public void update(){
	}
	public void render(Screen screen){
	}
	
	public void remove(){
		//remove from level
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
	}


	public void init(Level level){
		this.level = level;
	}
}