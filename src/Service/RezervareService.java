package Service;

import Domain.Client;
import Domain.Film;
import Domain.Rezervare;
import Repository.ClientRepository;
import Repository.FilmRepository;
import Repository.RezervareRepository;

import java.util.ArrayList;
import java.util.List;

public class RezervareService {
    private FilmRepository filmRepository;
    private ClientRepository clientRepository;
    private RezervareRepository rezervareRepository;

    public RezervareService(FilmRepository filmRepository, ClientRepository clientRepository, RezervareRepository rezervareRepository) {
        this.filmRepository = filmRepository;
        this.clientRepository = clientRepository;
        this.rezervareRepository = rezervareRepository;
    }

    public void adauga(String id, String idFilm, String idClient, String data, String ora) {
        Rezervare rezervareExistenta = new Rezervare(id, idFilm, idClient, data, ora);
        if (!filmRepository.gasesteDupaId(idFilm).isInProgram()) {
            throw new RuntimeException("Filmul nu este in program");
        }
        rezervareRepository.adauga(rezervareExistenta);
        clientRepository.gasesteDupaId(idClient).setPuncteFidelitate(filmRepository.gasesteDupaId(idFilm).getPuncte());
    }

    public void actualizeaza(String id, String idFilm, String idClient, String data, String ora) {
        Rezervare rezervareExistenta = new Rezervare(id, idFilm, idClient, data, ora);
        if (filmRepository.gasesteDupaId(idFilm) != null) {
            if (!filmRepository.gasesteDupaId(idFilm).isInProgram()) {
                throw new RuntimeException("Filmul nu este in program");
            }
        } else {
            throw new RuntimeException("Nu exista niciun film cu acest id");
        }
    }
    public void sterge (String id){
        rezervareRepository.sterge(id);
    }

    public List<Rezervare> arataTot(){
        return rezervareRepository.arataTot();
    }
}



