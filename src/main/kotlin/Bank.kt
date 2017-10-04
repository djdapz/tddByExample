/**
 * Created by devondapuzzo on 10/3/17.
 */

class Bank {
    companion object{
        fun reduce(source: Expression, to: String): Money = source.reduce(to)
    }
}