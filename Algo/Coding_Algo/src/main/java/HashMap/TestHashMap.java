package HashMap;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by dpandey on 9/4/17.
 */
public class TestHashMap {

    @Test
    public void testGetValueFromHashMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("TestOne", 1);
        hashMap.put("TestTwo", 2);
        hashMap.put("TestThree",3);

        int inputString =  hashMap.get("TestOne");
        assertEquals(inputString, 1);
    }

    @Test
    public void testMultipleSetValuesInHashMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("My first string", 1);
        hashMap.put("My second string", 2);
        hashMap.put("My third string", 3);
        hashMap.put("My fourth string", 4);
        hashMap.put("My fiveth string", 5);
        hashMap.put("My sixth string", 6);
        hashMap.put("My seventh string", 7);
        hashMap.put("Eight", 8);
        hashMap.put("Nine", 9);
        hashMap.put("Ten", 10);
        hashMap.put("eleven", 11);
        hashMap.put("Twelve", 12);
        assertThat(hashMap.get("eleven"), is(11));
    }

    @Test
    public void testParseString() {
       String format1= "1234456,\"123,345\"";
        String format2 = format1.replace("\"", "");
        String abc[] = format2.split(",",2);;
        System.out.println(abc);
    }
}
