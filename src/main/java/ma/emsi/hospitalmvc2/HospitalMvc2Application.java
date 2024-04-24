package ma.emsi.hospitalmvc2;

import ma.emsi.hospitalmvc2.entities.Patient;
import ma.emsi.hospitalmvc2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalMvc2Application  implements CommandLineRunner {
    @Autowired

    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(HospitalMvc2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Patient patient = new Patient();
        patient.setId(null);
        patient.setNom("Mustapha");
        patient.setDateNaissance(new Date());
        patient.setScore(123);

        Patient patient2 = new Patient(null,"youness",new Date(),false,115);

        Patient patient3 = Patient.builder()
                .nom("zakaria")
                .dateNaissance(new Date())
                .score(155)
                .malade(true)
                .build();
        patientRepository.save(patient);
        patientRepository.save(patient2);
        patientRepository.save(patient3);
        patientRepository.save(new Patient(null,"mreda",new Date(),false,125));
        patientRepository.save(new Patient(null,"simo",new Date(),false,153));
        patientRepository.save(new Patient(null,"yassine",new Date(),true,156));
    }
}
