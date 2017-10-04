/**
 * Created by devondapuzzo on 10/3/17.
 */

open class Sum(val augend: Money, val addend: Money) : Expression {
    override fun reduce(to: String): Money = Money(augend.amount + addend.amount, to)

}

