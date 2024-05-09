package com.tictactoe.tictactoe;

import java.util.UUID;

public interface Game {
    /*
     *  Await for board changes
     */
    public UUID subscribe(final EventListener<Board> listener);
    public void unSubscribe(final UUID id);

    public void reset();

    public void playX(Integer x, Integer y);
}
