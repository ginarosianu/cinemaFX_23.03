package UI;
import Domain.Client;
import Domain.Film;
import Domain.Rezervare;
import Service.ClientService;
import Service.FilmService;
import Service.RezervareService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.Scanner;



public class NLConsole {
    private FilmService filmService;
    private ClientService clientService;
    private RezervareService rezervareService;
    private Scanner scanner;

    public NLConsole(FilmService filmService, ClientService clientService, RezervareService rezervareService) {
        this.filmService = filmService;
        this.clientService = clientService;
        this.rezervareService = rezervareService;
        this.scanner = new Scanner(System.in);
    }

    private void arataMeniu() {
        System.out.println("Optiunea ta:");

        System.out.println("adauga film: id, an aparitie, pret bilet, titlu, in program");
        System.out.println("actualizeaza film: id, an aparitie, pret bilet, titlu, in program:");
        System.out.println("sterge film: id");
        System.out.println("afiseaza filmele");

        System.out.println("adauga client: id, nume, prenume, cnp, data nasterii, data inregistrarii, puncte");
        System.out.println("actualizeaza client: id, nume, prenume, cnp, data nasterii, data inregistrarii, puncte:");
        System.out.println("sterge client: id");
        System.out.println("afiseaza clientii");

        System.out.println("adauga rezervare: id, id film, id client, data, ora");
        System.out.println("actualizeaza rezervare: id, id film, id client, data, ora:");
        System.out.println("sterge rezervare: id");
        System.out.println("afiseaza rezerevarile");

        System.out.println();
        System.out.println("x.Iesire");
    }

    private String[] splitSring(String string) {
        String[] coloane = string.split(",");
        return coloane;
    }

    public void run() {
        while (true) {
            arataMeniu();
            String optiune = scanner.nextLine();
            String[] intrare = splitSring(optiune);
            if (intrare[0] != null) {
                switch (intrare[0]) {
                    case "adauga film":
                        adaugareFilm(intrare);
                        break;

                    case "actualizeaza film":
                        actualizareFilm(intrare);
                        break;

                    case "sterge film":
                        stergereFilm(intrare);
                        break;

                    case "afiseaza filmele":
                        afisareFilme(intrare);
                        break;

                    case "adauga client":
                        adaugareClient(intrare);
                        break;

                    case "actualizeaza client":
                        actualizareClient(intrare);
                        break;

                    case "sterge client":
                        stergereClient(intrare);
                        break;

                    case "afiseaza clientii":
                        afisareClienti(intrare);
                        break;

                    case "adauga rezervare":
                        adaugareRezervare(intrare);
                        break;

                    case "actualizeaza rezervare":
                        actualizareRezervare(intrare);
                        break;

                    case "sterge rezervare":
                        stergereRezervare(intrare);
                        break;

                    case "afiseaza rezervarile":
                        afisareRezervarile(intrare);
                        break;
                }
            }
        }
    }


    private void adaugareFilm(String[] intrare) {
        try {
            if (intrare.length == 6) {
                String idFilm = intrare[1];
                int anAparitie = Integer.parseInt(intrare[2]);
                double pretBilet = Double.parseDouble(intrare[3]);
                String titlu = intrare[4];
                boolean inProgram = Boolean.parseBoolean(intrare[5]);


                filmService.adauga(idFilm, anAparitie, pretBilet, titlu, inProgram);
            } else {
                throw new RuntimeException("Optiune invalida");
            }
        } catch (Exception ex) {
            System.out.println("Eroare: \n" + ex.getMessage());
        }
    }

    private void actualizareFilm(String[] intrare) {
        try {
            if (intrare.length == 6) {
                String idFilm = intrare[1];
                int anAparitie = Integer.parseInt(intrare[2]);
                double pretBilet = Double.parseDouble(intrare[3]);
                String titlu = intrare[4];
                boolean inProgram = Boolean.parseBoolean(intrare[5]);


                filmService.actualizeaza(idFilm, anAparitie, pretBilet, titlu, inProgram);
            } else {
                throw new RuntimeException("Optiune invalida");
            }
        } catch (Exception ex) {
            System.out.println("Eroare: \n" + ex.getMessage());
        }
    }


