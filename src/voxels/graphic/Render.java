package voxels.graphic;

//import java.util.Random;

public abstract class Render {
	public final int width;
	public final int height;
	public final int[] pixels;
	
	public Render(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width*height];
//		Random r = new Random();
//		for(int i = 0; i < pixels.length; i++) {
//			this.pixels[i] = r.nextInt();
//		}
		for(int i = 0; i < width*height; i++) {
		pixels[i] = 0;
		}
	}
	
	public abstract void render();
}