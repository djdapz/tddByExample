package com.devon.expression

/**
 * Created by devondapuzzo on 10/3/17.
 */

@Suppress("EqualsOrHashCode")
open class Money(var amount: Int, var currency: String) : Expression {
    override fun reduce(to: String): com.devon.expression.Money {
        val rate = com.devon.bank.Bank.Companion.getRate(currency, to) ?: return com.devon.expression.Money(amount, to)
        return com.devon.expression.Money(amount / rate, to)
    }

    override operator fun times(multiplier: Int): Expression = com.devon.expression.Money(amount * multiplier, currency)

    override operator fun plus(addend: Expression): Expression = Sum(addend, this)

    override fun equals(other: Any?): Boolean {
        val money: com.devon.expression.Money = other as com.devon.expression.Money
        return (money.amount == this.amount && money.currency == this.currency)
    }

    companion object {
        fun dollar(amount: Int): com.devon.expression.Money = com.devon.expression.Money(amount, "USD")
        fun franc(amount: Int): com.devon.expression.Money = com.devon.expression.Money(amount, "CHF")
    }
}