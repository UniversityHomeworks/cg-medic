package top.jonakls.cgmedic.api.entity.user;

import top.jonakls.cgmedic.api.entity.MedicEntity;
import top.jonakls.cgmedic.api.entity.role.RoleEntity;
import top.jonakls.cgmedic.api.entity.user.history.HistoryEntity;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserEntity implements MedicEntity {

    private final String uuid;
    private String name;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private final Map<String, HistoryEntity> history;
    private RoleEntity role;

    public UserEntity(
            String uuid, RoleEntity roleEntity,
            String name, String secondName,
            String lastName, String secondLastName,
            String email, String phone,
            String address, String city
    ) {
        this.uuid = uuid;
        this.role = roleEntity == null ? RoleEntity.PATIENT : roleEntity;
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.history = new ConcurrentHashMap<>();
    }

    @Override
    public String uuid() {
        return uuid;
    }

    @Override
    public RoleEntity role() {
        return this.role;
    }

    @Override
    public void setRole(RoleEntity role) {
        this.role = role;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String secondName() {
        return secondName;
    }

    @Override
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String lastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String secondLastName() {
        return secondLastName;
    }

    @Override
    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String phone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String address() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String city() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    public Iterator<HistoryEntity> historyIterator() {
        return this.history.values().iterator();
    }

    public void addHistory(HistoryEntity historyEntity) {
        this.history.put(historyEntity.uuid(), historyEntity);
    }

    public void removeHistory(String uuid) {
        this.history.remove(uuid);
    }

    public HistoryEntity getHistory(String uuid) {
        return this.history.get(uuid);
    }
}
