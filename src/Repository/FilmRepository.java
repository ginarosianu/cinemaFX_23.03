package Repository;

import Domain.Film;
import Domain.FilmValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmRepository {

    private Map<String, Film> bazaDate=new HashMap<>();
    private FilmValidator validator;

    public FilmRepository(FilmValidator validator){
        this.validator=validator;
    }

    /**
     * gaseste un film dupa id dat;
     * @param id ;
     * @return un id;
     */
    public Film gasesteDupaId (String id){
        return bazaDate.get(id);
    }

    /**
     * adauga un film
     * @param film - filmul de adaugat
     * @throws RuntimeException daca exista deja un film cu numele dat;
     */
    public void adauga (Film film){
        if (bazaDate.containsKey(film.getIdFilm())){
            throw new RuntimeException("Exista deja un film cu acest id");
        }
        validator.valideaza(film);
        bazaDate.put(film.getIdFilm(),film);
    }
    public void actualizeaza (Film film){
        if (!bazaDate.containsKey(film.getIdFilm())){
            throw new RuntimeException("Nu exista film cu acest nume");
        }
        validator.valideaza(film);
        bazaDate.put(film.getIdFilm(),film);
    }
    /**
     * sterge filmul cu id ul dat;
     * @param id;
     * @throws RuntimeException daca filmul de sters nu exista;
     */
    public void sterge (String id){
        if (!bazaDate.containsKey(id)){
            throw new RuntimeException("Filmul cu id ul introdus nu exista.");
        }
        bazaDate.remove(id);
    }

    /**
     * reda lista cu toate filmele;
     * @return lista filmelor;
     */
    public List<Film> arataTot() {
        return new ArrayList<>(bazaDate.values());
    }
}
