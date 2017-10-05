/**
 * Created by devondapuzzo on 10/3/17.
 */

open class Sum(val augend: Expression, val addend: Expression) : Expression {
    override fun reduce(to: String): Money {
        val amount = augend.reduce(to).amount + addend.reduce(to).amount
        return Money(amount, to)
    }
}

