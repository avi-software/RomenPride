package com.UDcode.RomenPride.level;


import java.util.ArrayList;
import java.util.List;

import com.UDcode.RomenPride.Gfx.Screen;
import com.UDcode.RomenPride.entity.Entity;
import com.UDcode.RomenPride.entity.particle.Particle;
import com.UDcode.RomenPride.entity.projectile.Projectile;
import com.UDcode.RomenPride.level.tile.Tile;

public class Level {
	
	protected int width , height;
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	protected int[] tilesint;
	protected int[] tiles;
	protected int tile_size;
	private List<Entity>entities = new ArrayList<Entity>();
	private List<Projectile>projectiles = new ArrayList<Projectile>();
	private List<Particle>particles = new ArrayList<Particle>();
	
	public static Level spawn = new SpawnLevel("/levels/spawn.png");

	public  Level (int width, int height){
		this.width = width;
		this.height = height;
		tilesint = new int[width * height];
		generateLevel();
		
		
	}
	public Level(String path){
		loadLevel(path);
		generateLevel();
	
	}

	protected void generateLevel() {
		for(int y = 0; y < 64; y++){
			for(int x = 0; x < 64; x++){
				getTile(x, y);
	}
		}
		tile_size =16;
	}
	protected void loadLevel(String path){
		
	}
	public void update(){
		for(int i = 0; i< entities.size(); i++){
		entities.get(i).update();
		}
		for(int i = 0; i< projectiles.size(); i++){
			projectiles.get(i).update();
			
		}
		for(int i = 0; i< particles.size(); i++){
			particles.get(i).update();
		}
		remove();
	}
	private void remove(){
		for(int i = 0; i< entities.size(); i++){
			if(entities.get(i).isRemoved()) entities.remove(i);
			}
			for(int i = 0; i< projectiles.size(); i++){
				if(projectiles.get(i).isRemoved()) projectiles.remove(i);
				
			}
			for(int i = 0; i< particles.size(); i++){
				if(particles.get(i).isRemoved()) particles.remove(i);
			}
	}
	public List<Projectile> getProjectiles(){
		return projectiles;
	}
	private void time(){		
	}
	//controlling the projectile collision and spot of removal
	public  boolean tilecollision(int x, int  y  ,int size){
		boolean solid = false;
		for(int c = 0; c < 4; c++ ){
			int  xt = (x + c % 2 * size / 5 + 2  )/ 16;
			int yt = (y + c % 2 * size / 6 + 13)/16;
			if (getTile( xt, yt).solid()) solid = true; 
		}
		return solid;
	}
	public void render( int xScroll,int  yScroll, Screen screen){
		//corner pin define the size of our screen
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4 ;
		int x1 = (xScroll + screen.width+16)>>4 ;
		int y0 = yScroll >> 4 ;
		int y1 = (yScroll + screen.height+16)>>4 ;
		for(int y = y0; y<y1; y++ ){
			for(int x = x0; x<x1; x++){
				getTile(x, y).render(x, y, screen);
				/*if(x+y *16<0 || x+y *16>=256){
					Tile.voidTile.render(x, y, screen);
					continue;
				}
				tiles[x+y *16].render(x, y, screen);
			*/}
		}
		for(int i = 0; i< entities.size(); i++){
			entities.get(i).render(screen);
		}
		for(int i = 0; i< projectiles.size(); i++){
			projectiles.get(i).render(screen);
		}
		for(int i = 0; i< particles.size(); i++){
			particles.get(i).render(screen);
		}
	}
	public void add(Entity e){
		e.init(this);
		if(e instanceof Particle){
			particles.add((Particle) e);
		}else if(e instanceof Projectile){
			projectiles.add((Projectile) e);
		}else{
			entities.add(e);
		}
		
	}
	public void addProjectile(Projectile p){
		p.init(this);
		
		
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height )return Tile.voidTile;
		if(tiles[x + y * width] == Tile.col_spawn_floor) return Tile.spawn_floor_tile;
		if(tiles[x + y * width] == Tile.col_spawn_grass)return Tile.spawn_grass_tile;
		if(tiles[x + y * width] == Tile.col_spawn_wall)return Tile.spawn_wall_tile;
		if(tiles[x + y * width] == Tile.col_spawn_wall2)return Tile.spawn_wall_tile2;
		if(tiles[x + y * width] == Tile.col_spawn_tree)return Tile.spawn_tree_tile;
		
		return Tile.voidTile;
	}
}
