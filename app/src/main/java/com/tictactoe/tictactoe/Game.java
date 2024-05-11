package com.tictactoe.tictactoe;

import java.util.UUID;

public interface Game {
    /*
     *  Await for board changes
     */
    UUID subscribe(final EventListener<Board> listener);
   void unSubscribe(final UUID id);

    void reset();

    void playX(Integer x, Integer y);
}
