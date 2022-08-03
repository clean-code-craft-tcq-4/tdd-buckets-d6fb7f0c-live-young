import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class ReadingRangeCountTest {
    ReadingRangeCount readingRangeCount = new ReadingRangeCount();

    @Test
    public void countGivenRangeTest_invalid_startRange() throws Exception {
    	List <Integer> inputRange = new ArrayList<>(Arrays.asList(4,5));
    	Map<String,Integer> result = readingRangeCount.getChargingRange(inputRange);
    	assertTrue(!result.isEmpty());
    	assertTrue(result.get("4 to 5")==2);
        
    }

}
