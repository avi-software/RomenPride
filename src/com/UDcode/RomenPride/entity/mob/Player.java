package com.UDcode.RomenPride.entity.mob;

import com.UDcode.RomenPride.Game;
import com.UDcode.RomenPride.Gfx.Screen;
import com.UDcode.RomenPride.Gfx.Sprite;
import com.UDcode.RomenPride.entity.projectile.Projectile;
import com.UDcode.RomenPride.entity.projectile.WizardProjectile;
import com.UDcode.RomenPride.input.Keyboard;
import com.UDcode.RomenPride.input.Mouse;

public class Player extends Mob{
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	
	Projectile p;
	private int fireRate = 0;
	
	public Player(Keyboard input){
		this.input = input;
		sprite = Sprite.player_d;
		
	}
	
	public Player(int x, int y,Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_d;
		fireRate = WizardProjectile.FIRE_RATE;
	}
	public void update(){
		if(fireRate > 0 ) fireRate-- ;
		int xa = 0, ya =0;
		//prevent the game from crushing if left running all night
		if(anim<7500)anim++;
		else anim = 0 ;
		if(input.up) ya--;			
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		
		
		
		if(xa !=0 || ya !=0){
			move(xa, ya);
			walking = true;
		}else{ 
			walking = false;
		}	
	/*	if(input.up) y--;
		if(input.down) y++;
		if(input.left) x--;
		if(input.right) x++;*/
		clear();
	updateshooting();
	
	}
	//removing the projectiles from the screen
private void clear(){
		for(int i  = 0; i<level.getProjectiles().size(); i++){
			Projectile p = level.getProjectiles().get(i);
			if(p.isRemoved()) level.getProjectiles().remove(i);
			
		}
	}
	//this method determine which angle to fire at
	private void updateshooting() {
		if(Mouse.getButton() == 1 && fireRate <=0 || input.shoot  && fireRate <=0){
			double dx =(Mouse.getX() - Game.getWindowWidth() / 2) ;
			double dy =(Mouse.getY() - Game.getWindowHeight() / 2);
			double dir = Math.atan2(dy, dx);
	
			shoot(x,y,dir);
			fireRate = WizardProjectile.FIRE_RATE;
		}
	}

	public void render(Screen screen){
		int flip = 0;
		
		
		if(dir == 0){
			sprite = sprite.player_u;
			if(walking){
				if(anim% 20 >10){
					sprite = sprite.player_u2;
					}else{
						sprite = sprite.player_u3;

					}
					
				}
		}
	
		{
		
		if(dir == 3 ) {sprite = sprite.player_side;
		if(walking){
			if(anim% 20 >10){
				sprite = sprite.player_side2;
				}else{
					sprite = sprite.player_side3;
				}
		}
		
	}
		
		if(dir == 2 ){
			sprite = sprite.player_d;
			if(walking)
				if(anim % 20 > 10){
					sprite = sprite.player_d2;
				}else{sprite = sprite.player_d3;
				}
			}
		}
		
			{if(dir == 1){sprite = sprite.player_side;
			if(walking){
				if(anim% 20 >10){
					sprite = sprite.player_side2;
					}else{
						sprite = sprite.player_side3;
					}
			}
			
			
				flip = 1;
				
			
	}	
			
			screen.renderPlayer(x, y, sprite,flip);
	
	
	
}
}
}
