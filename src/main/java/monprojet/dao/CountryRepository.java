package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;
import monprojet.entity.PopulationCountry;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
     @Query("SELECT SUM(City.population) AS populationCountry "
    + "FROM City "
    + "WHERE City.country_id = :idCountry ")
    public Integer populationCountry(Integer idCountry);

    @Query("SELECT Country.name AS nom, SUM(City.population) AS populationCountry "
    + "FROM Country "
    + "INNER JOIN City ON Country.id=City.country_id "
    + "GROUP BY nom ")
    public List<PopulationCountry> populationCountry();  
}
