import Bank.Companion.addRate
import Bank.Companion.getRate
import Bank.Companion.reduceBank
import Money.Companion.dollar
import Money.Companion.franc
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class MoneyTest {
    @Test
    fun shouldMultiply() {
        val five: Money = dollar(5)
        assertThat(dollar(10)).isEqualTo(five * 2)
        assertThat(dollar(15)).isEqualTo(five * 3)
    }

    @Test
    fun shouldBeAbleToAssertEquality() {
        assertTrue(dollar(5) == (dollar(5)))
        assertFalse(dollar(5) == (dollar(6)))
        assertFalse(dollar(5) == (franc(5)))
    }

    @Test
    fun testCurrency() {
        assertThat("USD").isEqualTo(dollar(1).currency)
        assertThat("CHF").isEqualTo(franc(1).currency)
    }

    @Test
    fun testSimpleAddition() {
        val sum  = dollar(5) + dollar(5)
        val reduced = reduceBank(sum, "USD")
        assertThat(reduced).isEqualTo(dollar(10))
    }

    @Test
    fun testPlusReturnsSum() {
        val five = dollar(5)
        val result = five + five
        val sum = result as Sum
        assertThat(five).isEqualTo(sum.addend)
        assertThat(five).isEqualTo(sum.augend)
    }

    @Test
    fun testReduceSum() {
        val sum = Sum(dollar(3), dollar(4))
        val result = reduceBank(sum, "USD")
        assertThat(result).isEqualTo(dollar(7))
    }

    @Test
    fun testReduceMoney() {
        val result = reduceBank(dollar(1), "USD")
        assertThat(result).isEqualTo(dollar(1))
    }

    @Test
    fun testReduceMoneyDifferentCurrency() {
        addRate("CHF", "USD", 2)
        var result = reduceBank(franc(2), "USD")
        assertThat(dollar(1)).isEqualTo(result)

        addRate("CHF", "USD", 3)
        result = reduceBank(franc(6), "USD")
        assertThat(dollar(2)).isEqualTo(result)
    }

    @Test
    fun testIdentityRate() {
        assertThat(getRate("USD", "USD")).isEqualTo(1)
    }

    @Test
    fun testMixedAddition() {
        val fiveBucks = dollar(5)
        val tenFrancs = franc(10)

        addRate("CHF", "USD", 2)
        val result = reduceBank(fiveBucks + tenFrancs, "USD")

        assertThat(result).isEqualTo(dollar(10))
    }
}