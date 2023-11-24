package top.jonakls.cgmedic.core.service.entity.account;

import org.jetbrains.annotations.ApiStatus;
import top.jonakls.cgmedic.api.cache.ObjectCache;
import top.jonakls.cgmedic.api.cache.impl.SimpleObjectCache;
import top.jonakls.cgmedic.api.entity.account.UserAccountEntity;
import top.jonakls.cgmedic.api.entity.user.UserEntity;
import top.jonakls.cgmedic.api.service.MedicService;
import top.jonakls.cgmedic.api.storage.ObjectStorage;

import java.util.Optional;

/**
 * Simple implementation of {@link MedicService} for {@link UserEntity}.
 */
@ApiStatus.Experimental
public class SimpleAccountService implements MedicService<UserAccountEntity> {

    private final ObjectCache<UserAccountEntity> objectCache;
    private final ObjectStorage<UserAccountEntity> objectStorage;

    public SimpleAccountService(ObjectStorage<UserAccountEntity> objectStorage) {
        this.objectStorage = objectStorage;
        this.objectCache = new SimpleObjectCache<>();
    }


    @Override
    public void load(String name) {
        UserAccountEntity userAccountEntity = this.objectCache.get(name);

        if (userAccountEntity == null) {
            userAccountEntity = this.objectStorage.findSync(name, UserAccountEntity.class);

            if (userAccountEntity != null) {
                this.objectCache.add(userAccountEntity);
            }
        }
    }

    @Override
    public UserAccountEntity save(String uuid) {
        UserAccountEntity userAccountEntity = this.objectCache.get(uuid);

        this.objectStorage.saveSync(userAccountEntity);
        return userAccountEntity;
    }

    @Override
    public UserAccountEntity delete(String uuid) {
        UserAccountEntity userAccountEntity = this.objectCache.get(uuid);
        this.objectCache.remove(userAccountEntity);
        this.objectStorage.deleteSync(uuid);
        return userAccountEntity;
    }

    @Override
    public UserAccountEntity deleteOfCache(String uuid) {
        UserAccountEntity userAccountEntity = this.objectCache.get(uuid);
        this.objectCache.remove(userAccountEntity);
        return userAccountEntity;
    }

    @Override
    public void add(UserAccountEntity medic) {
        this.objectCache.add(medic);
        this.save(medic.uuid());
    }

    @Override
    public void update(UserAccountEntity medic) {
        this.objectCache.update(medic);
        this.objectStorage.saveSync(medic);
    }

    @Override
    public UserAccountEntity get(String uuid) {
        return this.objectCache.get(uuid);
    }

    @Override
    public Optional<UserAccountEntity> getOptional(String uuid) {
        return this.objectCache.getOptional(uuid);
    }

    @Override
    public void saveAll() {
        this.objectCache.forEach(this.objectStorage::saveSync);
    }
}
