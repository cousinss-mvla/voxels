package voxels.graphic.camera;

public class Camera {
	private double x;
	private double y;
	private double z;
	private float pitch;
	private float yaw;
	
	public Camera(double x, double y, double z, float pitch, float yaw) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.pitch = pitch;
		this.yaw = yaw;
	}
	
	public Camera(double x, double y, double z) {
		this(x, y, z, 0.0f, 0.0f);
	}

	public Camera() {
		this(0.0, 0.0, 0.0);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}
}
