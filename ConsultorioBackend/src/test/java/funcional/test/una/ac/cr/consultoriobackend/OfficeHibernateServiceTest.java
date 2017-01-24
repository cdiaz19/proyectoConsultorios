/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcional.test.una.ac.cr.consultoriobackend;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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

    @Test
    public void testHibernateFindByIdOffice() {
        officeDAO = mock(OfficeDAOHibernateImpl.class);
        officeService = new OfficeServiceImpl(officeDAO);

        Office office = new Office();

        office.setName("Hospital CIMA");
        office.setPhone("22795122");
        office.setDays("Lunes y Martes");
        office.setHourStart("8:00");
        office.setHourEnd("5:00");

        when(officeService.findByIdOffice(1)).thenReturn(office);

        assertThat(office.getName(), is("Hospital CIMA"));
    }

    @Test
    public void testHibernateUpdateOffice() {
        officeDAO = new OfficeDAOHibernateImpl();
        officeService = new OfficeServiceImpl(officeDAO);

        office = new Office();

        office.setName("Clinica Tres Rios");
        office.setPhone("22795122");
        office.setDays("Miercoles");
        office.setHourStart("8:00");
        office.setHourEnd("5:00");

        office = officeService.saveOffice(office);
        assertNotNull(office.getIdOffice());

        office.setName("Nueva Clinica Tres Rios");
        officeService.updateOffice(office);
        assertThat(office.getName(), is("Nueva Clinica Tres Rios"));
    }

    @Test
    public void testHibernateDeleteOffice() {
        officeDAO = new OfficeDAOHibernateImpl();
        officeService = new OfficeServiceImpl(officeDAO);

        office = new Office();

        office.setName("Clinica Tres Rios");
        office.setPhone("22795122");
        office.setDays("Miercoles");
        office.setHourStart("8:00");
        office.setHourEnd("5:00");
        office = officeService.saveOffice(office);
        assertNotNull(office.getIdOffice());

        officeService.deleteOffice(office);
        assertThat(office.getIdOffice(), is(office.getIdOffice()));
    }

    @Test
    public void testHibernateFindByNameffice() {
        officeDAO = mock(OfficeDAOHibernateImpl.class);
        officeService = new OfficeServiceImpl(officeDAO);

        Office office = new Office();

        office.setName("Hospital CIMA");
        office.setPhone("22795122");
        office.setDays("Lunes y Martes");
        office.setHourStart("8:00");
        office.setHourEnd("5:00");

        when(officeService.findByNameOffice("Hospital CIMA")).thenReturn(office);

        assertThat(office.getName(), is("Hospital CIMA"));
    }

    @After
    public void deleteAll() {
        officeDAO = new OfficeDAOHibernateImpl();
        officeService = new OfficeServiceImpl(officeDAO);
    }
}
