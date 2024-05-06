package com.tictactoe.tictactoe

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class Manger @Inject constructor(private val gameBoard: Game) {

    private val winnerFlow: MutableStateFlow<States> = MutableStateFlow(States.Void)

    private val boardFlow: Flow<Array<Array<States>>> = callbackFlow {
        val subscription = gameBoard.subscribe { board ->
            trySend(board)
        }

        awaitClose {
            gameBoard.unSubscribe(subscription)
        }
    }
            

    fun getGame(): Flow<Array<Array<States>>> = boardFlow
    fun winner(): Flow<States> = winnerFlow

    fun retry() {
        gameBoard.reset()
    }
}