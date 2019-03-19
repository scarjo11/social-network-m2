package fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.service;

import fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.repository.EvenementOpenDataRepository;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.repository.EvenementRepository;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Evenement;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.EvenementOpenData;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Soiree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by wilfrid on 16/03/2019.
 */
@Service
public class EvenementImpl implements IEvenement {

    @Autowired
    EvenementRepository evenementRepository;

    @Autowired
    EvenementOpenDataRepository evenementOpenDataRepository;

    @Override
    public long creerEventPrivee(Evenement event) {
        evenementRepository.save(event);
        return event.getId();
    }

    @Override
    public long creerEventOpenData(EvenementOpenData evenementOpenData) {
        evenementOpenDataRepository.save(evenementOpenData);
        return evenementOpenData.getId();
    }

    @Override
    public Iterable<EvenementOpenData> getAllEventOpenData() {
        return evenementOpenDataRepository.findAll();
    }

    @Override
    public Collection<Evenement> getEventPrviateByPseudo(String pseudo) {

        return  evenementRepository.getEvenementsByPseudo(pseudo);
    }
}
