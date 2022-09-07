package voxels;

import voxels.game.World;
import voxels.graphic.Render;
import voxels.graphic.camera.Camera;

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
		for(int i = 0; i < width * height; i++) {
			this.pixels[i] = this.world.getAt(0, 0, 0).color;
		}
	}

}
