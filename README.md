
# Tic-Tac-Toe

This is an implementation of the classic **Tic-Tac-Toe** game. I am sure this game brings back a wave of nostalgia for many of us. Whenever we got bored during our long Maths lectures at school, we would turn to the last page of our notebooks and start playing this game with our beloved childhood friends.

I used Java Swing to create this project. The game window is created using JFrame. To show the game status, such as whose turn it is, the winning message or whether the game ends in a tie, I used JPanel and to display the game board, I used a 3x3 grid of JButtons. The game is interactive due to the use of the ActionListener.

The game starts with player X and the turns alternate between X and O. As soon as a player clicks on an empty tile, the turn count is incremented and the checkWinner() method is called to check if there is a winning combination.

If a player wins, the three winning buttons change color and the winning message is displayed by a method named setWinner() which is called inside the method checkWinner(). The checkWinner() method also checks for a tie. If the number of turns are already 9, the method setTie is called which changes color of all the buttons, declares a tie and ends the game.

One of the biggest difficulties I faced while developing this project was repeatedly forgetting to put parentheses  after method names. I ended up wasting a significant amount of time debugging this tiny mistake.

![Gif](https://media.tenor.com/bd9kcb69On4AAAAM/doug-maclean-doug.gif)
