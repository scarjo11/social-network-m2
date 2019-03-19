package fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.repository;

import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Evenement;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Soiree;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by wilfrid on 06/03/2019.
 */
public interface EvenementRepository extends CrudRepository<Evenement, Long> {
    Collection<Evenement> getEvenementsByPseudo(String pseudo);
}
