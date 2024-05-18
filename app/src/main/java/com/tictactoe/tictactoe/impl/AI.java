package com.tictactoe.tictactoe.impl;

import android.util.Log;

import com.tictactoe.tictactoe.Board;
import com.tictactoe.tictactoe.States;

public class AI {
    private final static Integer MAX_DEEP = 6;

    private AI() {
    }

    private static Integer miniMax(Board board, Integer deep, Integer alpha, Integer beta) {
        Integer boardVal = switch (board.getWinner()) {
            case AI -> 10;
            case USER -> -10;
            case Void -> 0;
        };
        if (board.isFull() || board.getWinner() != States.Void || deep <= 0) {
            return boardVal;
        }

        if (board.getTurn() == States.AI) {
            return maximize(board, deep, alpha, beta);
        }
        return minimize(board, deep, alpha, beta);
    }

    private static int maximize(Board board, Integer deep, Integer alpha, Integer beta) {
        int hVal = Integer.MIN_VALUE;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Board copy = board.deepCopy();
                if (copy.play(col, row)) {
                    hVal = Math.max(hVal, miniMax(copy,
                            deep - 1, alpha, beta));
                    alpha = Math.max(alpha, hVal);
                    if (alpha >= beta) {
                        return hVal;
                    }
                }
            }
        }
        return hVal;
    }

    private static int minimize(Board board, Integer deep, Integer alpha, Integer beta) {
        int lVal = Integer.MAX_VALUE;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Board copy = board.deepCopy();
                if (copy.play(col, row)) {
                    lVal = Math.min(lVal, miniMax(copy,
                            deep - 1, alpha, beta));
                    beta = Math.min(beta, lVal);
                    if (beta <= alpha) {
                        return lVal;
                    }
                }
            }
        }
        return lVal;
    }

    public static Board getBestMove(Board board) {
        Board res = board;
        int bestWeight = Integer.MIN_VALUE;

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                Board copy = board.deepCopy();
                if (copy.play(x, y)) {
                    int weight = miniMax(copy, MAX_DEEP, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    Log.i("getBestMove", String.format("wh: %d, best: %d, %s", weight, bestWeight, weight > bestWeight));
                    if (weight > bestWeight) {
                        bestWeight = weight;
                        res = copy;
                    }
                }
            }
        }

        return res;
    }
}
