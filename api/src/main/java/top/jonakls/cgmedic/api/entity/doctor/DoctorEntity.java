package top.jonakls.cgmedic.api.entity.doctor;

import top.jonakls.cgmedic.api.entity.user.UserEntity;

public class DoctorEntity extends UserEntity {

    private final String specialty;
    private final String license;
    private final String professionalCard;

    public DoctorEntity(
            String uuid, String name, String secondName,
            String lastName, String secondLastName,
            String email, String phone, String address, String city,
            String specialty, String license, String professionalCard
    ) {
        super(uuid, name, secondName, lastName, secondLastName, email, phone, address, city);
        this.specialty = specialty;
        this.license = license;
        this.professionalCard = professionalCard;
    }


    public DoctorEntity(
            String uuid, String name, String lastName,
            String email, String phone, String address,
            String specialty, String license, String professionalCard
    ) {
        this(
                uuid, name, null,
                lastName, null, email,
                phone, address, null,
                specialty, license, professionalCard
        );
    }

    public String specialty() {
        return specialty;
    }

    public String license() {
        return license;
    }

    public String professionalCard() {
        return professionalCard;
    }
}
