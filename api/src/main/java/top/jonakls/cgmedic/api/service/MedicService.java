package top.jonakls.cgmedic.api.service;

import top.jonakls.cgmedic.api.cache.Cacheable;

import java.util.Optional;

public interface MedicService<T extends Cacheable> extends Service {

    void load(String uuid);

    T save(String uuid);

    T delete(String uuid);

    T deleteOfCache(String uuid);

    void add(T medic);

    void update(T medic);

    T get(String uuid);

    Optional<T> getOptional(String uuid);

    void saveAll();

    default void start() {
        // Nothing to do here
    }
}
