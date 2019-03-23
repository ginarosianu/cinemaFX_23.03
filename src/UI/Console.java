package UI;

import Domain.Client;
import Domain.Film;
import Domain.Rezervare;
import Service.ClientService;
import Service.FilmService;
import Service.RezervareService;

import java.util.Scanner;

public class Console {
    private FilmService filmService;
    private ClientService clientService;
    private RezervareService rezervareService;
    private Scanner scanner;

    public Console(FilmService filmService, ClientService clientService, RezervareService rezervareService) {
        this.filmService = filmService;
        this.clientService = clientService;
        this.rezervareService = rezervareService;

        this.scanner = new Scanner(System.in);
    }

    private void run() {
        System.out.println("1.Film CRUD");
        System.out.println("2.Client CRUD");
        System.out.println("3.Rezervare CRUD");
        System.out.println("x.Exit");

    }

    public void functii() {
        while (true) {
            run();
            String optiune = scanner.nextLine();
            switch (optiune) {
                case "1":
                    functiiFilmCrud();
                    break;
                case "2":
                    functiiClientCrud();
                    break;
                case "3":
                    functiiRezervareCrud();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
                    break;
            }
        }
    }


    private void functiiFilmCrud() {
        while (true) {
            arataMeniuFilm();
            String optiune = scanner.nextLine();
            switch (optiune) {
                case "1":
                    adaugareFilm();
                    break;
                case "2":
                    actualizareFilm();
                    break;
                case "3":
                    stergereFilm();
                    break;
                case "4":
                    afisareToateFilmele();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida");
                    break;
            }
        }
    }

    private void arataMeniuFilm() {
        System.out.println("1. Adauga film");
        System.out.println("2. Actualizeaza film");
        System.out.println("3. Sterge film");
        System.out.println("4. Arata toate fimele");
        System.out.println("x. Inapoi");
    }

    private void adaugareFilm() {
        try {
            System.out.print("Dati id ul filmului: ");
            String id = scanner.nextLine();
            System.out.print("Dati anul de aparitie al filmului: ");
            int anAparitie = Integer.parseInt(scanner.nextLine());
            System.out.print("Dati pretul filmului: ");
            double pret = Double.parseDouble(scanner.nextLine());
            System.out.print("Dati titlul filmului: ");
            String titlu = scanner.nextLine();
            System.out.print("Precizati daca filmul este in program (adevarat sau fals):");
            boolean inProgram = Boolean.parseBoolean(scanner.nextLine());

            filmService.adauga(id, anAparitie, pret, titlu, inProgram);

            System.out.println("Filmul a fost adaugat cu succes!");
        } catch (RuntimeException rex) {
            System.out.println("Eroare:\n" + rex.getMessage());
        }
    }

    private void actualizareFilm() {
        try {
            System.out.print("Dati un id de actualizat: ");
            String id = scanner.nextLine();
            System.out.print("Dati anul nou de aparitie: ");
            int anAparitie = Integer.parseInt(scanner.nextLine());
            System.out.print("Dati pretul nou:");
            double pret = Double.parseDouble(scanner.nextLine());
            System.out.print("Dati noul titlu: ");
            String titlu = scanner.nextLine();
            System.out.print("Precizati daca filmul este in program (adevarat sau fals):");
            boolean inProgram = Boolean.parseBoolean(scanner.nextLine());
            filmService.actualizeaza(id, anAparitie, pret, titlu, inProgram);
        } catch (RuntimeException rex) {
            System.out.print("Eroare: \n" + rex.getMessage());
        }
    }

    private void stergereFilm() {
        try {
            System.out.print("Introduceti id ul de sters:");
            String idFilm = scanner.nextLine();
            filmService.sterge(idFilm);
            System.out.print("Filmul a fost sters:");
        } catch (RuntimeException rex) {
            System.out.print("Eroare:\n" + rex.getMessage());
        }
    }

    private void afisareToateFilmele() {
        for (Film film : filmService.arataTot()) {
            System.out.print(film);
        }
    }

    private void arataMeniuClient() {
        System.out.println("1.Adauga client");
        System.out.println("2.Actualizeaza client");
        System.out.println("3.Sterge client");
        System.out.println("4.Arata toti clientii");
        System.out.println("x.Inapoi");
    }

    private void functiiClientCrud() {
        while (true) {
            arataMeniuClient();
            String optiune = scanner.nextLine();
            switch (optiune) {
                case "1":
                    adaugareClient();
                    break;
                case "2":
                    actualizareClient();
                    break;
                case "3":
                    stergereClient();
                    break;
                case "4":
                    afisareTotiClientii();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida");
                    break;
            }
        }
    }

