package ohm.softa.a02;
import java.util.Iterator;
/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */

public class SimpleListImpl implements SimpleList, Iterable {
    private Element first;
    private int test;
    public SimpleListImpl(){
        first = null;
    }
	// TODO: Implement the required methods.
    public void add(Object item){
        Element curr = first;
        if(curr == null) {
            first = new Element(item);
            return;
        }
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new Element(item);
    }
    public int size(){
        if(first == null)
            return 0;
        Element curr = first;
        int count = 1;
        while(curr.next != null){
            count++;
        }
        return count;
    }

    public SimpleList filter(SimpleFilter filter){
        SimpleListImpl newList = new SimpleListImpl();
        if(first == null)
            return null;
        Element curr = first;
        while(curr != null){
            if(filter.include(curr.item)){
                newList.add(curr.item);
            }
            curr = curr.next;
        }
        return newList;
    }

    public Iterator iterator(){
        return new SimpleIteratorImpl();
    }
    private static class Element {
        public Element(Object obj){
            item = obj;
        }
        public Element next;
        public  Object item;
    }

    public class SimpleIteratorImpl implements Iterator {
       private Element currentElement;
       public SimpleIteratorImpl(){
           currentElement = first;
       }
        @Override
        public boolean hasNext() {
                return !(currentElement == null || currentElement.next == null);
        }

        @Override
        public Object next() {
            currentElement = currentElement.next;
            return currentElement;
        }
    }
}
