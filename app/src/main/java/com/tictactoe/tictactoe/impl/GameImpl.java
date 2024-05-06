package com.tictactoe.tictactoe.impl;


import com.tictactoe.tictactoe.EventListener;
import com.tictactoe.tictactoe.Game;
import com.tictactoe.tictactoe.States;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

public class GameImpl implements Game {
    private final States[][] board;
    final private Map<UUID, EventListener<States[][]>> listeners;
    final private Map<UUID, EventListener<States>> winnerListeners;

    public GameImpl(States[][] board) {
        this.board = board;
        listeners = new HashMap<>();
        winnerListeners = new HashMap<>();
    }

    private void sendWinners(States winner) {
        for (EventListener<States> listener: winnerListeners.values()) {
            listener.emit(winner);
        }
    }

    private void emit() {
        for (EventListener<States[][]> listener: listeners.values()) {
            listener.emit(this.board);
        }
    }

    @Override
    public States checkWinner() {
        return null;
    }

    @Override
    public void reset() {
        for (States[] states : board) {
            Arrays.fill(states, States.Void);
        }
        this.emit();
        this.sendWinners(States.Void);
    }

    @Override
    public void playX(Integer x, Integer y) {

    }
    @Override
    public UUID listenWinner(EventListener<States> listener) {
        UUID res = UUID.randomUUID();
        this.winnerListeners.put(res, listener);
        return res;
    }
    @Override
    public void stopListenWinners(UUID id) {
        this.winnerListeners.remove(id);
    }

    @Override
    public UUID subscribe(EventListener<States[][]> listener) {
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
