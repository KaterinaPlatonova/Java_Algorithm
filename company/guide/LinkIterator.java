import java.util.Iterator;
import java.util.function.Consumer;

public class LinkIterator implements Iterator<LinkImpl> {

    private LinkImpl link;
    private boolean firstIterate = true;

    private Link current;

    public LinkIterator(LinkImpl link) {
        this.link = link;
    }

    @Override
    public boolean hasNext() {
        if (firstIterate) {
            firstIterate = false;
            return link.getFirstElement() != null;
        } else {
            return current.getNextItem() != null;
        }
    }

    @Override
    public Link next() {
        if (current == null) {
            current = link.getFirstElement();
        } else {
            current = current.getNextItem();
        }
        return current.getNextItem();
    }

    @Override
    public void remove() {
        link.removeFirst();
    }

    @Override
    public void forEachRemaining(Consumer<? super LinkImpl> action) {

    }
}
