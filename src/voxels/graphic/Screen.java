package voxels.graphic;

import java.util.Random;

public class Screen extends Render {
	
	private Render test;
	
	public Screen(int width, int height) {
		super(width, height);
		
		test = new Render(256,256);
		Random r = new Random();
		for(int i = 0; i < 256*256; i++) {
			test.pixels[i] = r.nextInt();
		}
	}
	
	public void render() {
		for(int i = 0; i < width*height; i++) {
			pixels[i] = 0;
		}
		draw(test, 
				(width-256)/2+(int)(Math.cos((System.currentTimeMillis())%2000.0 / 2000.0 * Math.PI * 2)*100), 
				(height-256)/2-(int)(Math.sin((System.currentTimeMillis())%2000.0 / 2000.0 * Math.PI * 2)*100));
	}
}
