
import javax.swing.*;
import java.awt.*;

class TextPanel extends JPanel {
	private int level;
	private int p1Score;
	private int deaths;

	public TextPanel() {
		setBackground(Color.white);
		setSize(new Dimension(850, 107));

		level = 1;
		deaths = 0;
		p1Score = 0;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, 850, 200);

		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman", 1, 30));
		g.drawString("Score: " + p1Score, 690, 30);
		g.drawString("Nick Sattele's Frogger", 30, 30);
		g.drawString("Deaths: " + deaths, 550, 30);
		g.drawString("Level: " + level, 350, 30);

	}

	public void frogDie() {
		deaths++;
		p1Score -= 10;
		repaint();
	}

	public void levelUp() {
		level++;
		p1Score += 100;
		repaint();
	}
}
