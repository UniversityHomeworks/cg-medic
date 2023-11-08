package top.jonakls.cgmedic.api.entity.role;

public enum RoleEntity {

    ADMIN("admin"),
    MEDIC("medic"),
    PATIENT("patient");

    private final String role;

    RoleEntity(String role) {
        this.role = role;
    }

    public String role() {
        return role;
    }


}
