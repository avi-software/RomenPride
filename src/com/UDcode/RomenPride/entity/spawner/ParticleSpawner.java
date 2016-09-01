package com.UDcode.RomenPride.entity.spawner;

import com.UDcode.RomenPride.entity.particle.Particle;
import com.UDcode.RomenPride.level.Level;

public class ParticleSpawner extends Spawner {

	private int life;
	public ParticleSpawner(int x, int y,int life, int amount,Level level){
		super(x , y ,Type.PARTICLE, amount,level);
		this.level = level;
		for(int i  = 0; i< amount; i++){
				level.add(new Particle(x, y ,life));
			
		}
	}
}
