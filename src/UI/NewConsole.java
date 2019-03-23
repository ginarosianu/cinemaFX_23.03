package UI;

import Domain.Client;
import Domain.Film;
import Domain.Rezervare;
import Service.ClientService;
import Service.FilmService;
import Service.RezervareService;

import java.util.Scanner;

public class NewConsole {
    private FilmService filmService;
    private ClientService clientService;
    private RezervareService rezervareService;
    private Scanner scanner;

    public NewConsole(FilmService filmService, ClientService clientService, RezervareService rezervareService) {
        this.filmService = filmService;
        this.clientService = clientService;
        this.rezervareService = rezervareService;
        this.scanner = new Scanner(System.in);
    }


    public void run() {
        while (true) {

            System.out.println("Alegeti optiunea, x pentru iesire");
            String optiune = scanner.nextLine();
            String s[] = null;
            s = optiune.split(",");

            switch (s[0]) {
                case "adaugaFilm": {
                    filmService.adauga(s[1], Integer.parseInt(s[2]), Double.parseDouble(s[3]), s[4], Boolean.parseBoolean(s[5]));
                    break;
                }

                case "adaugaClient": {
                    clientService.adauga(s[1], s[2], s[3], s[4], s[5], s[6], Integer.parseInt(s[7]));
                    break;
                }
                case "adaugaRezervare": {
                    rezervareService.adauga(s[1], s[2], s[3], s[4], s[5]);
                    break;
                }

                case "actualizeazaFilm": {
                    filmService.actualizeaza(s[1], Integer.parseInt(s[2]), Double.parseDouble(s[3]), s[4], Boolean.parseBoolean(s[5]));
                    break;
                }
                case "actualizeazaClient": {
                    clientService.actualizeaza(s[1], s[2], s[3], s[4], s[5], s[6], Integer.parseInt(s[7]));
                    break;
                }
                case "actualizeazaRezervare": {
                    rezervareService.actualizeaza(s[1], s[2], s[3], s[4], s[5]);
                    break;
                }
                case "stergeFilm": {
                    filmService.sterge(s[1]);
                    break;
                }

                case "stergeClient": {
                    clientService.sterge(s[1]);
                    break;
                }
                case "stergeRezervare": {
                    rezervareService.sterge(s[1]);
                    break;
                }
                case "afiseazaFilmele": {
                    for (Film film : filmService.arataTot()) {
                        System.out.println(film);
                    }
                    break;
                }
                case "afiseazaClientii": {
                    for (Client client : clientService.arataTot()) {
                        System.out.println(client);
                    }
                    break;
                }

                case "afiseazaRezervarile": {
                    for (Rezervare rezervare : rezervareService.arataTot()) {
                        System.out.println(rezervare);
                    }
                    break;
                }

                case "x":
                    return;

                default: {
                    System.out.println("Optiune invalida");
                    break;
                }
            }
        }
    }
}
