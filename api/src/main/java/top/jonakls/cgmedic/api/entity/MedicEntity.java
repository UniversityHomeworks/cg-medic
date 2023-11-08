package top.jonakls.cgmedic.api.entity;

import top.jonakls.cgmedic.api.entity.role.RoleEntity;

public interface MedicEntity {

    String uuid();

    RoleEntity role();

    void setRole(RoleEntity role);

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
