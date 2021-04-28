package it.mike;

public interface List<T> extends Collection<T> {
    T get(int index);
    void set(int index, T x);
    void remove(int index);
    void add(int index, T x);
}
