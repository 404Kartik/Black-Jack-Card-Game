package view;


import java.util.LinkedList;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;
/**
 * 
 * Skeleton/Partial example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
   public static final Logger logger = Logger.getLogger(GameEngineCallbackImpl.class.getName());

   // utility method to set output level of logging handlers
   public static Logger setAllHandlers(Level level, Logger logger, boolean recursive)
   {
      // end recursion?
      if (logger != null)
      {
         logger.setLevel(level);
         for (Handler handler : logger.getHandlers())
            handler.setLevel(level);
         // recursion
         setAllHandlers(level, logger.getParent(), recursive);
      }
      return logger;
   }

   public GameEngineCallbackImpl()
   {
      // NOTE can also set the console to FINE in %JRE_HOME%\lib\logging.properties
      setAllHandlers(Level.INFO, logger, true);
   }

   @Override
   public void nextCard(Player player, PlayingCard card, GameEngine engine)
   {
	
	   StringBuilder str = new StringBuilder("");
	      str.append(String.format("Card Dealt to %s .. ", player.getPlayerName()));
	      str.append(card.toString());
      // intermediate results logged at Level.FINE
      logger.log(Level.INFO, str.toString());
      // TODO: complete this method to log results
   }

   @Override
   public void result(Player player, int result, GameEngine engine)
   {
	   StringBuilder str = new StringBuilder("");
	      str.append(String.format("%s, final result=%d", player.getPlayerName(), player.getResult()));
	      logger.log(Level.INFO, str.toString());
      // final results logged at Level.INFO
     
    
   }

@Override
public void bustCard(Player player, PlayingCard card, GameEngine engine) {
	StringBuilder str = new StringBuilder("");
	str.append(String.format("Card Dealt to %s .. ", player.getPlayerName()));
    str.append(card.toString());
    str.append(" ... YOU BUSTED!");
    logger.log(Level.INFO, str.toString());
	
	
}

@Override
public void nextHouseCard(PlayingCard card, GameEngine engine) {
	StringBuilder str = new StringBuilder("");
	str.append(String.format("Card Dealt to House .. %s", card.toString()));
	logger.log(Level.INFO, str.toString());
	
	
}

@Override
public void houseBustCard(PlayingCard card, GameEngine engine) {
	StringBuilder str = new StringBuilder("");
	str.append(String.format("Card Dealt to House .. %s ... HOUSE BUSTED!", card.toString()));
	logger.log(Level.INFO, str.toString());
	
}

@Override
public void houseResult(int result, GameEngine engine) {
	
	logger.log(Level.INFO, String.format("House, final result=%d", result));

	StringBuilder str = new StringBuilder("Final Player Results\n");

	for (Player player : engine.getAllPlayers()) {
		str.append(player.toString());
	}

	logger.log(Level.INFO, str.toString());
	
}

  
}

