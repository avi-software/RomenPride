package com.UDcode.RomenPride.entity.spawner;

import com.UDcode.RomenPride.entity.Entity;
import com.UDcode.RomenPride.entity.particle.Particle;
import com.UDcode.RomenPride.level.Level;

public class Spawner extends Entity{
	
		 public enum Type{
			 MOB, PARTICLE;
		 }
		 private Type type;
	public Spawner(int x ,int y,  Type type, int amount ,Level level){
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;
		
	}

}
