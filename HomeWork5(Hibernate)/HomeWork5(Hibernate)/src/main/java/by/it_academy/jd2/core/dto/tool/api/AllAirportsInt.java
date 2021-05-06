package by.it_academy.jd2.core.dto.tool.api;

import by.it_academy.jd2.core.dto.view.Airports;


import java.util.List;
import java.util.Set;

public interface AllAirportsInt {

      /**
     * <p>The method returns a list of all airports in the database</p>
     * <p>@param connection</p>
     * <p>@return list of all airports </p>
     */

    List<Airports> getAllAirports() throws IllegalAccessException;

    /**
     * The method returns list of titles for table airports
     * @return object airports
     */

    Airports listOfTitlesForAirports() throws IllegalAccessException;
    List<String> getListNameCity() throws IllegalAccessException;

}
