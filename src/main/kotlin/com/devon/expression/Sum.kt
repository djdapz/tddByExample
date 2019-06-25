package com.devon.expression

/**
 * Created by devondapuzzo on 10/3/17.
 */

open class Sum(val augend: Expression, val addend: Expression) : Expression {
    override fun times(multiplier: Int): Expression {
        return com.devon.expression.Sum(augend * multiplier, addend * multiplier)
    }

    override fun reduce(to: String): Money {
        val amount = augend.reduce(to).amount + addend.reduce(to).amount
        return Money(amount, to)
    }

    override operator fun plus(addend: Expression): Expression = com.devon.expression.Sum(addend, this)

}

