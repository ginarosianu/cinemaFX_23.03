package com.company;

import Domain.ClientValidator;
import Domain.ClientValidator;
import Domain.FilmValidator;
import Domain.RezervareValidator;
import Repository.ClientRepository;
import Repository.FilmRepository;
import Repository.RezervareRepository;
import Service.ClientService;
import Service.FilmService;
import Service.RezervareService;
import UI.Console;
import UI.NLConsole;
import UI.NewConsole;

public class Main {

    public static void main(String[] args) {
        FilmValidator filmValidator = new FilmValidator();
        ClientValidator clientValidator = new ClientValidator();
        RezervareValidator rezervareValidator = new RezervareValidator();

        FilmRepository filmRepository = new FilmRepository(filmValidator);
        ClientRepository clientRepository = new ClientRepository(clientValidator);
        RezervareRepository rezervareRepository = new RezervareRepository(rezervareValidator);

        FilmService filmService = new FilmService(filmRepository);
        ClientService clientService = new ClientService(clientRepository);
        RezervareService rezervareService = new RezervareService(filmRepository, clientRepository, rezervareRepository);
        //Console console = new Console (filmService, clientService, rezervareService);
        //NewConsole console = new NewConsole(filmService, clientService, rezervareService);
        NLConsole console = new NLConsole(filmService, clientService, rezervareService);
        //console.functii();
        console.run();
    }
}