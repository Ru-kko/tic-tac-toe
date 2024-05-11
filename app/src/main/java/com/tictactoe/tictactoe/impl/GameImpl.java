package com.tictactoe.tictactoe.impl;

import com.tictactoe.tictactoe.Board;
import com.tictactoe.tictactoe.EventListener;
import com.tictactoe.tictactoe.Game;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameImpl implements Game {
    private Board board;
    final private Map<UUID, EventListener<Board>> listeners;

    public GameImpl() {
        this.board = new BoardImpl();
        listeners = new HashMap<>();
    }

    private void emit() {
        for (EventListener<Board> listener : listeners.values()) {
            listener.emit(this.board);
        }
    }

    @Override
    public void reset() {
        this.board = new BoardImpl();
        this.emit();
    }

    @Override
    public void playX(Integer x, Integer y) {
        if (board.play(x, y)) { // * check if was a successful moviment
            // TODO make AI movement
            this.emit();
        }
    }

    @Override
    public UUID subscribe(EventListener<Board> listener) {
        UUID res = UUID.randomUUID();
        this.listeners.put(res, listener);
        listener.emit(board);
        return res;
    }

    @Override
    public void unSubscribe(UUID id) {
        this.listeners.remove(id);
    }
}
