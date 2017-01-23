/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcional.test.una.ac.cr.consultoriobackend;

import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import una.ac.cr.consultoriobackend.dao.OfficeDAO;
import una.ac.cr.consultoriobackend.dao.OfficeDAOHibernateImpl;
import una.ac.cr.consultoriobackend.model.Office;
import una.ac.cr.consultoriobackend.service.OfficeService;
import una.ac.cr.consultoriobackend.service.OfficeServiceImpl;

/**
 *
 * @author cristian
 */
public class OfficeHibernateServiceTest {

    private OfficeDAO officeDAO;
    private OfficeService officeService;
    private Office office = null;

    public OfficeHibernateServiceTest() {
    }

    @Test
    public void testHibernateSaveOffice() {

        officeDAO = new OfficeDAOHibernateImpl();
        officeService = new OfficeServiceImpl(officeDAO);

        office = new Office();
        office.setName("Hospital CIMA");
        office.setPhone("22795122");
        office.setDays("Lunes y Martes");
        office.setHourStart("8:00");
        office.setHourEnd("5:00");

        office = officeService.saveOffice(office);
        assertNotNull(office.getIdOffice());
    }

    @After
    public void deleteAll() {
        officeDAO = new OfficeDAOHibernateImpl();
        officeService = new OfficeServiceImpl(officeDAO);
    }
}
