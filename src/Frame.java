import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class myJFrame extends JFrame
{
	myJPanel panel;
	public myJFrame()
	{
		setTitle("Nick Sattele's Frogger Game - Nick Sattele Rocks!");
		
		setResizable(false);//Makes the frame not able to be stretched or 
							//fit to screen
		
		setSize(new Dimension(3000,3000));//dimensions of the frame(pixels)
			
		//KeyListener
		KeyList KL = new KeyList();
		addKeyListener(KL);
		
		Container container = getContentPane();	

		//Game score/details panel
		TextPanel txtPanel = new TextPanel();
		txtPanel.setPreferredSize(new Dimension(850,50));
		container.add(txtPanel, BorderLayout.NORTH);
		
		//Adds score/details panel, key listener to the JPanel
		panel = new myJPanel(txtPanel, KL, this);
		panel.setPreferredSize(new Dimension(850,600));
		container.add(panel, BorderLayout.SOUTH);

		pack();
		repaint();
	}
	public void startGame()
	{
		panel.startGame();
	}
	private class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
}
