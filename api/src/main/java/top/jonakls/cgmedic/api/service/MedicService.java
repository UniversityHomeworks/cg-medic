package top.jonakls.cgmedic.api.service;

import top.jonakls.cgmedic.api.entity.MedicEntity;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface MedicService extends Service {

    void load(String uuid);

    MedicEntity save(String uuid);

    MedicEntity delete(String uuid);

    void update(MedicEntity medic);

    MedicEntity get(String uuid);

    Optional<MedicEntity> getOptional(String uuid);

    //TODO: add method for getting all entities from json database
    //List<MedicEntity> getAll();

    Map<UUID, MedicEntity> getAll();

    void saveAll(Map<UUID, MedicEntity> medics);
}
