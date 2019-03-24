package fr.orleans.miage.projet.groupeJ.microserviceevent.dao.repository;

import fr.orleans.miage.projet.groupeJ.microserviceevent.model.EvenementOpenData;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wilfrid on 06/03/2019.
 */
public interface EvenementOpenDataRepository extends CrudRepository<EvenementOpenData, Long> {
    EvenementOpenData getEvenementOpenDataById(long id);
}
