package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RezervareValidator {

    public void valideaza(Rezervare rezervare) {


        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        try {
            format.parse(rezervare.getData());
        } catch (ParseException pe) {
            throw new RuntimeException("Formatul datei nu este valid");
        }
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        try {
            format.parse(rezervare.getOra());
        } catch (ParseException pe) {
            throw new RuntimeException("Formatul orei nu este valid");
        }

    }





}
