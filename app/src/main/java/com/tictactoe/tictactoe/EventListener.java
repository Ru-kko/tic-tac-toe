package com.tictactoe.tictactoe;

public interface EventListener<T> {
    public void emit(T event);
}
