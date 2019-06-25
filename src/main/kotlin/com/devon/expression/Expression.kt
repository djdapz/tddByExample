package com.devon.expression

/**
 * Created by devondapuzzo on 10/3/17.
 */

open interface Expression {
    fun reduce(to: String): Money
    operator fun plus(addend: Expression): Expression
    operator fun times(multiplier: Int): Expression
}
