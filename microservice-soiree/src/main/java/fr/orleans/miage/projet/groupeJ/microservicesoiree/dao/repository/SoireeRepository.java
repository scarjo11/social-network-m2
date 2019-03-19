package fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.repository;

import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Soiree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by wilfrid on 06/03/2019.
 */
public interface SoireeRepository extends CrudRepository<Soiree, Long> {
    Soiree getSoireeById(long id);
    Collection<Soiree> getSoireesByPseudo(String pseudo);
}
