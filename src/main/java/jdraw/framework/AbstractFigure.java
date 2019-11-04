/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.framework;


import jdraw.Handles.NorthEastHandle;
import jdraw.Handles.NorthHandle;
import jdraw.Handles.NorthWestHandle;

import java.util.LinkedList;
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
        List<FigureHandle> handles = new LinkedList<>();
        handles.add(new NorthWestHandle(this));
        handles.add(new NorthEastHandle(this));
        handles.add(new NorthHandle(this));
        return handles;

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
