package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.zip.DataFormatException;

public class ClientValidator {

    public void valideaza(Client client) {
        if (client.getNume() == null ||  client.getNume().isEmpty()){
            throw new
                    RuntimeException("Campul nume este obligatoriu.");
        }

        if (client.getPrenume() == null || client.getPrenume().isEmpty()){
            throw new RuntimeException("Campul prenume este obligatoriu");
        }

        SimpleDateFormat format = new SimpleDateFormat ("dd.mm.yyyy");
        try {
            format.parse(client.getDataNasterii());
        } catch (ParseException pe) {
            throw new RuntimeException("Data nasterii nu este in formatul corect.");
        }
        try {
            format.parse(client.getDataInregistrarii());
        } catch (ParseException e) {
            throw new RuntimeException("Data inregistrii nu este in formatul corect.");
        }

        if (client.getCNP().length() != 13){
            throw new RuntimeException("CNP ul trebuie sa contina 13 caractere");
        }
         if (client.getCNP().charAt(0) < '1' || client.getCNP().charAt(0) > '8'){
             throw new RuntimeException("CNP ul nu este valid");         }
    }

}