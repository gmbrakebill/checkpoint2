package com.galvanize.flight_log;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository <Flight, Long>
{
    @Query(value="select * from flights where pilot = :id", nativeQuery = true)
    public Flight[] findPilotsById(Long id);


}
