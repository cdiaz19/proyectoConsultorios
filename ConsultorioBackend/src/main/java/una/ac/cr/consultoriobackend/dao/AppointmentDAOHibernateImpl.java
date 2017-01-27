
package una.ac.cr.consultoriobackend.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import una.ac.cr.consultoriobackend.model.PatientAppointment;

/**
 *
 * @author Yeni
 */


public class AppointmentDAOHibernateImpl implements AppointmentDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public PatientAppointment savePatientAppointment(PatientAppointment appointment) {
        session.beginTransaction();
        session.save(appointment);
        session.getTransaction().commit();

        return appointment;
    }

    @Override
    public PatientAppointment findByIdPatientAppointment(int id) {
        PatientAppointment appointment = null;
        Query query = session.createQuery("from appointment where id = :id ");
        query.setParameter("id", id);

        if (query.list().size() > 0) {
            appointment = (PatientAppointment) query.list().get(0);
        }

        return appointment;
    }

    @Override
    public PatientAppointment findByNamePatientAppointment(String name) {
        PatientAppointment appointment = null;
        Query query = session.createQuery("from appointment o where o.name like :name ");
        query.setParameter("name", name);

        if (query.list().size() > 0) {
            appointment = (PatientAppointment) query.list().get(0);
        }

        return appointment;
    }

    @Override
    public PatientAppointment updatePatientAppointment(PatientAppointment appointment) {
        session.beginTransaction();
        session.update(appointment);
        session.getTransaction().commit();

        return appointment;
    }

    @Override
    public boolean deletePatientAppointment(int id) {
        boolean isDeleted = false;
        PatientAppointment student = null;

        session.beginTransaction();
        student = (PatientAppointment) session.get(PatientAppointment.class, id);
        session.delete(student);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }

    @Override
    public List<PatientAppointment> findAllPatientAppointment() {
        List<PatientAppointment> appointmentList = new ArrayList<>();
        appointmentList = session.createCriteria(PatientAppointment.class).list();
        
        return appointmentList;
    }
    
}
