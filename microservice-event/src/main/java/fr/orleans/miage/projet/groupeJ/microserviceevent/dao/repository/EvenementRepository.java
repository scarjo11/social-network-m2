package fr.orleans.miage.projet.groupeJ.microserviceevent.dao.repository;

import fr.orleans.miage.projet.groupeJ.microserviceevent.model.Evenement;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by wilfrid on 06/03/2019.
 */
public interface EvenementRepository extends CrudRepository<Evenement, Long> {
    Collection<Evenement> getEvenementsByPseudo(String pseudo);
    Evenement getEvenementById(long id);
}
