/**
 * Created by devondapuzzo on 10/3/17.
 */

open class Money(var amount: Int, var currency: String) : Expression {
    override fun reduce(to: String): Money = this

    operator fun times(multiplier: Int): Expression = Money(amount * multiplier, currency)

    operator fun plus(addend: Money): Expression = Sum(addend, this)

    override fun hashCode(): Int = amount

    override fun equals(other: Any?): Boolean {
        val money: Money = other as Money
        return (money.amount == this.amount && money.currency == this.currency)
    }

    companion object {
        fun dollar(amount: Int): Money = Money(amount, "USD")
        fun franc(amount: Int): Money = Money(amount, "CHF")
    }
}