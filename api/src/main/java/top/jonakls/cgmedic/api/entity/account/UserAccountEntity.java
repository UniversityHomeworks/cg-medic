package top.jonakls.cgmedic.api.entity.account;

import top.jonakls.cgmedic.api.cache.Cacheable;
import top.jonakls.cgmedic.api.entity.MedicEntity;
import top.jonakls.cgmedic.api.entity.role.RoleEntity;
import top.jonakls.cgmedic.api.entity.user.UserEntity;

import java.util.UUID;

public class UserAccountEntity implements Cacheable {

    private final String uuid;
    private String nickname;
    private String email;
    private String password;
    private UserEntity userEntity;
    private RoleEntity role;

    public UserAccountEntity(String uuid, String nickname, String email, String password, UserEntity userEntity,
                             RoleEntity role) {
        this.uuid = uuid;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.userEntity = userEntity;
        this.role = role;
    }

    public static UserAccountEntity createUser(String nickname, String email, String password,
                                               String name, String secondName, String phone
    ) {
        String uuid = UUID.randomUUID().toString();

        return new UserAccountEntity(
                uuid, nickname, email, password,
                new UserEntity(uuid, name, secondName, email, phone),
                RoleEntity.PATIENT
        );
    }

    public static UserAccountEntity createMedic(
            String uuid, String nickname, String email, String password,
            String name, String secondName, String phone
    ) {
        return new UserAccountEntity(
                uuid, nickname, email, password,
                new UserEntity(uuid, name, secondName, email, phone),
                RoleEntity.MEDIC
        );
    }

    @Override
    public String uuid() {
        return this.uuid;
    }

    public String nickname() {
        return nickname;
    }

    public void nickname(String nickname) {
        this.nickname = nickname;
    }

    public String email() {
        return email;
    }

    public void email(String email) {
        this.email = email;
    }

    public String password() {
        return password;
    }

    public void password(String password) {
        this.password = password;
    }

    public MedicEntity userEntity() {
        return userEntity;
    }

    public void userEntity(UserEntity medicEntity) {
        this.userEntity = medicEntity;
    }

    public RoleEntity role() {
        return role;
    }

    public void role(RoleEntity role) {
        this.role = role;
    }
}
