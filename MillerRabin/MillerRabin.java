import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
public class MillerRabin {

    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger THREE = new BigInteger("3");
    
     private static BigInteger genRandom(BigInteger bottom, BigInteger top) { //generate a random int
        Random rnd = new Random();
        BigInteger res;
        do {
            res = new BigInteger(top.bitLength(), rnd);
        } while (res.compareTo(bottom) < 0 || res.compareTo(top) > 0);
        return res;
    }

    public static boolean isPrime(BigInteger n, int k) {
        if (n.compareTo(THREE) < 0)      return true;
        int s = 0;
        BigInteger d = n.subtract(ONE); // n-1
        while (d.mod(TWO).equals(ZERO)) { 
            s++;                          
            d = d.divide(TWO);            
        }
        for (int i = 0; i < k; i++) {    //LOOP: repeat k times
            BigInteger a = genRandom(TWO, n.subtract(ONE)); //?
            BigInteger x = a.modPow(d, n);  //x = a^d mod n
            if (x.equals(ONE) || x.equals(n.subtract(ONE))) // if x=1 or x = n-1, then do next LOOP
                continue;
            int r = 1;
            for (; r < s; r++) { // for r = 1..s-1
                x = x.modPow(TWO, n);  //x = x ^ 2 mod n 
                if (x.equals(ONE))     //if x = 1, return false (composite
                    return false; 
                if (x.equals(n.subtract(ONE))) //if x= n-1, look at the next a
                    break;
            }            if (r == s) // None of the steps made x equal n-1.
                return false; //we've exhausted all of our a values, probably composite
        } return true; //probably prime
    }
   
   
    public static void main(String args[]) { 
          
        int k = 4; // Number of iterations 
      
        System.out.println("enter a number"); 
             Scanner keyboard = new Scanner (System.in);
            BigInteger n = keyboard.nextBigInteger();

            if (!isPrime(n, k)){ 
                System.out.print(n + " is composite"); }
            else{
                System.out.println(n + " is prime");}
    } 
} 
    