package repository;

import java.util.List;

public interface Repository <T, K>{
    K add (T item);
    List<T> getAll();
    T get(K id);
    boolean update(T item);
    boolean remove(T item);
    boolean removeById(K id);
}
