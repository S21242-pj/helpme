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

            String line = null;      // WAZNY WHILE (przypisanie i wyrazenie)
            //line = fileReader.readLine()) dopoki nie jest nulem wykonuje sie
            while ((line = fileReader.readLine()) != null){
                System.out.println("Printed line" + line);

                //line.split("/");
                //Long.parse

                // parse w_i and x_i
                long wi = 0, xi = 0;
                w_sum += wi;
                wx_sum += wi*xi;

            }

            return wx_sum / w_sum;

            // formatowanie??

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
