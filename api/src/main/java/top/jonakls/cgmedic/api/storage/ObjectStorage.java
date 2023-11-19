package top.jonakls.cgmedic.api.storage;

import org.jetbrains.annotations.ApiStatus;
import top.jonakls.cgmedic.api.cache.Cacheable;

import java.util.Optional;

public interface ObjectStorage<T extends Cacheable> {

    T findSync(String uuid, Class<T> clazz);

    @ApiStatus.Experimental
    T findAsync(String uuid, Class<T> clazz);

    Optional<T> findOptionalSync(String uuid, Class<T> clazz);

    @ApiStatus.Experimental
    Optional<T> findOptionalAsync(String uuid, Class<T> clazz);

    void saveSync(T object);

    @ApiStatus.Experimental
    void saveAsync(T object);

    void deleteSync(String uuid);
}
