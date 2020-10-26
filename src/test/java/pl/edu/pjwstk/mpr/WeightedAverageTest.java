package pl.edu.pjwstk.mpr;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WeightedAverageTest {
    @Test
    public void should_create_class() {
        var average = new WeightedAverage();

        assertThat(average).isNotNull();
    }

    @Test
    public void should_calculate_simple_average() {
        // assume
        var average = new WeightedAverage("average/test_avg_1.txt");

        // act
        double avg = average.calculate();

        // assert
        assertThat(avg).isEqualTo(4.0);
    }

    @Test
    public void should_throw_when_file_does_not_exist() {

        var average = new WeightedAverage("abstraction.txt");

        assertThatThrownBy(() -> {
            average.calculate();
            }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("File doesn't exist !!! ");
    }

    @Test
    public void should_throw_when_file_not_specifited() {

        var average = new WeightedAverage();

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

        var average = new WeightedAverage("average/test_avg_wrong_format.txt");

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
    public void should_calculate_average_of_large_file() { // 1GB

//        var avreage = new WeightedAverage("average")

    }

    @Test
    public void should_calculate_average_example_1() {
    }

    @Test
    public void should_calculate_average_example_2() {
    }

    @Test
    public void should_remove_trailing_zeros_1() {
    }


    @Test
    public void should_remove_trailing_zeros_2() {
    }

    @Test
    public void should_remove_trailing_zeros_3() {
    }

}





