package Repository;

import Domain.Client;
import Domain.ClientValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientRepository {
    private Map<String, Client> bazaDate = new HashMap<>();
    private ClientValidator validator;

    public ClientRepository (ClientValidator validator){
        this.validator = validator;
    }

    public Client gasesteDupaId (String id){
        return bazaDate.get(id);
    }

   /*
     * adauga sau actualizeaza un client;
     * @param client- clientul de adaugat sau actualizat;

    public void adaugaSauActualizeaza (Client client){
        validator.valideaza(client);
        bazaDate.put(client.getIdClient(), client);
    }
    */

    /**
     * adauga un client in baza de date;
     * @param client
     */

    public void adauga (Client client){
        if (bazaDate.containsKey(client.getIdClient())) {
            throw new RuntimeException("Acest client exista deja.");
        }
            validator.valideaza(client);
            bazaDate.put(client.getIdClient(), client);
    }


    /**
     * actualizeaza baza de date cu un client dat;
     * @param client
     */
    public void actualizeaza (Client client){
        if (!bazaDate.containsKey(client.getIdClient())){
            throw new RuntimeException("Acest client nu exista");
        }
        validator.valideaza(client);
        bazaDate.put(client.getIdClient(), client);
    }

    /**
     * sterge un client ;
     * @param id
     */
    public void sterge (String id){
        if (!bazaDate.containsKey(id)){
            throw new RuntimeException("Nu exista clientul cu id ul de sters.");
        }
        bazaDate.remove(id);
    }

    /**
     * arata lista tuturor clientilor;
     * @return
     */
    public List<Client> arataTot (){
        return new ArrayList<>(bazaDate.values());
    }
}
