package Course.syntax3.accessControl.syntax3.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OHIterator implements Iterator <OHRequest> {
    OHRequest curr;

    public OHIterator(OHRequest curr) {
        this.curr = curr;
    }

    public boolean isGood(OHRequest ex) {
        return ex.description.length() > 2;
    }

    @Override
    public boolean hasNext() {
        if (isGood(curr) && curr.next != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public OHRequest next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        curr = curr.next;
        return curr;
    }
}
