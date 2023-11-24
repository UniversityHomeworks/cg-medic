package top.jonakls.cgmedic.core.storage;

import com.google.gson.Gson;
import org.jetbrains.annotations.ApiStatus;
import top.jonakls.cgmedic.api.cache.Cacheable;
import top.jonakls.cgmedic.api.storage.ObjectStorage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ObjectJsonStorage<T extends Cacheable> implements ObjectStorage<T> {

    private final static Gson GSON = new Gson();
    private final File rootFolder;


    public ObjectJsonStorage(String rootPath) {
        this.rootFolder = new File(rootPath + "/");

        File folder = new File(rootPath);

        if (!folder.exists() && !folder.mkdirs()) {
            throw new RuntimeException("Cannot create folder " + rootPath);
        }
    }

    @Override
    public T findSync(String uuid, Class<T> clazz) {
        if (!rootFolder.exists()) {
            throw new RuntimeException("File " + rootFolder.getAbsolutePath() + " does not exist");
        }

        File file = new File(rootFolder, uuid + ".json");
        if (!file.exists()) {
            return null;
        }

        try (Reader reader = new BufferedReader(new FileReader(file))) {
            return GSON.fromJson(reader, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + file.getAbsolutePath(), e);
        }
    }

    @Override
    public T findAsync(String uuid, Class<T> clazz) {
        return CompletableFuture.supplyAsync(() -> {
            if (!rootFolder.exists()) {
                throw new RuntimeException("File " + rootFolder.getAbsolutePath() + " does not exist");
            }

            File file = new File(rootFolder, uuid + ".json");
            if (!file.exists()) {
                throw new RuntimeException("File " + file.getAbsolutePath() + " does not exist");
            }

            try (Reader reader = new BufferedReader(new FileReader(rootFolder))) {
                return GSON.fromJson(reader, clazz);
            } catch (IOException e) {
                throw new RuntimeException("Cannot read file " + rootFolder.getAbsolutePath(), e);
            }
        }).whenComplete((medic, throwable) -> {
            if (throwable != null) {
                throw new RuntimeException("Cannot load medic with uuid " + uuid, throwable);
            }
        }).exceptionally(e -> {
            throw new RuntimeException("Cannot load medic with uuid " + uuid, e);
        }).thenApply(medic -> {
            if (medic == null) {
                throw new RuntimeException("Medic with uuid " + uuid + " does not exist");
            }
            return medic;
        }).join();
    }

    @Override
    public Optional<T> findOptionalSync(String uuid, Class<T> clazz) {
        T object = this.findSync(uuid, clazz);

        if (object == null) {
            return Optional.empty();
        }

        return Optional.of(this.findSync(uuid, clazz));
    }

    @Override
    @ApiStatus.ScheduledForRemoval(inVersion = "3.0.0")
    @Deprecated
    public Optional<T> findOptionalAsync(String uuid, Class<T> clazz) {
        return null;
    }

    @Override
    public void saveSync(T object) {
        File file = new File(rootFolder, object.uuid() + ".json");


        try {
            if (!file.exists() && !file.createNewFile()) {
                throw new RuntimeException("Cannot create file " + file.getAbsolutePath());
            }

            try (Writer writer = new BufferedWriter(new FileWriter(file))) {
                GSON.toJson(object, writer);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file " + file.getAbsolutePath(), e);
        }
    }

    @Override
    public void saveAsync(T medic) {
        CompletableFuture.runAsync(() -> {
            try (Writer writer = new BufferedWriter(new FileWriter(rootFolder))) {
                GSON.toJson(medic, writer);
            } catch (IOException e) {
                throw new RuntimeException("Cannot write to file " + rootFolder.getAbsolutePath(), e);
            }
        }).exceptionally(e -> {
            throw new RuntimeException("Cannot save medic with uuid " + medic.uuid(), e);
        });
    }

    @Override
    public void deleteSync(String uuid) {
        if (!rootFolder.exists()) {
            throw new RuntimeException("File " + rootFolder.getAbsolutePath() + " does not exist");
        }

        File file = new File(rootFolder, uuid + ".json");
        if (!file.exists()) {
            throw new RuntimeException("File " + file.getAbsolutePath() + " does not exist");
        }

        if (!file.delete()) {
            throw new RuntimeException("Cannot delete file " + file.getAbsolutePath());
        }
    }
}
