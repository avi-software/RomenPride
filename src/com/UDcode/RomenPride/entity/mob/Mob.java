package com.UDcode.RomenPride.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.UDcode.RomenPride.Gfx.Sprite;
import com.UDcode.RomenPride.entity.Entity;
import com.UDcode.RomenPride.entity.particle.Particle;
import com.UDcode.RomenPride.entity.projectile.Projectile;
import com.UDcode.RomenPride.entity.projectile.WizardProjectile;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir= 0;
	protected boolean moving = false;
	protected boolean walking = false;
	


	public void move(int xa, int ya){
		System.out.println(" size " + level.getProjectiles().size());
		if (xa != 0 && ya != 0){
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		if(xa>0) dir = 1;
		if(xa<0) dir = 3;
		if(ya>0) dir = 2;
		if(xa>0) dir = 1;
		if(xa<0) dir = 3;
		if(ya>0) dir = 2;
		if(ya<0) dir = 0;
		
		
			if(!collision(xa , ya)){
		x+= xa;
		y+= ya;
	
	
		} else {
		//	Particle p = new Particle(x +10, y +10, 50, 500);
			//level.add(p);
			
		}
	}
	
	public void update(){
		
	}

		protected void shoot(int x , int y,double dir/*,boolean ds*/){
			//dir *= 180 / Math.PI;
			
			Projectile p = new WizardProjectile(x, y ,dir);
			level.add(p);
			
		}

	private boolean collision(int xa ,int ya){
		boolean solid = false;
		for(int c = 0; c < 4; c++ ){
			int xt = ((x + xa) + c % 2 * 10 + 10  )/ 16;
			int yt = ((y + ya) + c / 2 *13 + 17)/16;
			if (level.getTile(xt, yt).solid()) solid = true; 
		}
		
		return solid;
	}
	public void render(){
		
	}
}
