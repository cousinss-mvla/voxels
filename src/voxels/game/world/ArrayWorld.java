package voxels.game.world;

import voxels.game.Voxel;
import voxels.game.World;

public class ArrayWorld implements World {
	
	private Voxel[][][] world;
	
	public ArrayWorld() {
		world = new Voxel[8][8][8];
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				for(int z = 0; z < 8; z++) {
					world[x][y][z] = new Voxel(72342);
				}
			}
		}
	}
	
	@Override
	public Voxel getAt(int x, int y, int z) {
		return world[x][y][z];
	}

	@Override
	public void setAt(int x, int y, int z, Voxel voxel) {
		world[x][y][z] = voxel;
	}
	
}
