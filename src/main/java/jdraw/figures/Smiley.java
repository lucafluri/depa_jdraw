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
public class Smiley extends AbstractFigure implements Figure {
	/**
	 * Use the java.awt.Rectangle in order to save/reuse code.
	 */
	private final Oval oval;
	private final Line eyeLeft;
	private final Line eyeRight;
	private final Line mouth;

	public Smiley(float x, float y, float w, float h) {
		oval = new Oval(x, y, w, h);
		eyeLeft = new Line(x, y, x, y);
		eyeRight = new Line(x, y, x, y);
		mouth = new Line(x, y, x, y);
	}

	/**
	 * Draw the oval to the given graphics context.
	 *
	 * @param g the graphics context to use for drawing.
	 */
	@Override public void draw(Graphics g) {
		oval.draw(g);
		eyeLeft.draw(g);
		eyeRight.draw(g);
		mouth.draw(g);
	}

	@Override public void setBounds(Point origin, Point corner) {
		double width = this.getBounds().width;
		double height = this.getBounds().height;

		Point originEyeLeft = new Point(origin.x + (int) (0.4*width), origin.y + (int) (0.2*height));
		Point originEyeRight = new Point(origin.x + (int) (0.6*width), origin.y + (int) (0.2*height));
		Point cornerEyeLeft = new Point(originEyeLeft.x, originEyeLeft.y + (int) (0.3*height));
		Point cornerEyeRight = new Point(originEyeRight.x, originEyeRight.y + (int) (0.3*height));


		oval.setBounds(origin, corner);
		eyeLeft.setBounds(originEyeLeft, cornerEyeLeft);
		eyeRight.setBounds(originEyeRight, cornerEyeRight);
		mouth.setBounds(origin, corner);
		fListeners.forEach(e -> e.figureChanged(new FigureEvent(this)));
	}

	@Override
	public Rectangle getBounds() {
		return oval.getBounds();
	}

	@Override public void move(int dx, int dy) {
		oval.move(dx, dy);
		eyeLeft.move(dx, dy);
		eyeRight.move(dx, dy);
		mouth.move(dx, dy);

		if (dx != 0 && dy != 0) {
			fListeners.forEach(e -> e.figureChanged(new FigureEvent(this)));
		}
	}

	@Override public boolean contains(int x, int y) {
		return oval.contains(x, y);
	}
}

