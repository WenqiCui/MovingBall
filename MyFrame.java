package demoBall.MovingBall;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	BallPanel bp;

	public MyFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setLocationByPlatform(true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size = kit.getScreenSize();
		this.setSize(size.width * 2 / 3, size.height * 2 / 3);
		this.setIconImage(new ImageIcon("icon.gif").getImage());
		this.setTitle("MyFrame");
		this.setVisible(true);
		bp = new BallPanel();
		this.add(bp);
		this.addKeyListener(new BallListener());
	}

	private class BallListener implements KeyListener {

		Timer W = new Timer(1, (event) -> {
			bp.move(0, -2);
		});
		Timer A = new Timer(1, (event) -> {
			bp.move(-2, 0);
		});
		Timer S = new Timer(1, (event) -> {
			bp.move(0, 2);
		});
		Timer D = new Timer(1, (event) -> {
			bp.move(2, 0);
		});

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自动生成的方法存根
			// System.out.print("->"+e.getKeyChar());
			// bp.move((int)(Math.random()*100-50),(int)(Math.random()*100-50));
			if ((e.getKeyCode() == 'W') || (e.getKeyCode() == 'w')) {
				// System.out.print("->"+e.getKeyChar());
				W.start();
			}
			if ((e.getKeyCode() == 'A') || (e.getKeyCode() == 'a')) {
				// bp.move(-10,0);
				A.start();
			}
			if ((e.getKeyCode() == 'S') || (e.getKeyCode() == 's')) {
				// bp.move(0, 10);
				S.start();
			}
			if ((e.getKeyCode() == 'D') || (e.getKeyCode() == 'd')) {
				// bp.move(10, 0);
				D.start();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自动生成的方法存根
			if (((e.getKeyCode() == 'W') || (e.getKeyCode() == 'w')) && (W.isRunning()))
				W.stop();
			if (((e.getKeyCode() == 'A') || (e.getKeyCode() == 'a')) && (A.isRunning()))
				A.stop();
			if (((e.getKeyCode() == 'S') || (e.getKeyCode() == 's')) && (S.isRunning()))
				S.stop();
			if (((e.getKeyCode() == 'D') || (e.getKeyCode() == 'd')) && (D.isRunning()))
				D.stop();
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO 自动生成的方法存根

		}

	}

}
