import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
public class ReadingRangeCountTest {
  @Test
  public void testRange() {
    assertNull(ReadingRangeCount.findNoOfReadingsInRange());
    assertNull(ReadingRangeCount.findNoOfReadingsInRange(4));
    assertNotEquals("4-5,3", ReadingRangeCount.findNoOfReadingsInRange(4, 5).get(0));
    assertEquals("4-5,2", ReadingRangeCount.findNoOfReadingsInRange(4, 5).get(0));
    assertEquals("4-7,4", ReadingRangeCount.findNoOfReadingsInRange(4, 5, 6, 7).get(0));
    List<String> actualOutput = ReadingRangeCount.findNoOfReadingsInRange(3, 3, 5, 4, 10, 11, 12);
    assertEquals("3-5,4", actualOutput.get(0));
    assertEquals("10-12,3", actualOutput.get(1));
    List<String> actualOutput1 = ReadingRangeCount.findNoOfReadingsInRange(5, 4, 10, 11, 12);
    assertEquals("4-5,2", actualOutput1.get(0));
    assertEquals("10-12,3", actualOutput1.get(1));
    List<String> actualOutput2 = ReadingRangeCount.findNoOfReadingsInRange(4, 10, 11, 12);
    assertEquals("10-12,3", actualOutput2.get(0));
  }
}
