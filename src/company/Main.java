package company;

import Domain.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import Repository.ClientRepository;
import Repository.FilmRepository;
import Repository.RezervareRepository;
import Service.ClientService;
import Service.FilmService;
import Service.RezervareService;
import UI.Console;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/sample.fxml"));
        Parent root = FXMLLoader.load();

        Controller controller = fxmlLoader.getController();

        IValidator<Film> filmValidator = new FilmValidator();
        IValidator<Client> clientValidator = new ClientValidator();
        IValidator<Rezervare> rezervareValidator = new RezervareValidator();

        IRepository <Film> filmRepository = new InMemoryRepository<>(filmValidator);
        IRepository <Client> clientRepository = new InMemoryRepository<>(clientValidator);
        IRepository <Rezervare> rezervareRepository = new InMemoryRepository<>(rezervareValidator);

        FilmService filmService = new FilmService(filmRepository);
        filmService.adauga("1",2000,20.00,"apa",true);
        filmService.adauga("2", 1990,25.00, "mama", true);
        filmService.adauga("3", 2001, 30.00,"tata", false);

        ClientService clientService = new ClientService(clientRepository);

        RezervareService rezervareService = new RezervareService(rezervareRepository);



        primaryStage.setTitle("Hello World");




        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

//public class Main {

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
        Console console = new Console (filmService, clientService, rezervareService);
        //NewConsole console = new NewConsole(filmService, clientService, rezervareService);
        //NLConsole console = new NLConsole(filmService, clientService, rezervareService);
        console.functii();
        //console.run();
    }
}


