package voxels.game;

public interface World {
	public Voxel getAt(int x, int y, int z);
	public void setAt(int x, int y, int z, Voxel voxel);
}
