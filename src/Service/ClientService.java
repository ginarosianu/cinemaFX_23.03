package Service;

import Domain.Client;
import Repository.ClientRepository;

import java.util.List;

public class ClientService {
    private ClientRepository repository;

    public ClientService(IRepository<Client> repository) {
        this.repository = repository;
    }

    /*  private String idClient, nume, prenume, CNP, dataNasterii, dataInregistrarii;
    private int , puncteFidelitate;*/

    public void adauga (String idClient, String nume, String prenume, String CNP, String dataNasterii, String dataInregistrarii, int puncteFidelitate) {
        Client client = new Client(idClient,nume,prenume,CNP,dataNasterii, dataInregistrarii, puncteFidelitate);
      /* if (client != null){
            if (nume.isEmpty()) {
                nume = client.getNume();
            }
            if (prenume.isEmpty()){
                prenume = client.getPrenume();
            }
            if (CNP.isEmpty()){
                CNP = client.getCNP();
            }
            if (dataNasterii.isEmpty()){
                dataNasterii = client.getDataNasterii();
            }
            if (dataInregistrarii.isEmpty()){
                dataInregistrarii = client.getDataInregistrarii();
            }
        }*/
        repository.adauga(client);
    }
    public void actualizeaza (String idClient, String nume, String prenume, String CNP, String dataNasterii, String dataInregistrarii, int puncteFidelitate) {
        Client client = new Client(idClient, nume, prenume, CNP, dataNasterii, dataInregistrarii, puncteFidelitate);
        repository.actualizeaza(client);
    }

    public void sterge (String idClient){
        repository.sterge(idClient);
    }

    public List<Client> arataTot () {
            return repository.arataTot();
    }

}