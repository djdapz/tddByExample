/**
 * Created by devondapuzzo on 10/3/17.
 */

open class Money(var amount: Int, var currency: String) {
    override fun equals(other: Any?): Boolean {
        val money: Money = other as Money
        return (money.amount == this.amount && money.currency == this.currency)
    }

    override fun hashCode(): Int = amount

    operator fun times(multiplier: Int): Money = Money(amount * multiplier, currency)

    companion object {
        fun dollar(amount: Int): Money = Money(amount, "USD")
        fun franc(amount: Int): Money = Money(amount, "CHF")
    }

    operator fun plus(addend: Money): Money = Money(addend.amount + amount, currency)
}