package pl.edu.pjwstk.mpr;

import org.junit.Test;

import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WeightedAverageTest {
    @Test
    public void should_create_class() {
        // assume
        var average = new WeightedAverage();

        // assert
        assertThat(average).isNotNull();
    }

    @Test
    public void should_calculate_simple_average() {
        // assume
        var average = new WeightedAverage("average/test_avg_1.txt");

        // act
        double avg = average.calculate();

        // assert
        assertThat(avg).isEqualTo(2.0);
    }

    @Test
    public void should_throw_when_file_does_not_exist() {
        // assue
        var average = new WeightedAverage("abstraction.txt");

        // assert
        assertThatThrownBy(() -> {
            average.calculate();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("File doesn't exist !!! ");
    }

    @Test
    public void should_throw_when_file_not_specifited() {
        // assume
        var average = new WeightedAverage();

        // assert
        try {
            average.calculate();
        } catch (Exception e) {
            assertThatThrownBy(() -> {
                throw e;
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("No file is specified.");
        }
    }

    @Test
    public void should_throw_when_content_of_a_file_has_wrong_format() {
        // assume
        var average = new WeightedAverage("average/test_avg_wrong_format.txt");

        // assert
        try {
            average.calculate();
        } catch (Exception e) {
            assertThatThrownBy(() -> {
                throw e;
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Wrong content");
        }
    }

    @Test
    public void should_calculate_average_of_large_file() { // max 1GB
        // assume
        var average = new WeightedAverage("average/test_avg_example_large_file.txt");

        // act
        double avg = average.calculate();

        // assert
        assertThat(avg).isEqualTo(4.27);
    }

    @Test
    public void should_calculate_average_example_1() {
        // assume
        var average = new WeightedAverage("average/test_avg_example1.txt");

        // act
        double avg = average.calculate();

        // assert
        assertThat(avg).isEqualTo(4.36);
    }

    @Test
    public void should_calculate_average_example_2() {
        // assume
        var average = new WeightedAverage("average/test_avg_example2.txt");

        // act
        double avg = average.calculate();

        // assert
        assertThat(avg).isEqualTo(2);
    }

    @Test
    public void should_calculate_average_example_3(){
        // assume
        var average = new WeightedAverage("average/test_avg_example3.txt");

        // act
        double avg = average.calculate();

        // assert
        assertThat(avg).isEqualTo(4);

    }

    @Test
    public void should_remove_trailing_zeros_1() {
        // assume
        var average = new WeightedAverage("average/test_avg_example_zeros_1.txt");

        // act
        String avg = average.resultAsString();

        // assert
        assertThat(avg).isEqualTo("1.22");
    }


    @Test
    public void should_remove_trailing_zeros_2() {
        // assume
        var average = new WeightedAverage("average/test_avg_example_zeros_2.txt");

        // act
        String avg = average.resultAsString();

        // assert
        assertThat(avg).isEqualTo("1.2");
    }

    @Test
    public void should_remove_trailing_zeros_3() {
        // assume
        var average = new WeightedAverage("average/test_avg_example_zeros_3.txt");

        // act
        String avg = average.resultAsString();

        // assert
        assertThat(avg).isEqualTo("1");
    }
}





