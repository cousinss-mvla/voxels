package voxels;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import voxels.game.world.ArrayWorld;
import voxels.graphic.Render;
import voxels.graphic.camera.CameraRender;

public class Display extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Voxels 0.0.1";
	private final double FRAMES_PER_SECOND;
	
	private Thread thread;
	private boolean running = false;
	private Render render;
	private BufferedImage img;
	private int[] pixels;
	
	public Display(int fps) {
		FRAMES_PER_SECOND = fps;
		
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle(TITLE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		render = new CameraRender(WIDTH, HEIGHT, new ArrayWorld());
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
	}
	
	public void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		int frames = 0;
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double secondsPerTick = 1 / FRAMES_PER_SECOND;
		long tickCount = 0;
		boolean ticked = false;
		long currentTime;
		long passedTime;
		System.out.println("Target FPS: " + FRAMES_PER_SECOND);
		while(running) {
			ticked = false;
			currentTime = System.nanoTime();
			passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds += passedTime / 1000000000.0;
			while(unprocessedSeconds > secondsPerTick) {
				tick();
				ticked = true;
				unprocessedSeconds -= secondsPerTick;
				tickCount++;
				if(tickCount % FRAMES_PER_SECOND == 0) {
					System.out.println(frames + " fps");
					frames = 0;
				}
			}
			if(ticked) {
				render();
				frames++;
			}
		}
	}

	private void tick() {
		((CameraRender)render).getCamera().setX(((CameraRender)render).getCamera().getX() + 1);
//		((CameraRender)render).getCamera().setX(10);
		((CameraRender)render).getCamera().setY(((CameraRender)render).getCamera().getY() + 0.01);
	}
	
	private void render() {
		for(int i = 0; i < WIDTH * HEIGHT; i++) {
			pixels[i] = render.pixels[i];
		}
		
		render.render();
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
		bs.show();
	}

	public void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
