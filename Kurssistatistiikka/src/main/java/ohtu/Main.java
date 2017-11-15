package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
//         Opiskelijanumero piilotettu git:ssä
        String studentNr = "";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println(bodyText);
        Gson mapper = new Gson();
        Submission[] taskSubmissions = mapper.fromJson(bodyText, Submission[].class);

        String newUrl = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        String newBodyText = Request.Get(newUrl).execute().returnContent().asString();
//        System.out.println("json-muotoinen data (2): ");
//        System.out.println(bodyText);
        Gson newMapper = new Gson();
        GeneralCourseInfo gci = newMapper.fromJson(newBodyText, GeneralCourseInfo.class);

        System.out.println("Opiskelijanumero: " + studentNr + "\n");
        int exercisesDoneOverall = 0;
        int hoursWastedOverall = 0;
        for (Submission sub : taskSubmissions) {
            exercisesDoneOverall += sub.getDoneExercisesAmount();
            hoursWastedOverall += sub.getHours();
            String maxNykyisellaViikolla = gci.getMaxPerWeek(sub.getWeek());
            System.out.println(sub.attachMaxTasksAvailablePerWeek(maxNykyisellaViikolla));
        }

        System.out.println("\nyhteensä: " + exercisesDoneOverall + " tehtävää " + hoursWastedOverall + " tuntia");

    }
}
