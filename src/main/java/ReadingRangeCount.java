import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReadingRangeCount {
  private static final int MIN_LEN_FOR_RANGE = 2;
  private static final String COMMA_SEP = ",";
  private static final String HYPHEN_SEP = "-";

  public static List<String> findNoOfReadingsInRange(final int... curSamples) {
    if (curSamples.length < MIN_LEN_FOR_RANGE) {
      return null;
    }
    return detectReadings(curSamples);
  }

  private static List<String> detectReadings(final int[] curSamples) {
    List<Integer> samplesList = getSortedList(curSamples);
    return findContinuousRanges(samplesList);
  }

  private static List<String> findContinuousRanges(final List<Integer> samplesList) {
    print("Range, Readings");

    List<String> outputArray = new ArrayList<>();
    List<List<Integer>> continuousSamples = new ArrayList<>();

    findContiuousRangeOfSamples(samplesList, continuousSamples);

    continuousSamples.forEach(samplesRange -> findNoOfReadings(samplesRange, outputArray));

    return outputArray;
  }

  private static void findContiuousRangeOfSamples(final List<Integer> samplesList,
      final List<List<Integer>> continuousSamples) {
    List<Integer> continuouSample = new ArrayList<>();
    Integer previousSample = samplesList.get(0);
    for (int iterator = 0; iterator < samplesList.size(); iterator++) {
      Integer sample = samplesList.get(iterator);
      if (previousSample < (sample - 1)) {
        continuousSamples.add(continuouSample);
        continuouSample = new ArrayList<>();
      }
      continuouSample.add(sample);
      previousSample = sample;
    }
    continuousSamples.add(continuouSample);
  }

  private static void findNoOfReadings(final List<Integer> range, final List<String> outputArray) {
    String continuousRange = null;
    int rangeLength = range.size();
    if (rangeLength >= MIN_LEN_FOR_RANGE) {
      StringBuilder builder = new StringBuilder();
      builder.append(range.get(0));
      builder.append(HYPHEN_SEP);
      builder.append(range.get(rangeLength - 1));
      builder.append(COMMA_SEP);
      builder.append(rangeLength);
      continuousRange = builder.toString();

      print(continuousRange);
      outputArray.add(continuousRange);
    }
  }

  private static void print(final String string) {
    System.out.println(string);
  }

  private static List<Integer> getSortedList(final int[] curSamples) {
    List<Integer> samplesList = Arrays.stream(curSamples).boxed().collect(Collectors.toList());
    Collections.sort(samplesList);
    return samplesList;
  }

}
