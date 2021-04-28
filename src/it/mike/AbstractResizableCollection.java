package it.mike;

public abstract class AbstractResizableCollection<T> implements Collection<T>{

    protected Object[] a;
    protected int actualSize;

    protected void actualAdd(T x) {
        if (actualSize >= a.length) {
            Object[] newa = new Object[a.length * 2];
            System.arraycopy(a, 0, newa, 0, a.length);
            a = newa;
        }
        a[actualSize++] = x;
    }


    @Override
    public boolean contains(T x){
        for (Object o_ : a){
            T o = (T) o_;
            if (o.equals(x)) return true;
        }
        return false;
    }

    @Override
    public int size(){
        return actualSize;
    }


    private boolean isRemove(T x){
        boolean found = false;
        assert x != null;
        for (int i = 0; i < actualSize; ++i) {
            T o = (T) a[i];
            if (o.equals(x)) {
                if (actualSize - (i + 1) >= 0) System.arraycopy(a, i + 1, a, i + 1 - 1, actualSize - (i + 1));
                --actualSize;
                found = true;
                break;
            }
        }
        return found;
    }

    @Override
    public void remove(T x){
        isRemove(x);
    }

    @Override
    public void removeAll(T x){
        boolean all = isRemove(x);
        if(all = true)
            removeAll(x);
    }

}
