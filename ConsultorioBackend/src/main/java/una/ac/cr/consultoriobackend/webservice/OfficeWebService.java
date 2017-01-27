package una.ac.cr.consultoriobackend.webservice;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import una.ac.cr.consultoriobackend.dao.OfficeDAO;
import una.ac.cr.consultoriobackend.dao.OfficeDAOHibernateImpl;
import una.ac.cr.consultoriobackend.model.Office;
import una.ac.cr.consultoriobackend.service.OfficeService;
import una.ac.cr.consultoriobackend.service.OfficeServiceImpl;

/**
 * REST Web Service
 *
 * @author Yeni
 */
@Path("offices")
public class OfficeWebService {

    private OfficeDAO officeDAO;
    private OfficeService officeService;

    @Context
    private UriInfo context;

    /**
     *
     */
    public OfficeWebService() {
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Office> getAllOffices() {
        List<Office> officeList = null;
        officeDAO = new OfficeDAOHibernateImpl();
        officeService = new OfficeServiceImpl(officeDAO);
        officeList = officeService.findAllOffice();

        return officeList;
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Office getOfficeId(@PathParam("id") int id) {
        Office office = null;
        officeDAO = new OfficeDAOHibernateImpl();
        officeService = new OfficeServiceImpl(officeDAO);
        office = officeService.findByIdOffice(id);

        return office;
    }

    /**
     *
     * @param name
     * @return
     */
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Office getOfficeName(@PathParam("name") String name) {
        Office office = null;
        officeDAO = new OfficeDAOHibernateImpl();
        officeService = new OfficeServiceImpl(officeDAO);
        office = officeService.findByNameOffice(name);

        return office;
    }

    /**
     *
     * @param office
     * @return
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Office createOffice(Office office) {

        officeDAO = new OfficeDAOHibernateImpl();
        officeService = new OfficeServiceImpl(officeDAO);
        office = officeService.saveOffice(office);

        return office;
    }

    /**
     *
     * @param id
     * @return
     */
    @DELETE
    @Path("/{id}")
    public boolean deleteOffice(@PathParam("id") int id) {
        boolean result;
        officeDAO = new OfficeDAOHibernateImpl();
        officeService = new OfficeServiceImpl(officeDAO);
        result = officeService.deleteOffice(id);

        return result;
    }

    /**
     *
     * @param office
     * @return
     */
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Office updateOffice(Office office) {

        officeDAO = new OfficeDAOHibernateImpl();
        officeService = new OfficeServiceImpl(officeDAO);
        office = officeService.updateOffice(office);

        return office;
    }
}
