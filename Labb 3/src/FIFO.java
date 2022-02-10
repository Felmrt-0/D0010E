import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO implements Queue {
    private ArrayList<Object> queue = new ArrayList<Object>();
    private int maximumSize;

    public int size() {
        return queue.size();
    }

    public int maxSize() {
        return maximumSize;
    }

    public boolean isEmpty() {
        if (queue.size() == 0) {
            return true;
        }
        return false;
    }

    public Object first() throws NoSuchElementException {
        if (queue.size() == 0) {
            throw new NoSuchElementException();
        }
        return queue.get(0);
    }

    public boolean equals(Object f) throws ClassCastException {
        if (f.getClass() != this.getClass()) {
            throw new ClassCastException();
        }

        if (this.size() == ((FIFO) f).size()) {
            for (int i = 0; i < this.size(); i++) {
                if (this.queue.get(i) == null) {
                    if (((FIFO) f).queue.get(i) != null) {
                        return false;
                    }
                } else if (!this.queue.get(i).equals(((FIFO) f).queue.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public String toString() {
        String output = "Queue: ";
        for (int i = 0; i < size(); i++) {

            output += "(" + String.valueOf(queue.get(i)) + ") "; // queue.get(i) istället för i?
        }

        return output;
    }

    public void add(Object item) {
        queue.add(item);
        if (maximumSize < queue.size()) {
            maximumSize = queue.size();
        }
    }

    public void removeFirst() throws NoSuchElementException {
        if (queue.size() == 0) {
            throw new NoSuchElementException();
        }
        queue.remove(0);
    }

}
