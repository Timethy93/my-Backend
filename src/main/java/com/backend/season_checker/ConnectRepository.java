package com.backend.season_checker;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ConnectRepository extends CrudRepository<LebensmittelEntity, Integer> {

    @Query(value = "SELECT * FROM db_paul.lebensmittel WHERE CAST(REPLACE( db_paul.lebensmittel.anfangs_datum, '-', '') AS UNSIGNED ) <= ?1 && ?1 <= CAST(REPLACE(db_paul.lebensmittel.end_datum, '-', '') AS UNSIGNED ) ;", nativeQuery = true)
    Iterable<LebensmittelEntity> findAllOnSeason(int heute);

    // update favourit useless
    @Modifying
    @Transactional
    @Query(value = "UPDATE db_paul.lebensmittel SET db_paul.lebensmittel.is_favorit = :neuenFav WHERE db_paul.lebensmittel.id = :id ; ", nativeQuery = true)
    void updateTrueFalse(@Param("neuenFav") boolean neuenFav, @Param("id") int id);

    @Query(value = "SELECT * FROM db_paul.lebensmittel WHERE db_paul.lebensmittel.id = ?1 ; ", nativeQuery = true)
    LebensmittelEntity getLebensmittelById(int id);
}