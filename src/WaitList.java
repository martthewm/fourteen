import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WaitList <E> implements IWaitList<E> {
    protected ConcurrentLinkedQueue<E> components;

    public WaitList() {
        this.components = new ConcurrentLinkedQueue<>();
    }

    public WaitList(Collection<E> collection) {
        this.components = new ConcurrentLinkedQueue<>(collection);
    }

    @Override
    public String toString() {
        return "WaitList{" +
                "components=" + components +
                '}';
    }

    @Override
    public void add(E element) {
        components.add(element);
    }

    @Override
    public E remove() {
        if(isEmpty()) throw new IllegalStateException("Queue is empty!");
        return components.remove();
    }

    @Override
    public boolean contains(E element) {
        boolean flag = false;
        for(int i = 0; i < components.size(); i++){
            E el = components.remove();
            if(el.equals(element)) flag = true;
            components.add(el);

        }
        return flag;
    }

    @Override
    public boolean containsAll(Collection<E> collection) {
        ArrayList<E> al = new ArrayList<>(collection);
        for(int i = 0; i < collection.size(); i++){
            boolean res = false;
            for(int j = 0; j < components.size(); j++){
                E el = components.remove();
                if(el.equals(al.get(i))) res = true;
                components.add(el);
            }
            if(!res) return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return components.isEmpty();
    }
}
