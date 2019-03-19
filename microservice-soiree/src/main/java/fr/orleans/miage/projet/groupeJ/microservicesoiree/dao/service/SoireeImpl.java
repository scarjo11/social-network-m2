package fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.service;

import fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.repository.SoireeRepository;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.exceptions.SoireeNotFoundException;
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
public class SoireeImpl implements ISoiree {

    @Autowired
    SoireeRepository soireeRepository;

    @Override
    public long creerSoiree(Soiree soiree) {
        soireeRepository.save(soiree);
        return soiree.getId();
    }

    @Override
    public Soiree getByIdSoiree(long id) {
        return soireeRepository.getSoireeById(id);
    }

    @Override
    public Collection<Soiree> getSoireesByPseudo(String pseudo) {

        return soireeRepository.getSoireesByPseudo(pseudo);
    }

    @Override
    public void ajouterEventToSoiree(long idSoiree, Evenement evenement) {
        Soiree soiree = soireeRepository.getSoireeById(idSoiree);
        if(soiree != null) {
            soiree.getEvenementsPrivee().add(evenement);
            soireeRepository.save(soiree);
        }
        else throw new SoireeNotFoundException("impossible d'ajouter votre event à la soiree");

    }

    @Override
    public void ajouterEventOpenDataToSoiree(long idSoiree,  EvenementOpenData evenementOpenData) {

        Soiree soiree = soireeRepository.getSoireeById(idSoiree);
        if(soiree != null) {
            soiree.getEvenementsExterne().add(evenementOpenData);
            soireeRepository.save(soiree);
        }
        else throw new SoireeNotFoundException("impossible d'ajouter votre event Externe à la soiree");

    }

    @Override
    public void ajouterParticipantToSoiree(long idSoiree, String participant) {
        Soiree soiree = soireeRepository.getSoireeById(idSoiree);
        if(soiree != null) {
            soiree.getParticipant().add(participant);
            soireeRepository.save(soiree);
        }
        else throw new SoireeNotFoundException("impossible d'ajouter ce participant à la soiree");

    }


}
