import java.util.*

/**
 * Created by devondapuzzo on 10/3/17.
 */

class Bank {
    companion object{
        private var rates = Hashtable<Pair, Int>()
        fun reduceBank(source: Expression, to: String): Money = source.reduce(to)
        fun addRate(from: String, to: String, rate: Int) {
            rates.put(Pair(from, to), rate)
        }

        fun getRate(from: String, to: String) : Int? {
            if(from == to){
                return 1
            }else{
                return rates[Pair(from ,to)]
            }
        }
    }
}