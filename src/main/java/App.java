import com.spotify.apollo.Environment;
import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import com.spotify.apollo.route.Route;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws LoadingException {
        HttpService.boot(App::init, "my-app", args);
    }

    static void init(Environment environment) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");
        String userName = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + userName);  // Output user input
        environment.routingEngine()
                .registerAutoRoute(Route.sync("GET", "/", rc -> "Hello, ".concat(userName).concat("!")));
    }
}
