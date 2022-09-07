package voxels.graphic.camera;

import voxels.game.World;
import voxels.graphic.Render;

public class CameraRender extends Render {

	private final World world;
	private final Camera camera;
	
	public CameraRender(int width, int height, World world) {
		super(width, height);
		this.world = world;
		this.camera = new Camera();
	}

	@Override
	public void render() {
		int u = 0;
		int v = 0;
		for(int i = 0; i < width * height; i++) {
			if(u == width) {
				u = 0;
				v++;
			}
			float uF = u/(float)width;
			float vF = v/(float)height;
			this.pixels[i] = rgb((int)(uF*255), 255, (int)(vF*255));
			u++;
		}
	}
	
	private int rgb(int red, int green, int blue) {
		return (((red<<8)+green)<<8)+blue;
	}

}
