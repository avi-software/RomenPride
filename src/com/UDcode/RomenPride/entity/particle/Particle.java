package com.UDcode.RomenPride.entity.particle;

import com.UDcode.RomenPride.Gfx.Screen;
import com.UDcode.RomenPride.Gfx.Sprite;
import com.UDcode.RomenPride.entity.Entity;

public class Particle extends Entity{
	private Sprite sprite;
	
	
	private int life;
	private int time = 0;
	protected double xa, ya,za;
	protected double xx,yy,zz;
	
	public Particle (int x, int y, int life){
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life +( random.nextInt(30)-10);
		sprite = Sprite.particle_normal;
		
		this.xa = random.nextGaussian()+1.5;
		if(this.xa<=0) xa=0.1;
		this.ya = random.nextGaussian();
		this.zz = random.nextFloat()+2.0;
	}
	
	
	public void update(){
		time++;
		if(time >= 7400) time = 0;
		if(time>life)remove();
		//setting the "floor" by
		za -= 0.1;
		if(zz < 0){
			zz =0;
			za *= -0.44;
			xa*= 0.5;
			ya*= 0.5+0.2;
			
		}
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
	}
	
	public void render(Screen screen){
		screen.renderSprite((int)xx+2, (int)yy+10 -(int) zz, sprite, true);
		
	}
	
}
