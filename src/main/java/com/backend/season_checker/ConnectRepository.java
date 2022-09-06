package com.backend.season_checker;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConnectRepository extends CrudRepository<LebensmittelEntity, Integer> {

    @Query(value = "SELECT * FROM db_paul.lebensmittel WHERE CAST(REPLACE( db_paul.lebensmittel.anfangs_datum, '-', '') AS UNSIGNED ) <= ?1 && ?1 <= CAST(REPLACE(db_paul.lebensmittel.end_datum, '-', '') AS UNSIGNED ) ;", nativeQuery = true)
    Iterable<LebensmittelEntity> findAllOnSeason(int heute);

}