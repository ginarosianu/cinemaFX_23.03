package Repository;

import Domain.Rezervare;
import Domain.RezervareValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RezervareRepository {

    private Map<String, Rezervare> bazaDate = new HashMap<>();
    private RezervareValidator validator;

    public RezervareRepository(RezervareValidator validator) {
        this.validator = validator;
    }

    public Rezervare gasesteDupaId (String id){
        return bazaDate.get(id);
    }

    /**
     * adauga o tranzactie;
     * @param rezervare de adaugat sau actualizat ;
     */
    public void adauga (Rezervare rezervare){
        if (bazaDate.containsKey(rezervare.getId())){
            throw new RuntimeException("Exista deja o rezervare cu acest id");
        }
        validator.valideaza(rezervare);
        bazaDate.put(rezervare.getId(), rezervare);
    }

    /**
     * actualizeaza baza de date cu o noua rezervare
     * @param rezervare
     */
    public void actualizeaza (Rezervare rezervare){
        if (!bazaDate.containsKey(rezervare.getId())){
            throw new RuntimeException("Nu exista rezervare cu acest id.");
        }
        validator.valideaza(rezervare);
        bazaDate.put(rezervare.getId(),rezervare);
    }

    /**
     * sterge o rezervare cu un id dat;
     * @param id id ul tranzactiei de sters;
     */
    public void sterge (String id){
        if (!bazaDate.containsKey(id)){
            throw new RuntimeException("Nu exista tranzactia cu acest id.");
        }
        bazaDate.remove(id);
    }
    public List<Rezervare> arataTot() {
        return new ArrayList<>(bazaDate.values());
    }
}

