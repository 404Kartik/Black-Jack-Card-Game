TO RUN MY PROGRAM:

RUN FROM TestClientGUI.


View.MainFrame creates the main frame and puts all of the other elements in it.

View.BottomPanel holds a label that is used as the status bar.

View.CardPanel contain is responsible for displaying the cards.

View.GameEngineCallbackGUI is responsible for drawing the cards and giving us the results.

View.MiddlePanel is responsible for holding the CardPanel and the SummaryPanel.

View.SummaryPanel is responsible for displaying the basic stats of the players.

View.TopPanel is responsible for holding the tool bar with all of the button etc.

PlayerState is responsible for holding details about the player state.


All of the listeners have been placed in seperate classes and are named according to their 
Respective functions.