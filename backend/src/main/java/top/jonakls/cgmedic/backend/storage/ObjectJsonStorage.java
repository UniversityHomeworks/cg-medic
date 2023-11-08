package top.jonakls.cgmedic.backend.storage;

import com.google.gson.Gson;
import top.jonakls.cgmedic.api.entity.MedicEntity;

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

public class ObjectJsonStorage<T extends MedicEntity> {

    private final static Gson GSON = new Gson();
    private final File file;

    public ObjectJsonStorage(String rootPath, String fileName) {
        this.file = new File(rootPath + "/" + fileName);

        File folder = new File(rootPath);

        if (!folder.exists() && !folder.mkdirs()) {
            throw new RuntimeException("Cannot create folder " + rootPath);
        }
    }

    public T find(String uuid, Class<T> clazz) {
        return CompletableFuture.supplyAsync(() -> {
            if (!file.exists()) {
                throw new RuntimeException("File " + file.getAbsolutePath() + " does not exist");
            }

            try (Reader reader = new BufferedReader(new FileReader(file))) {
                return GSON.fromJson(reader, clazz);
            } catch (IOException e) {
                throw new RuntimeException("Cannot read file " + file.getAbsolutePath(), e);
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

    public Optional<T> findOptional(String uuid, Class<T> clazz) {
        return Optional.of(find(uuid, clazz));
    }

    public void save(T medic) {
        CompletableFuture.runAsync(() -> {
            try (Writer writer = new BufferedWriter(new FileWriter(file))) {
                GSON.toJson(medic, writer);
            } catch (IOException e) {
                throw new RuntimeException("Cannot write to file " + file.getAbsolutePath(), e);
            }
        }).exceptionally(e -> {
            throw new RuntimeException("Cannot save medic with uuid " + medic.uuid(), e);
        });
    }


}
