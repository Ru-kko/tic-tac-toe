package com.tictactoe.tictactoe

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class Manger @Inject constructor(private val gameBoard: Game) {
    private val boardFlow: Flow<Board> = callbackFlow {
        val subscription = gameBoard.subscribe { board ->
            trySend(board)
        }

        awaitClose {
            gameBoard.unSubscribe(subscription)
        }
    }

    fun getGame() = boardFlow.map { b -> b.cells.copyOf() }
    fun winner(): Flow<WinnerState> = boardFlow.map { b -> WinnerState(b.isFull, b.winner)}

    fun retry() {
        gameBoard.reset()
    }
    fun play(x: Int, y:Int) {
        gameBoard.playX(x, y)
    }

    data class WinnerState(val isFull: Boolean, val winner: States)
}