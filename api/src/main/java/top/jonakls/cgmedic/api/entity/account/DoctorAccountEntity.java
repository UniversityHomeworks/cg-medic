package top.jonakls.cgmedic.api.entity.account;

import top.jonakls.cgmedic.api.entity.MedicEntity;
import top.jonakls.cgmedic.api.entity.doctor.DoctorEntity;
import top.jonakls.cgmedic.api.entity.role.RoleEntity;
import top.jonakls.cgmedic.api.entity.user.UserEntity;

public class DoctorAccountEntity extends UserAccountEntity {

    private DoctorEntity doctorEntity;

    public DoctorAccountEntity(
            String uuid, String nickname, String email, String password, DoctorEntity doctorEntity
    ) {
        super(uuid, nickname, email, password, doctorEntity, RoleEntity.MEDIC);
        this.doctorEntity = doctorEntity;
    }

    public static DoctorAccountEntity createMedic(
            String nickname, String email, String password,
            String name, String secondName, String phone,
            String specialty, String license, String professionalCard
    ) {
        return new DoctorAccountEntity(
                nickname, nickname, email, password,
                new DoctorEntity(
                        nickname, name, secondName, null, null, email, phone, null, null,
                        specialty, license, professionalCard
                )
        );
    }

    public DoctorEntity doctorEntity() {
        return doctorEntity;
    }

    @Override
    public MedicEntity userEntity() {
        return this.doctorEntity;
    }

    @Override
    public void userEntity(UserEntity medicEntity) {
        this.doctorEntity = (DoctorEntity) medicEntity;
    }
}