    private void stergereFilm(String[] intrare) {
        try {
                if (intrare.length == 2){
                    String id = intrare[1];
                    filmService.sterge(id);

                    System.out.println("Filmul a fost sters!");
                }else {
                    throw new RuntimeException("Optiune invalida!");
                }
            }catch (Exception ex){
                System.out.println ("Eroare: \n" + ex.getMessage());
        }
    }


    private void afisareFilme(String[] intrare) {
        if (intrare.length == 1){
            for (Film film : filmService.arataTot()){
                System.out.println(film);
            }
        }else {
            System.out.println("Optiune invalida!");
        }
    }


    private void adaugareClient(String[] intrare) {
        try {
            if (intrare.length == 8) {
                String idClient = intrare[1];
                String nume = intrare[2];
                String prenume = intrare[3];
                String cnp = intrare[4];
                String dataNasterii = intrare[5];
                String dataInregistrarii = intrare[6];
                int puncte = Integer.parseInt(intrare[7]);

                clientService.adauga(idClient, nume, prenume, cnp, dataNasterii, dataInregistrarii, puncte);
            } else {
                throw new RuntimeException("Optiune invalida");
            }
        } catch (Exception ex) {
            System.out.println("Eroare: \n" + ex.getMessage());
        }
    }

    private void actualizareClient(String[] intrare) {
        try {
            if (intrare.length == 8) {
                String idClient = intrare[1];
                String nume = intrare[2];
                String prenume = intrare[3];
                String cnp = intrare[4];
                String dataNasterii = intrare[5];
                String dataInregistrarii = intrare[6];
                int puncte = Integer.parseInt(intrare[7]);

                clientService.actualizeaza(idClient, nume, prenume, cnp, dataNasterii, dataInregistrarii, puncte);
            } else {
                throw new RuntimeException("Optiune invalida");
            }
        } catch (Exception ex) {
            System.out.println("Eroare: \n" + ex.getMessage());
        }
    }

    private void stergereClient(String[] intrare) {
        try {
            if (intrare.length == 2){
                String id = intrare[1];
                clientService.sterge(id);

                System.out.println("Clientul a fost sters!");
            }else {
                throw new RuntimeException("Optiune invalida!");
            }
        }catch (Exception ex){
            System.out.println ("Eroare: \n" + ex.getMessage());
        }
    }

    private void afisareClienti(String[] intrare) {
        if (intrare.length == 1){
            for (Client client : clientService.arataTot()){
                System.out.println(client);
            }
        } else {
            System.out.println ("Optiune invalida!");
        }
    }


    private void adaugareRezervare(String[] intrare) {
        try {
            if (intrare.length == 6) {
                String id = intrare[1];
                String idFilm = intrare[2];
                String idClient = intrare[3];
                String data = intrare[4];
                String ora = intrare[5];

                rezervareService.adauga(id, idFilm, idClient, data, ora);
            } else {
                throw new RuntimeException("Invalid option!");
            }
        } catch (RuntimeException ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }


    private void actualizareRezervare(String[] intrare) {
        try {
            if (intrare.length == 5) {
                String id = intrare[1];
                String idFilm = intrare[2];
                String idClient = intrare[3];
                String data = intrare[4];
                String ora = intrare[5];

                rezervareService.actualizeaza(id, idFilm, idClient, data, ora);
            } else {
                throw new RuntimeException("Invalid option!");
            }
        } catch (RuntimeException ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }


    private void stergereRezervare(String[] intrare) {
        try {
            if (intrare.length == 2){
                String id = intrare[1];
                rezervareService.sterge(id);
                System.out.println("Rezervarea a fost stearsa!");
            } else {
                throw new RuntimeException("Optiune invalida");
            }
        }catch (Exception ex){
            System.out.println("Eroare: \n" + ex.getMessage());
        }
    }
    
    private void afisareRezervarile(String[] intrare) {
        if (intrare.length == 1) {
            for (Rezervare rezervare : rezervareService.arataTot()) {
                System.out.println(rezervare);
            }
        }
        else {
                System.out.println ("Optiune Invalida!");
            }
        }
    }



