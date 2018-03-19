SlidingTicTacToe
================

![travis](https://travis-ci.org/ValheKouneli/SlidingTicTacToe.svg?branch=master)
![Code Coverage](https://img.shields.io/codecov/c/github/ValheKouneli/SlidingTicTacToe/master.svg)](https://codecov.io/github/ValheKouneli/SlidingTicTacToe/)

## Game rules

Sliding Tic Tac Toe (STTT from now on) is a two-player game and it is played on a board that consists of X vertical lines and X horizontal lines that form X*X intersections that serve as the **Field** of the fame.

!Image[rules/board.png]

One player controls red pieces and the other player black pieces. The aim of the game is to form a line of three pieces of one's own color either horizontally, vertically or diagonally on the Field.

In the beginning, all the pieces are on the sides of the field. For each line of the field, there are two pieces: one black on one side and one red on the other side. The beginning positions of the pieces are called **Bases**. The pieces on the vertical lines are called **Vertical Pieces** and the pieces on the horizontal lines are called **Horizontal Pieces**. They have different properties with will be explained later. Each player has the same amount of pieces (2*X) and also the same amount of Horizontal and Vertical Pieces as the other player. The colors alternate on the sides so that every other piece on one side is red and every other black.

!Image[rules/setup.png]

The players take turns moving one piece of their own color at a time. A piece can be moved according to the following rules:

* Horizontal Pieces can move horizontally on their own line, but not past another Horizontal Piece on the same line. They can stop on an empty intersection or on an empty Base.

* Correspondingly, Vertical Pieces can move vertically on their own line, but not past another Vertical Piece on the same line. They can stop on an empty intersection or on an emtpy Base.

* IF THERE ARE THREE PIECES OF A CERTAIN COLOR ON THE FIELD, MORE PIECES OF THAT COLOR CAN NOT BE MOVED INTO THE FIELD.

The first player to get three pieces in a row on the Field wins.
