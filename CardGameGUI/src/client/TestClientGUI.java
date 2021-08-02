package client;

import javax.swing.SwingUtilities;

import controller.MainFrameListener;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.GameEngineCallbackImpl;
import view.gui.GameEngineCallbackGUI;
import view.gui.MainFrame;
import view.interfaces.GameEngineCallback;

public class TestClientGUI {
	public static void main(String[] args) {
		// We access our main view and model through the singleton Registry
		// class
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				GameEngine gEngine = new GameEngineImpl();
				MainFrame mainFrame = new MainFrame(gEngine);
				mainFrame.construct();
				mainFrame.addComponentListener(new MainFrameListener(mainFrame));
				GameEngineCallback gEngineCBGUI = new GameEngineCallbackGUI(mainFrame);
				gEngine.addGameEngineCallback(gEngineCBGUI);
				GameEngineCallback gEngineCBImpl = new GameEngineCallbackImpl();
				gEngine.addGameEngineCallback(gEngineCBImpl);
			}
		});
	}
}
