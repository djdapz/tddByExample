import Bank.Companion.reduce
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
        val reduced = reduce(sum, "USD")
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
        val result = Bank.reduce(sum, "USD")
        assertThat(result).isEqualTo(dollar(7))
    }

    @Test
    fun testReduceMoney() {
        val result = Bank.reduce(dollar(1), "USD")
        assertThat(result).isEqualTo(dollar(1))
    }
}