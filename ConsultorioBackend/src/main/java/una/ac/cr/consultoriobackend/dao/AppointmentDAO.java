
package una.ac.cr.consultoriobackend.dao;

import java.util.List;
import una.ac.cr.consultoriobackend.model.PatientAppointment;

/**
 *
 * @author Yeni
 */


public interface AppointmentDAO {
    public PatientAppointment savePatientAppointment(PatientAppointment appointment);

    public PatientAppointment findByIdPatientAppointment(int id);

    public PatientAppointment findByNamePatientAppointment(String name);

    public PatientAppointment updatePatientAppointment(PatientAppointment appointment);

    public boolean deletePatientAppointment(int id);

    public List<PatientAppointment> findAllPatientAppointment();
}
