package com.backend.season_checker;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConnectRepository extends CrudRepository<LebensmittelEntity, Integer> {

    @Query(value = "SELECT * FROM db_paul.lebensmittel WHERE CAST(REPLACE( db_paul.lebensmittel.anfangs_datum, '-', '') AS UNSIGNED ) <= ?1 && ?1 <= CAST(REPLACE(db_paul.lebensmittel.end_datum, '-', '') AS UNSIGNED ) ;", nativeQuery = true)
    Iterable<LebensmittelEntity> findAllOnSeason(int heute);

    // update favourit useless
    @Query(value = "UPDATE db_paul.lebensmittel SET db_paul.lebensmittel.is_favorit = ?1 WHERE db_paul.lebensmittel.id = ?2 ; ", nativeQuery = true)
    Iterable<LebensmittelEntity> updateTrueFalse(boolean neuenFav, int id);

    @Query(value = "SELECT * FROM db_paul.lebensmittel WHERE db_paul.lebensmittel.id = ?1 ; ", nativeQuery = true)
    LebensmittelEntity getLebensmittelById(int id);
}