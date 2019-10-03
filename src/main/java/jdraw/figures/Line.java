/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.AbstractFigure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Represents rectangles in JDraw.
 * 
 * @author Christoph Denzler
 *
 */
public class Line extends AbstractFigure implements Figure {
	/**
	 * Use the java.awt.Rectangle in order to save/reuse code.
	 */
	private final Line2D.Float line;

	public Line(float x1, float y1, float x2, float y2) {
		line = new Line2D.Float(x1, y1, x2, y2);
	}

	/**
	 * Draw the line to the given graphics context.
	 *
	 * @param g the graphics context to use for drawing.
	 */
	@Override public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(((int) line.x1), (int) line.y1, (int) line.x2, (int) line.y2);

	}

	@Override public void setBounds(Point origin, Point corner) {
		line.setLine(origin, corner);
		fListeners.forEach(e -> e.figureChanged(new FigureEvent(this)));
	}

	@Override
	public Rectangle getBounds() {
		return line.getBounds();
	}

	@Override public void move(int dx, int dy) {
		line.setLine(line.x1 + dx, line.y1 + dy, line.x2 + dx, line.y2 + dy);

		if (dx != 0 && dy != 0) {
			fListeners.forEach(e -> e.figureChanged(new FigureEvent(this)));
		}
	}

	@Override public boolean contains(int x, int y) {
		return line.contains(x, y);
	}
}


