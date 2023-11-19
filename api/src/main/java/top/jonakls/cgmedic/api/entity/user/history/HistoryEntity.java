package top.jonakls.cgmedic.api.entity.user.history;

import top.jonakls.cgmedic.api.entity.doctor.DoctorEntity;

import java.util.List;

public class HistoryEntity {

    private final String uuid;
    private final DoctorEntity doctor;
    private String date;
    private String description;
    private String diagnosis;
    private String treatment;
    private List<String> diseases;
    private List<String> medicines;

    private HistoryEntity(
            String uuid, DoctorEntity doctor,
            String date, String description,
            String diagnosis, String treatment,
            List<String> diseases, List<String> medicines
    ) {
        this.uuid = uuid;
        this.doctor = doctor;
        this.date = date;
        this.description = description;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.diseases = diseases;
        this.medicines = medicines;
    }

    public static HistoryEntity createHistory(
            String uuid, DoctorEntity doctor,
            String date, String description,
            String diagnosis, String treatment,
            List<String> diseases, List<String> medicines
    ) {
        return new HistoryEntity(
                uuid, doctor,
                date, description,
                diagnosis, treatment,
                diseases, medicines
        );
    }

    public String uuid() {
        return uuid;
    }

    public DoctorEntity doctor() {
        return doctor;
    }

    public String date() {
        return date;
    }

    public void date(String date) {
        this.date = date;
    }

    public String description() {
        return description;
    }

    public void description(String description) {
        this.description = description;
    }

    public String diagnosis() {
        return diagnosis;
    }

    public void diagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String treatment() {
        return treatment;
    }

    public void treatment(String treatment) {
        this.treatment = treatment;
    }

    public List<String> diseases() {
        return diseases;
    }

    public void diseases(List<String> diseases) {
        this.diseases = diseases;
    }

    public List<String> medicines() {
        return medicines;
    }

    public void medicines(List<String> medicines) {
        this.medicines = medicines;
    }
}
