package com.tictactoe.tictactoe.impl;

import com.tictactoe.tictactoe.Board;
import com.tictactoe.tictactoe.States;

import java.util.Arrays;

public class BoardImpl implements Board {
    private States winner;
    private States turn;
    private final States[][] cellData;
    private Integer space = 9;

    public BoardImpl() {
        this.turn = States.USER;
        this.winner = States.Void;
        this.cellData = Board.getVoidBoard();
    }

    private BoardImpl(States winner, States turn, States[][] cellData, Integer space) {
        this.winner = winner;
        this.turn = turn;
        this.cellData = cellData;
        this.space = space;
    }

    @Override
    public Boolean play(Integer x, Integer y) {
        if (cellData[y][x] != States.Void || this.winner != States.Void) {
            return false;
        }

        this.cellData[y][x] = this.turn;
        if (this.checkWinner(x, y)) {
            this.winner = turn;
        }
        this.next();
        space--;

        return true;
    }

    @Override
    public States getWinner() {
        return this.winner;
    }

    @Override
    public States[][] getCells() {
        return this.cellData;
    }

    private Boolean checkWinner(Integer x, Integer y) {
        States player = this.cellData[y][x];
        if (player == States.Void) return false;

        boolean res = true;
        // * Check horizontal
        for (States state : this.cellData[y]) {
            if (state != player) {
                res = false;
                break;
            }
        }
        if (res) return true;

        // * check vertical
        res = true;
        for (int i = 0; i < 3; i++) {
            if (cellData[i][x] != player) {
                res = false;
                break;
            }
        }
        if (res) return true;
        // * check diagonal

        return checkDiagonals(player);
    }

    private void next() {
        switch (this.turn) {
            case USER:
                turn = States.AI;
                return;
            case AI:
            case Void:
                turn = States.USER;
        }
    }

    private Boolean checkDiagonals(States player) {
        boolean res = true;
        for (int i = 0; i < 3; i++) {
            if (cellData[i][i] != player) {
                res = false;
                break;
            }
        }
        if (res) return true;


        res = true;
        for (int i = 0; i < 3; i++) {
            if (cellData[i][2 - i] != player) {
                res = false;
                break;
            }
        }

        return res;
    }

    @Override
    public Boolean isFull() {
        return this.space <= 0;
    }

    @Override
    public Board deepCopy() {
        States[][] copiedCellData = new States[3][3];
        for (int i = 0; i < cellData.length; i++) {
            copiedCellData[i] = Arrays.copyOf(cellData[i], cellData[i].length);
        }
        return new BoardImpl(winner, turn, copiedCellData, space);
    }
}
