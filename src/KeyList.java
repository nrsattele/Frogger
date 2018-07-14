import java.awt.event.*;
import java.awt.event.KeyListener;

class KeyList implements KeyListener
{
	boolean up, down, left, right, enter, space;
	boolean a, w, d, s; 
	boolean one, two, three, seven, eight, nine; 
	boolean p;
	
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case 27:	System.exit(0);			
			
			case KeyEvent.VK_LEFT:		if(!left)left = true;	break;
			case KeyEvent.VK_RIGHT:		if(!right)right= true;	break;
			case KeyEvent.VK_UP:		if(!up)up = true;		break;
			case KeyEvent.VK_DOWN:		if(!down)down = true;	break;
			case KeyEvent.VK_ENTER:		if(!enter)enter = true;	break;
			case KeyEvent.VK_SPACE:		if(!space)space = true;	break;
			
			case KeyEvent.VK_A:		a = true;	break;
			case KeyEvent.VK_W:		w = true;	break;
			case KeyEvent.VK_S:		s = true;	break;
			case KeyEvent.VK_D:		d = true;	break;
			
			case KeyEvent.VK_1:		one = true;	break;		//shoot
			case KeyEvent.VK_2:		two = true;	break;		//mine
			case KeyEvent.VK_3:		three = true;	break;	//invisible
			
			case KeyEvent.VK_7:		seven = true;	break;	//shoot
			case KeyEvent.VK_8:		eight = true;	break;	//mine
			case KeyEvent.VK_9:		nine = true;	break;	//invisible
			
			case KeyEvent.VK_P:		p = true;	break;	//invisible
			
			
		}
	}
	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:		left = false;	break;
			case KeyEvent.VK_RIGHT:		right= false;	break;
			case KeyEvent.VK_UP:		up = false;		break;
			case KeyEvent.VK_DOWN:		down = false;	break;
			case KeyEvent.VK_ENTER:		enter = false;	break;
			case KeyEvent.VK_SPACE:		space = false;	break;
			
			case KeyEvent.VK_A:		a = false;	break;
			case KeyEvent.VK_W:		w = false;	break;
			case KeyEvent.VK_S:		s = false;	break;
			case KeyEvent.VK_D:		d = false;	break;
			
			case KeyEvent.VK_1:		one = false;	break;
			case KeyEvent.VK_2:		two = false;	break;
			case KeyEvent.VK_3:		three = false;	break;
			case KeyEvent.VK_7:		seven = false;	break;
			case KeyEvent.VK_8:		eight = false;	break;
			case KeyEvent.VK_9:		nine = false;	break;
			
			case KeyEvent.VK_P:		p = false;	break;	//invisible
			
		}
	}
		
	public void keyTyped(KeyEvent e){}
}	
