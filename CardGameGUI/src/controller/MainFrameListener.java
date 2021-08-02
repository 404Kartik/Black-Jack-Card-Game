package controller;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import view.gui.MainFrame;

public class MainFrameListener implements ComponentListener {
	MainFrame mFrame;
	
	public MainFrameListener(MainFrame mFrame) {
		this.mFrame = mFrame;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		mFrame.getMPanel().getCPanel().setPreferredSize(new Dimension(mFrame.getWidth(), mFrame.getMPanel().getHeight() * 2 / 3));
		mFrame.getMPanel().getSPanel().setPreferredSize(new Dimension(mFrame.getWidth(), mFrame.getMPanel().getHeight() / 3));
		
		mFrame.getMPanel().getCPanel().repaint();
		mFrame.getMPanel().getCPanel().revalidate();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
