/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.framework;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * Represents rectangles in JDraw.
 *
 * @author Christoph Denzler
 *
 */
public abstract class AbstractFigure implements Figure	 {
    public static final long serialVersionUID = 9120181044386552132L;
    public CopyOnWriteArrayList<FigureListener> fListeners = new CopyOnWriteArrayList<>();





    /**
     * Returns a list of 8 handles for this Rectangle.
     * @return all handles that are attached to the targeted figure.
     * @see jdraw.framework.Figure#getHandles()
     */
    @Override
    public List<FigureHandle> getHandles() {
        return null;
    }

    @Override
    public void addFigureListener(FigureListener listener) {
        fListeners.add(listener);
    }

    @Override
    public void removeFigureListener(FigureListener listener) {
        fListeners.remove(listener);
        //fListenersToDelete.add(listener);
    }

    @Override
    public Figure clone() {
        return null;
    }

}
