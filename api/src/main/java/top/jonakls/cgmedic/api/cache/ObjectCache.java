package top.jonakls.cgmedic.api.cache;

import java.util.Map;
import java.util.Optional;

public interface ObjectCache<T extends Cacheable> extends Iterable<T> {

    void add(T object);

    T remove(T object);

    void update(T object);

    T get(String uuid);

    Optional<T> getOptional(String uuid);

    void addAll(Map<String, T> objects);

    void cleanAll();
}
