import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimNumGenBigInteger {
    static BigInteger baseNum = new BigInteger("2");
    static BigInteger mod2 = new BigInteger("2");
    static BigInteger mod0 = new BigInteger("0");
    static BigInteger counter = new BigInteger("0");

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
        PrintWriter out = null;
        if (file.isFile()) {
            if (file.length() != 0) {
                System.out.print("File Already Exit. Would you like to continue? <Yes> or <No>: ");
                Scanner in = new Scanner(System.in);
                String flag = in.nextLine();

                while (!(flag.equalsIgnoreCase("Yes") || flag.equalsIgnoreCase("No"))) {
                    System.out.println("INVALID ANSWER. TYPE YES OR NO!");
                    System.out.print("Enter 'Yes' or 'No': ");
                    flag = in.nextLine();
                }

                if (flag.equalsIgnoreCase("Yes")) {
                    ArrayList<String> tempArr = new ArrayList<>();
                    Scanner lastLine = new Scanner(file);
                    while (lastLine.hasNextLine()) {
                        String specificLine = lastLine.nextLine();
                        tempArr.add(specificLine);
                    }

                    out = new PrintWriter(file);
                    for (int i = 0; i < tempArr.size(); i++) {
                        out.println(tempArr.get(i));
                        out.flush();
                    }
                    String[] splitString = tempArr.get(tempArr.size() - 1).split(" ");
                    counter = new BigInteger(splitString[0].substring(0, splitString[0].length() - 1));
                    baseNum = new BigInteger(splitString[8]);

                } else {
                    out = new PrintWriter(file);

                    long startTime = System.nanoTime();
                    long endTime = System.nanoTime();
                    long timeElapsed = endTime - startTime;
                    counter = counter.add(BigInteger.valueOf(1));
                    out.println(counter + ". Time To Calculate: " + (timeElapsed/1000000 ) + " ms; Prime Number: " + baseNum);
                    out.flush();
                }
            } else {
                out = new PrintWriter(file);

                long startTime = System.nanoTime();
                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;
                counter = counter.add(BigInteger.valueOf(1));
                out.println(counter + ". Time To Calculate: " + (timeElapsed/1000000 ) + " ms; Prime Number: " + baseNum);
                out.flush();
            }
        } else {
            out = new PrintWriter(file);

            long startTime = System.nanoTime();
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            counter = counter.add(BigInteger.valueOf(1));
            out.println(counter + ". Time To Calculate: " + (timeElapsed/1000000 ) + " ms; Prime Number: " + baseNum);
            out.flush();
        }

        while (true) {
            baseNum = baseNum.add(BigInteger.valueOf(1));
            long startTime = System.nanoTime();
            boolean flag = checkNun();
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;

            if (flag) {
                counter = counter.add(BigInteger.valueOf(1));
                System.out.println(counter + ". Time To Calculate: " + (timeElapsed/1000000 ) + " ms; Prime Number: " + baseNum);
                out.println(counter + ". Time To Calculate: " + (timeElapsed/1000000 ) + " ms; Prime Number: " + baseNum);
                out.flush();
            }
        }
    }
}
