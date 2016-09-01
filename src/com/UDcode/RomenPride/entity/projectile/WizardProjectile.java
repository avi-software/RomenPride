package com.UDcode.RomenPride.entity.projectile;

import com.UDcode.RomenPride.Gfx.Screen;
import com.UDcode.RomenPride.Gfx.Sprite;
import com.UDcode.RomenPride.entity.spawner.ParticleSpawner;

public class WizardProjectile extends Projectile{
	
	public static final int FIRE_RATE = 10;

	public WizardProjectile(int x, int y,double dir) {
		super(x, y, dir);
		range =100;
		speed =4;
		damage = 20;
		sprite = Sprite.wizard_projectile;
		
		nx =speed * Math.cos(angle);
		ny =speed *  Math.sin(angle);
	
		}
	public void update(){
		if( level.tilecollision((int) (x + nx),(int) (y + ny),8 )){
		level.add(new ParticleSpawner((int)x,(int)y,50,20 , level));
		 remove();
		}
		move();
	}
	protected void move(){
		
		x += nx;
		y += ny;
		if (distance() > range) remove();
		
	}
	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin -x) * (xOrigin-x) + (yOrigin -y) * (yOrigin -y)));
		return dist;
	}
	public void render(Screen screen){
		screen.renderprejectile((int)x+2,(int) y+6, this);
	}
	
	}
