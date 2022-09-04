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

    List<String> actualOutput = ReadingRangeCount.findNoOfReadingsInRange(3, 3, 5, 4, 7, 8, 9);
    assertEquals("3-5,4", actualOutput.get(0));
    assertEquals("7-9,3", actualOutput.get(1));

    List<String> actualOutput1 = ReadingRangeCount.findNoOfReadingsInRange(5, 4, 7, 8, 9);
    assertEquals("4-5,2", actualOutput1.get(0));
    assertEquals("7-9,3", actualOutput1.get(1));

    List<String> actualOutput2 = ReadingRangeCount.findNoOfReadingsInRange(4, 7, 8, 9);
    assertEquals("7-9,3", actualOutput2.get(0));
  }

  @Test
  public void testFindRangesForA2DInpt() {
    List<String> actualOutput = ReadingRangeCount.findRangesForA2DInput(1228, 1228, 2047, 1637, 2865, 3275, 3684);
    assertEquals("3-5,4", actualOutput.get(0));
    assertEquals("7-9,3", actualOutput.get(1));
  }

  @Test
  public void testConvertA2DListIntoAmps() {
    int[] sampleInAmps = ReadingRangeCount.convertA2DListIntoAmps(4092, 4503, 1146);
    assert (10 == sampleInAmps[0]);
    assert (3 == sampleInAmps[1]);

    int[] sampleInAmps1 = ReadingRangeCount.convertA2DListIntoAmps();
    assert (0 == sampleInAmps1.length);
  }

  @Test
  public void testConvertA2DInputToAmps() {
    assertEquals(10, ReadingRangeCount.convertA2DInputToAmps(4092));
    assertEquals(10, ReadingRangeCount.convertA2DInputToAmps(4094));
    assertEquals(9, ReadingRangeCount.convertA2DInputToAmps(3800));
  }

  @Test
  public void testRoundOffToNearestInteger() {
    assertEquals(0, ReadingRangeCount.roundOffToNearestInteger(0f));
    assertEquals(0, ReadingRangeCount.roundOffToNearestInteger(0.4f));
    assertEquals(1, ReadingRangeCount.roundOffToNearestInteger(0.5f));
    assertEquals(1, ReadingRangeCount.roundOffToNearestInteger(0.6f));
  }
}