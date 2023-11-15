import java.util.Collection;
public class BoundedWaitList <E> extends WaitList<E>{
    private int size;
    public BoundedWaitList(int size){
        super();
        if(size <= 0) throw new IllegalArgumentException("Must be bigger than 0");
        this.size = size;
    }
    public BoundedWaitList(Collection<E> col){
        super(col);
        this.size = col.size();
    }
    public int getSize() {
        return size;
    }
    @Override
    public void add(E element) {
        if(components.size() == size) throw new IllegalStateException("Очередь заполнена!");
        components.add(element);
    }
    @Override
    public String toString() {
        return "BoundedWaitList{" +
                "size=" + size +
                ", components=" + components +
                '}';
    }
}
