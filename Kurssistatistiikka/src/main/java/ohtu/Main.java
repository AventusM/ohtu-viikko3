package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // Opiskelijanumero piilotettu git:ssä
        String studentNr = "000000000";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);
        Gson mapper = new Gson();
        Submission[] submissions = mapper.fromJson(bodyText, Submission[].class);

        //
        //Oma huomio - kesti järkyttävän pitkään laittaa vaan json-muodossa olevien kenttien nimet Submission-luokan kenttien nimiksi ja ongelma ratkesi yhtäkkiä . . .
        //

        System.out.println("Opiskelijanumero: " + studentNr + "\n");
        int exercisesDoneOverall = 0;
        int hoursWastedOverall = 0;
        for (Submission sub : submissions) {
            exercisesDoneOverall += sub.getDoneExercisesAmount();
            hoursWastedOverall += sub.getHours();
            System.out.println(sub);
        }

        System.out.println("\nyhteensä: " + exercisesDoneOverall + " tehtävää " + hoursWastedOverall + " tuntia");
    }
}
