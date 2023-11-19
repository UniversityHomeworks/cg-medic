package top.jonakls.cgmedic.api.service;

public interface Service {

    void start();

    default void stop() {
        // Nothing to do here
    }
}
