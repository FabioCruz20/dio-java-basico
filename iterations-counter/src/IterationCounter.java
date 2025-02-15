import java.util.Locale;
import java.util.Scanner;

public class IterationCounter {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int param1 = scanner.nextInt();
        int param2 = scanner.nextInt();

        try {
            count(param1, param2);
        }
        catch (InvalidParametersException e) {
            System.out.println("The first parameter cannot be grater than the second one");
        }

        scanner.close();
    }

    public static void count(int param1, int param2) throws InvalidParametersException {
        
        if (param1 > param2) {
            throw new InvalidParametersException();
        }

        int intervalSize = param2 - param1;
        for (int i = 1; i <= intervalSize; i++) {
            System.out.println("Printing the number "+ i);
        }
    }
}
