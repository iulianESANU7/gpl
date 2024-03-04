package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;

@SuppressWarnings("serial")
public class CustomCaret extends DefaultCaret {
	
	public CustomCaret() {
		setBlinkRate(500);
		
	}
	
	@Override
	protected synchronized void damage(Rectangle r) {
		if (r == null) {
			return;
		}
		
		// Gestion position du curseur
		JTextComponent c = getComponent();
		x = r.x + 10;
		y = r.y + r.height - 5;
		width = 50;
		height = 20;
		c.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
	    JTextComponent comp = getComponent();
	    if (comp == null) {
	        return;
	    }

	    int dot = getDot();
	    Rectangle2D r = null;
	    try {
	        r = comp.modelToView2D(dot);
	    } catch (BadLocationException e) {
	        return;
	    }

	    if (r == null) {
	        return;
	    }

	    if (isVisible()) {
	        g.setColor(Color.WHITE);
	        g.fillRect((int)r.getX() - 10, (int)r.getY() + (int)r.getHeight() - 5, 10, 2);
	    }
	}



}