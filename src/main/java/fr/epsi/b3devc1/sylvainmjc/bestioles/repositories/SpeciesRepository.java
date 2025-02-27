package fr.epsi.b3devc1.sylvainmjc.bestioles.repositories;

import fr.epsi.b3devc1.sylvainmjc.bestioles.models.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {

    // TP4
    Species findFirstByCommonName(String commonName);

    List<Species> findByLatinNameContainingIgnoreCase(String latinName);

    // TP5
    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllOrderByCommonNameAsc();

    @Query("SELECT s FROM Species s WHERE s.commonName LIKE %:commonName%")
    List<Species> findByCommonNameLike(@Param("commonName") String commonName);
}