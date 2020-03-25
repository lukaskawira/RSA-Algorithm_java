import java.math.BigInteger;
import java.security.SecureRandom;

public class Utils {
	//Encoding and decoding function declaration -- given in the question paper --
	public static BigInteger encode(final String text) {
			return new BigInteger(text, Character.MAX_RADIX);
			}
	
	public static String decode(final BigInteger number) {
			return number.toString(Character.MAX_RADIX);
			}
	
	//Pollards Rho Algorithm reference from -- https://introcs.cs.princeton.edu/java/99crypto/PollardRho.java.html --
	private final static BigInteger ZERO = new BigInteger("0");
    private final static BigInteger ONE  = new BigInteger("1");
    private final static BigInteger TWO  = new BigInteger("2");
    private final static SecureRandom random = new SecureRandom();

    public static BigInteger rho(BigInteger N) {
        BigInteger divisor;
        BigInteger c  = new BigInteger(N.bitLength(), random);
        BigInteger x  = new BigInteger(N.bitLength(), random);
        BigInteger xx = x;

        // check divisibility by 2
        if (N.mod(TWO).compareTo(ZERO) == 0) return TWO;

        do {
            x  =  x.multiply(x).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            divisor = x.subtract(xx).gcd(N);
        } while((divisor.compareTo(ONE)) == 0);

        return divisor;
    }
    
    //This part of code below is unused in the process but I still include it since i took
    //reference of the whole code. 
    
    /*public static void factor(BigInteger N) {
        if (N.compareTo(ONE) == 0) return;
        
        if (N.isProbablePrime(20)) { 
        	System.out.println(N); return; 
        	}
        
        BigInteger divisor = rho(N);
        factor(divisor);
        factor(N.divide(divisor));
    }*/
    
    //End of pollards rho algorithm.
}
