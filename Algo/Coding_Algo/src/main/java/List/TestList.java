package List;

import org.junit.Test;
/**
 * Created by dpandey on 8/26/17.
 */
public class TestList {

    @Test
    public void testAddNode() {
        MyLinkedList<String> myList = new MyLinkedList<String>();
        myList.add("dinesh");
        myList.add("pandey");

        String data = myList.get("pandey");
        System.out.println(data);
    }

    @Test
    public void removeElement() {
        MyLinkedList<String> myList = new MyLinkedList<String>();
        myList.add("one");
        myList.add("two");
        myList.add("Three");
        myList.add("four");
        myList.remove("four");
       // myList.add("five");
        myList.displayNode();

    }
}
