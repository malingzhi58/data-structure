package Course.syntax3.accessControl.syntax3.map;

import java.util.Iterator;

public class OHQueue implements Iterable<OHRequest> {
    OHRequest Que;
    public OHQueue(OHRequest Que) {
        this.Que = Que;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<OHRequest> iterator() {
        return new OHIterator(Que);
    }
}
