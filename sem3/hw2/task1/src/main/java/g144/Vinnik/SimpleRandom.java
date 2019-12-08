package g144.Vinnik;

import java.util.Random;

/** Imlements unpredictable random. */
public class SimpleRandom implements NetworkRandom {
    /** In quality of random number returns random number.*/
    @Override
    public double getRandom() {
        Random random = new Random();
        double result = random.nextDouble();
        int intPartResult = (int) result;
        return (result - intPartResult);
    }
}
