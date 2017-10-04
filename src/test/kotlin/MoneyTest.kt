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
    fun shouldMultiplyFrancs() {
        val five: Money = franc(5)
        assertThat(franc(10)).isEqualTo(five * 2)
        assertThat(franc(15)).isEqualTo(five * 3)
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
        val sum: Expression = Money.dollar(5) + Money.dollar(5)
        val bank: Bank = Bank()
        val reduced: Money = bank.reduce(sum, "USD")
        assertThat(reduced).isEqualTo(dollar(10))
    }
}