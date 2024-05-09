package com.tictactoe.tictactoe;

public class Board {
    private States winner;
    private States turn;
    private final States[][] cellData;
    private Integer space = 9;

    public Board() {
        this.turn = States.USER;
        this.winner = States.Void;
        this.cellData = Board.getVoidBoard();
    }

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

    public States getWinner() {
        return this.winner;
    }

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

    public Boolean isFull() {
        return this.space <= 0;
    }

    public static States[][] getVoidBoard() {
        return new States[][]{
                {States.Void, States.Void, States.Void},
                {States.Void, States.Void, States.Void},
                {States.Void, States.Void, States.Void}
        };
    }
}
