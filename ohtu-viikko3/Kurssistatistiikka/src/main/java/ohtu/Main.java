package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/" + studentNr + "/submissions";
        String courseUrl = "https://studies.cs.helsinki.fi/courses/courseinfo";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String courseText = Request.Get(courseUrl).execute()
                .returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Course[] courses = mapper.fromJson(courseText, Course[].class);

        System.out.println("Opiskelijanumero: " + studentNr + "\n");

        for (Course course : courses) {

            int allSubmitted = 0;
            int allHours = 0;
            boolean hasSubmission = false;
            for (Submission submission : subs) {

                if (course.getName().contains(submission.getCourse())) {

                    allSubmitted += submission.getExercises().length;
                    allHours += submission.getHours();
                    if (!hasSubmission) {
                        hasSubmission = true;
                        System.out.println("\n");
                        System.out.println(course.getFullname() + " " + course.getTerm() + " " + course.getYear() + "\n");
                    }

                    System.out.println("Viikko" + submission.getWeek());
                    System.out.println("  tehtyjä tehtäviä "
                            + submission.getExercises().length + "/"
                            + course.getExercises()[submission.getWeek()]
                            + " aikaa kului " + submission.getHours()
                            + " tehdyt tehtävät: " + Arrays.toString(submission.getExercises()));
                }
            }

            if (hasSubmission) {
                System.out.println("yhteensä: " + allSubmitted + "/" + course.countAllExercises()
                        + "tehtävää " + allHours + "tuntia");

            }
        }

    }
}
