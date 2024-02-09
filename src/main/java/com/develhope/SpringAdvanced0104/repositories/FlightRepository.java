package com.develhope.SpringAdvanced0104.repositories;

import com.develhope.SpringAdvanced0104.entities.FlightEntity;
import com.develhope.SpringAdvanced0104.entities.Status;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Id> {

    @Query(value = "SELECT * FROM flights AS f WHERE f.flight_status = :#{#p1.toString()} OR f.flight_status = :#{#p2.toString()}", nativeQuery = true)
    List<FlightEntity> showFlightsBasedOnTwoEnumValues(@Param("p1") Status p1,@Param("p2") Status p2);

    @Query(value = "SELECT * FROM flights AS f WHERE f.flight_status = :#{#status.toString()}", nativeQuery = true)
    public List<FlightEntity> findFlightByStatus(@Param("status") Status status);

}
