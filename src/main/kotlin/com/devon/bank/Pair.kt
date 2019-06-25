package com.devon.bank

/**
 * Created by devondapuzzo on 10/4/17.
 */
class Pair(val from:String, val to:String){

    override fun equals(other: Any?): Boolean {
        other as com.devon.bank.Pair
        return other.from == from && other.to == to
    }

    override fun hashCode(): Int = 1
}