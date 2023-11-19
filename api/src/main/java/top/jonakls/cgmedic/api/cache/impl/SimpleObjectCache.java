package top.jonakls.cgmedic.api.cache.impl;

import org.jetbrains.annotations.NotNull;
import top.jonakls.cgmedic.api.cache.Cacheable;
import top.jonakls.cgmedic.api.cache.ObjectCache;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleObjectCache<T extends Cacheable> implements ObjectCache<T> {

    private final Map<String, T> cache = new ConcurrentHashMap<>();

    @Override
    public void add(T object) {
        this.cache.put(object.uuid(), object);
    }

    @Override
    public T remove(T object) {
        return this.cache.remove(object.uuid());
    }

    @Override
    public void update(T object) {
        this.cache.replace(object.uuid(), object);
    }

    @Override
    public T get(String uuid) {
        return this.cache.get(uuid);
    }

    @Override
    public Optional<T> getOptional(String uuid) {
        T object = this.cache.get(uuid);

        if (object != null) {
            return Optional.of(object);
        }

        return Optional.empty();
    }

    @Override
    public void addAll(Map<String, T> objects) {
        this.cache.putAll(objects);
    }

    @Override
    public void cleanAll() {
        this.cache.clear();
    }

    @Override
    public @NotNull Iterator<T> iterator() {
        return this.cache.values().iterator();
    }
}
