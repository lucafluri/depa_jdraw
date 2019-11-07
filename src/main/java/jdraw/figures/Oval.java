/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import jdraw.framework.AbstractFigure;
import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Represents rectangles in JDraw.
 * 
 * @author Christoph Denzler
 *
 */
public class Oval extends AbstractFigure implements Figure {
	/**
	 * Use the java.awt.Rectangle in order to save/reuse code.
	 */
	private final Ellipse2D.Float oval;

	public Oval(float x, float y, float w, float h) {
		oval = new Ellipse2D.Float(x, y, w, h);
	}

	/**
	 * Draw the oval to the given graphics context.
	 *
	 * @param g the graphics context to use for drawing.
	 */
	@Override public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval((int) oval.x,(int)  oval.y,(int)  oval.width,(int)  oval.height);

	}

	@Override public void setBounds(Point origin, Point corner) {
		oval.setFrameFromDiagonal(origin, corner);
		fListeners.forEach(e -> e.figureChanged(new FigureEvent(this)));
	}

	@Override
	public Rectangle getBounds() {
		return oval.getBounds();
	}

	@Override public Figure clone() {
		return new Oval(oval.x, oval.y, oval.width, oval.height);
	}

	@Override public void move(int dx, int dy) {
		oval.x += dx;
		oval.y += dy;

		if (dx != 0 && dy != 0) {
			fListeners.forEach(e -> e.figureChanged(new FigureEvent(this)));
		}
	}

	@Override public boolean contains(int x, int y) {
		return oval.contains(x, y);
	}
}


