package pl.edu.pjwstk.mpr;

import java.io.*;

public class WeightedAverage {
    private final File testFile;


    public WeightedAverage(String filePath) {
        this.testFile = new File("./src/test/resources/" + filePath);
    }

    public WeightedAverage() {
        this.testFile = null;
    }

    public double calculate() {
        try {
            if (testFile == null) {
                throw new IllegalArgumentException("no file");
            }
            if (!testFile.exists()) {
                throw new IllegalArgumentException("File does not exits");
            }

            //var is = new FilterInputStream(testFile);
            var fileReader = new BufferedReader(new FileReader(testFile));
            long w_sum =0, wx_sum = 0;
            String line = null;

            String wi_str, xi_str;

            while ((line = fileReader.readLine()) != null){
                System.out.println("Printed line: " + line);

                line.split("/");

                try {
                    wi_str = line.split("/")[0];
                    xi_str = line.split("/")[1];
                } catch (ArrayIndexOutOfBoundsException a) {
                    throw new ArrayIndexOutOfBoundsException(("Something is wrong")); // later reedit output
                }

                long wi = 0, xi = 0;
                try {
                    wi = Long.parseLong(wi_str);
                    xi = Long.parseLong(xi_str);
                } catch (NumberFormatException b) {
                    throw new NumberFormatException("Number in this file, can't be formatted to long, check it");
                }

                w_sum += wi;
                wx_sum += wi*xi;
            }

            // pattern avg weight
            return wx_sum / w_sum;


        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
