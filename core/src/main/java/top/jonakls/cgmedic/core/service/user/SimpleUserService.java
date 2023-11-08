package top.jonakls.cgmedic.core.service.user;

import top.jonakls.cgmedic.api.entity.MedicEntity;
import top.jonakls.cgmedic.api.service.MedicService;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleUserService implements MedicService {

    private final Map<UUID, MedicEntity> patients = new ConcurrentHashMap<>();

    @Override
    public void load(String uuid) {


    }

    @Override
    public MedicEntity save(String uuid) {
        return null;
    }

    @Override
    public MedicEntity delete(String uuid) {
        return null;
    }

    @Override
    public void update(MedicEntity medic) {

    }

    @Override
    public MedicEntity get(String uuid) {
        return null;
    }

    @Override
    public Optional<MedicEntity> getOptional(String uuid) {
        return Optional.empty();
    }

    @Override
    public Map<UUID, MedicEntity> getAll() {
        return null;
    }

    @Override
    public void saveAll(Map<UUID, MedicEntity> medics) {

    }
}
