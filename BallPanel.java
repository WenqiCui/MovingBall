package demoBall.MovingBall;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BallPanel extends JPanel{
	int x = 0;
	int y = 0;
	static int WIDTH;
	static int HEIGHT;
	int ballSize=30;
	Color color=Color.BLACK;
	static {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size = kit.getScreenSize();
		WIDTH=size.width* 2 / 3;
		HEIGHT=size.height* 2 / 3;
	}
	public BallPanel() {
		setSize(WIDTH, HEIGHT);
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d=(Graphics2D)g;
		g2d.setColor(color);
		g2d.fillOval(x-ballSize/2, y-ballSize/2, ballSize, ballSize);
	}
	public void move(int a,int b){
		int h=this.getSize().height;
		int w=this.getSize().width;
		x+=a;
		if (x>w) x=w;
		if (x<0) x=0;
		y+=b;
		if (y>h) y=h;
		if (y<0) y=0;
		repaint();
	}
}
