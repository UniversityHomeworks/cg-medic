package top.jonakls.cgmedic.api.entity;

import top.jonakls.cgmedic.api.cache.Cacheable;

public interface MedicEntity extends Cacheable {

    String uuid();

    String name();

    void setName(String name);

    String secondName();

    void setSecondName(String secondName);

    String lastName();

    void setLastName(String lastName);

    String secondLastName();

    void setSecondLastName(String secondLastName);

    String email();

    void setEmail(String email);

    String phone();

    void setPhone(String phone);

    String address();

    void setAddress(String address);

    String city();

    void setCity(String city);

}
