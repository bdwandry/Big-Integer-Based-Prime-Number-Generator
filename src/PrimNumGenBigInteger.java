import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class PrimNumGenBigInteger {
    static BigInteger baseNum = new BigInteger("2");
    static BigInteger mod2 = new BigInteger("2");
    static BigInteger mod0 = new BigInteger("0");


    static public boolean checkNun() throws InterruptedException {
        BigInteger modResult = baseNum.mod(mod2);

        if (modResult.equals(mod0)) {
            return false;
        }

        BigInteger staticNumChecker = new BigInteger("2");
        int compare = -1;
        while (compare != 0 ) {
            compare = staticNumChecker.compareTo(baseNum);

            if (compare < 0) {
                modResult = baseNum.mod(staticNumChecker);
                if (modResult.equals(mod0)) {
                    return false;
                }

                staticNumChecker = staticNumChecker.add(BigInteger.valueOf(1));
            }
        }

        return true;
    }

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        File file = new File(System.getProperty("user.home") + "/Desktop" + "/PrimeNumber.txt");
        PrintWriter out = new PrintWriter(file);
        while (true) {
            baseNum = baseNum.add(BigInteger.valueOf(1));
            boolean flag = checkNun();

            if (flag) {
                System.out.println("Prime Number: " + baseNum);
                out.println("Prime Number: " + baseNum);
                out.flush();
            }
        }
    }
}
