/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import jdraw.framework.AbstractDrawTool;
import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * This tool defines a mode for drawing rectangles.
 *
 * @see jdraw.framework.Figure
 *
 * @author  Christoph Denzler
 */
public class SmileyTool extends AbstractDrawTool implements DrawTool {


	/**
	 * Create a new rectangle tool for the given context.
	 *
	 * @param context a context to use this tool in.
	 */
	public SmileyTool(DrawContext context) {
		super(context);
		TOOLNAME = "Smiley";
		FILEPATH = "oval.png";
	}


	/**
	 * Initializes a new Rectangle object by setting an anchor
	 * point where the mouse was pressed. A new Rectangle is then
	 * added to the model.
	 * @param x x-coordinate of mouse
	 * @param y y-coordinate of mouse
	 * @param e event containing additional information about which keys were pressed.
	 *
	 * @see DrawTool#mouseDown(int, int, MouseEvent)
	 */
	@Override
	public void mouseDown(int x, int y, MouseEvent e) {
		if (newFigure != null) {
			throw new IllegalStateException();
		}
		anchor = new Point(x, y);
		newFigure = new Smiley(x, y, 0, 0);
		view.getModel().addFigure(newFigure);
	}

}
