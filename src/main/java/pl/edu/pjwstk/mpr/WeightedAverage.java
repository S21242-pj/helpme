package pl.edu.pjwstk.mpr;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
            double w_sum = 0, wx_sum = 0;
            String line = null;

            String wi_str, xi_str;

            while ((line = fileReader.readLine()) != null) {
                //System.out.println("Printed line: " + line);

                line.split("/");

                try {
                    wi_str = line.split("/")[0];
                    xi_str = line.split("/")[1];
                } catch (ArrayIndexOutOfBoundsException a) {
                    throw new ArrayIndexOutOfBoundsException(("Something is wrong")); // later reedit output
                }

                double wi = 0, xi = 0;
                try {
                    wi = Long.parseLong(wi_str);
                    xi = Long.parseLong(xi_str);
                } catch (NumberFormatException b) {
                    throw new NumberFormatException("Something is wrong");
                }

                w_sum += wi;
                wx_sum += wi * xi;
            }

            // pattern avg weight
            BigDecimal resultAsBigDecimal = new BigDecimal((double) wx_sum / (double) w_sum).setScale(2, RoundingMode.HALF_UP);
            return resultAsBigDecimal.doubleValue();

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    String removeTraillingZeroes(String result){
        char lastCharacter = result.charAt(result.length() - 1);
        if (lastCharacter == '0' && result.contains(".")) {
            return removeTraillingZeroes(result.substring(0, result.lastIndexOf('0')));
        }
        if (lastCharacter == '.') {
            return  result.replace(".", "");
        }
        return result;
    }

    public String resultAsString(){
        var result = calculate();

        String absStringResult = String.format("%.2f",result);

        return removeTraillingZeroes(absStringResult);
    }

}
