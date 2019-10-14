package g144.Vinnik;

/** Implements predictable random. */
public class SpecialRandom implements NetworkRandom {

    /** In quality of random number always returns const 0.01.*/
    @Override
    public double getRandom() {
        return 0.01;
    }
}
