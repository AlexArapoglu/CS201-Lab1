import java.io.*;

public class Test {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                boolean isPrime = isPrime(number);
                String result = isPrime ? "Prime" : "Not";
                writer.write(result + "\n");
            }

            reader.close();
            writer.close();

            System.out.println("Output written to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

