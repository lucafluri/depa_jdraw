/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.framework;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;
import jdraw.framework.DrawView;

/**
 * This tool defines a mode for drawing rectangles.
 *
 * @see jdraw.framework.Figure
 *
 * @author  Christoph Denzler
 */
public abstract class AbstractDrawTool implements DrawTool {
    /**
     * the image resource path.
     */
    public static final String IMAGES = "/images/";

    public static String TOOLNAME = "Line";

    public static String FILEPATH = "line.png";

    /**
     * The context we use for drawing.
     */
    public final DrawContext context;

    /**
     * The context's view. This variable can be used as a shortcut, i.e.
     * instead of calling context.getView().
     */
    public final DrawView view;


    /**
     * Temporary variable.
     * During rectangle creation this variable refers to the point the
     * mouse was first pressed.
     */
    public Point anchor = null;

    /**
     * Create a new rectangle tool for the given context.
     * @param context a context to use this tool in.
     */
    public AbstractDrawTool(DrawContext context) {
        this.context = context;
        this.view = context.getView();

    }

    /**
     * Deactivates the current mode by resetting the cursor
     * and clearing the status bar.
     * @see DrawTool#deactivate()
     */
    @Override
    public void deactivate() {
        this.context.showStatusText("");
    }

    /**
     * Activates the Rectangle Mode. There will be a
     * specific menu added to the menu bar that provides settings for
     * Rectangle attributes
     */
    @Override
    public void activate() {
        this.context.showStatusText(TOOLNAME + " Mode");
    }



    @Override
    public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
    }

    @Override
    public Icon getIcon() {
        return new ImageIcon(getClass().getResource(IMAGES + FILEPATH));
    }

    @Override
    public String getName() {
        return TOOLNAME;
    }

}
