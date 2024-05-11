package com.tictactoe.tictactoe;

public interface Board {
    /*
     Should return true if is a playable moviment
     */
    Boolean play(Integer x, Integer y);

    States getWinner();

    States[][] getCells();

    /*
    Should return true if all cells are occupied
     */
    Boolean isFull();

    States getTurn();

    Board deepCopy();

    static States[][] getVoidBoard() {
        return new States[][]{
                {States.Void, States.Void, States.Void},
                {States.Void, States.Void, States.Void},
                {States.Void, States.Void, States.Void}
        };
    }
}
