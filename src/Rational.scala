/**
  * Created by suvasish on 25-Oct-16.
  */
class Rational(n: Int, d: Int) {
    require(d != 0)
    private val g = gcd(n.abs, d.abs)
    val numer: Int = n / g
    val denom: Int = d / g

    def this(n: Int) = this(n, 1) // auxiliary constructor

    override def toString = if(denom == 1) numer.toString else numer + "/" + denom

    private def gcd(a: Int, b: Int): Int =
        if(b == 0) a else gcd(b, a % b)

    def + (that: Rational): Rational =
        new Rational(
            numer * that.denom + that.numer * denom,
            denom * that.denom
        )

    def * (that: Rational): Rational =
        new Rational(
            numer * that.numer, denom * that.denom
        )

    def lessThan(that: Rational) =
        numer * that.denom < that.numer * denom

    def max(that: Rational) =
        if(this.lessThan(that)) that else this
}
