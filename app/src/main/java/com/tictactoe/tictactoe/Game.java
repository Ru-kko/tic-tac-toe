package com.tictactoe.tictactoe;

import java.util.UUID;

public interface Game {
    /*
     * should emit the winner
     */
    public UUID listenWinner(final EventListener<States> listener);
    public  void  stopListenWinners(final UUID id);

    /*
     *  Await for board changes
     */
    public UUID subscribe(final EventListener<States[][]> listener);
    public void unSubscribe(final UUID id);

    /*
     * Should emit User or AI, if someone won or else void if the game continue
     */
    public States checkWinner();


    public void reset();

    public void playX(Integer x, Integer y);
    public static States[][] getVoidBoard() {
        return new States[][]{
                {States.AI, States.Void, States.Void},
                {States.Void, States.Void, States.Void},
                {States.Void, States.Void, States.Void}
        };
    }
}
