/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.service;

import java.util.List;
import una.ac.cr.consultoriobackend.model.Office;

/**
 *
 * @author cristian
 */
public interface OfficeService {

    /**
     *
     * @param office
     * @return
     */
    public Office saveOffice(Office office);

    /**
     *
     * @param id
     * @return
     */
    public Office findByIdOffice(int id);

    /**
     *
     * @param name
     * @return
     */
    public Office findByNameOffice(String name);

    /**
     *
     * @param office
     * @return
     */
    public Office updateOffice(Office office);

    /**
     *
     * @param id
     * @return
     */
    public boolean deleteOffice(int id);

    /**
     *
     * @return
     */
    public List<Office> findAllOffice();

}
