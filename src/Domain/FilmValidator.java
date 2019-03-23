package Domain;

public class FilmValidator {

    public void valideaza (Film film)  {
        if ((film.getAnAparitie() <= 1950) && (film.getAnAparitie() >= 2019)) {
            throw new RuntimeException("Anul aparitiei trebuie sa fie cuprins intre 1950 si 2019:");
        }
        if (film.getTitlu() == null || film.getTitlu().isEmpty()){
            throw new RuntimeException("Adaugati titlul filmului:");
        }

        if (film.getPretBilet() <= 0){
            throw new RuntimeException("Pretul biletului tb sa fie strict pozitiv:");
        }
    }


}
