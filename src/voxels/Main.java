package voxels;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int fps = -1;
		Scanner scanner = new Scanner(System.in);
		while(fps < 0) {
			System.out.print("Max FPS: ");
			try {
				fps = scanner.nextInt();
			} catch(InputMismatchException e) {
				continue;
			}
		}
		scanner.close();
		Display game = new Display(fps);
		game.start();
	}
}