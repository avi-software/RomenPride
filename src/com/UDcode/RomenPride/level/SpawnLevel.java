package com.UDcode.RomenPride.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpawnLevel extends Level{
	
	

	

public SpawnLevel(String path){
	super(path);
	}

protected void loadLevel(String path){
	try{
		BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
		int w = width = image.getWidth();
		int h =height = image.getHeight();
		tiles = new int[w*h];
		image.getRGB(0, 0, w, h, tiles, 0, w);
		
	}catch (IOException e){
		e.printStackTrace();
		System.out.println("Exception! could not load level file ");
		
	}
}
//grass = 0xFF00
//dirt = 0x7F7F00
//rock = 0xFFFF00
	protected void generateLevel(){
		
		
		
		
		
		
		
		//a bad way to load levels 
		/*	for(int i = 0; i< levelPixels.length; i++){
		
		if(levelPixels [i] == 0xFF00ff00) tiles[i] = Tile.grass ;
		if(levelPixels [i] == 0xFFFFFF00) tiles[i] = Tile.rock;
		if(levelPixels [i] == 0xFF7F7F00) tiles[i] = Tile.dirt ;
		
	}*/
}
}