    private void adaugareClient() {
        try {
            System.out.print("Dati id ul clientului: ");
            String id = scanner.nextLine();
            System.out.print("Dati numele clientului: ");
            String nume = scanner.nextLine();
            System.out.print("Dati prenumele clientului: ");
            String prenume = scanner.nextLine();
            System.out.print("Dati CNP ul clientului: ");
            String cnp = scanner.nextLine();
            System.out.print("Dati data nasterii clientului: ");
            String dataNastere = scanner.nextLine();
            System.out.print("Dati data inregistrarii clientului: ");
            String dataInregistrare = scanner.nextLine();
            //System.out.print ("Dati punctele clientului: ");
            //int puncte  = Integer.parseInt(scanner.nextLine());

            clientService.adauga(id, nume, prenume, cnp, dataNastere, dataInregistrare, 0);

            System.out.println("Clientul a fost adaugat cu succes!");
        } catch (RuntimeException rex) {
            System.out.println("Eroare:\n" + rex.getMessage());
        }
    }

    private void actualizareClient() {
        try {
            System.out.print("Dati id ul clientului de actualizat: ");
            String id = scanner.nextLine();
            System.out.print("Dati numele clientului de actualizat: ");
            String nume = scanner.nextLine();
            System.out.print("Dati prenumele clientului de actualizat: ");
            String prenume = scanner.nextLine();
            System.out.print("Dati CNP ul clientului de actualizat:");
            String cnp = scanner.nextLine();
            System.out.print("Dati data nasterii clientului de actualizat:");
            String dataNastere = scanner.nextLine();
            System.out.print("Dati data inregistrarii clientului:");
            String dataInregistrare = scanner.nextLine();
            System.out.print("Dati punctele clientului:");
            int puncte = Integer.parseInt(scanner.nextLine());

            clientService.actualizeaza(id, nume, prenume, cnp, dataNastere, dataInregistrare, puncte);

            System.out.println("Clientul a fost actualizat cu succes!");
        } catch (RuntimeException rex) {
            System.out.println("Eroare:\n" + rex.getMessage());
        }
    }

    private void stergereClient() {
        try {
            System.out.print("Dati id ul clientului de sters");
            String idClient = scanner.nextLine();
            clientService.sterge(idClient);
            System.out.println("Clientul a fost sters cu succes");
        } catch (RuntimeException rex) {
            System.out.println("Eroare :\n" + rex.getMessage());
        }
    }

    private void afisareTotiClientii() {
        for (Client client : clientService.arataTot()) {
            System.out.println(client);
        }
    }


    private void functiiRezervareCrud() {
        while (true) {
            arataMeniuRezervare();
            String optiune = scanner.nextLine();
            switch (optiune) {
                case "1":
                    adaugareRezervare();
                    break;
                case "2":
                    actualizareRezervare();
                    break;
                case "3":
                    stergereRezervare();
                    break;
                case "4":
                    afisareToateRezervarile();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida");
                    break;
            }
        }
    }

    private void arataMeniuRezervare() {
        System.out.println("1.Adauga rezervare");
        System.out.println("2.Actualizeaza rezervare");
        System.out.println("3.Sterge rezervare");
        System.out.println("4.Arata toate rezervarile ");
        System.out.println("x.Inapoi");
    }

    private void adaugareRezervare() {
        try {
            System.out.print("Dati id ul rezervarii:");
            String id = scanner.nextLine();
            System.out.print("Dati id ul filmului:");
            String idFilm = scanner.nextLine();
            System.out.print("Dati id ul clientulului:");
            String idClient = scanner.nextLine();
            System.out.print("Dati data rezervarii:");
            String data = scanner.nextLine();
            System.out.print("Dati ora rezervarii:");
            String ora = scanner.nextLine();

            rezervareService.adauga(id, idFilm, idClient, data, ora);
            System.out.println("rezervare adaugata cu succes!");
        } catch (RuntimeException rex) {
            System.out.print("Eroare:\n" + rex.getMessage());
        }
    }

    private void actualizareRezervare() {
        try {
            System.out.print("Dati id ul rezervarii");
            String id = scanner.nextLine();
            System.out.print("Dati id ul filmului rezervat:");
            String idFilm = scanner.nextLine();
            System.out.print("Dati id ul clientulului:");
            String idClient = scanner.nextLine();
            System.out.print("Dati data rezervarii(\\\"dd.MM.yyyy\\\"): ");
            String data = scanner.nextLine();
            System.out.print("Dati ora rezervarii(\\\"hh.mm\\\"): ");
            String ora = scanner.nextLine();

            rezervareService.actualizeaza(id, idFilm, idClient, data, ora);
        } catch (Exception rex) {
            System.out.print("Eroare:\n" + rex.getMessage());
        }
    }

    private void stergereRezervare() {
        try {
            System.out.print("Dati id ul rezervarii de sters");
            String idRezervare = scanner.nextLine();

            rezervareService.sterge(idRezervare);
        } catch (RuntimeException rex) {
            System.out.print("Eroare:\n" + rex.getMessage());
        }
    }

    private void afisareToateRezervarile() {
        for (Rezervare rezervare : rezervareService.arataTot()) {
            System.out.println(rezervare);
        }
    }


}
