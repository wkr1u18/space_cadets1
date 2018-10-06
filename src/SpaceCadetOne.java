import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.*;
import java.io.*;

public class SpaceCadetOne {

    public static void main (String[] args) throws Exception {

        System.out.println("Enter the university id:");
        BufferedReader textInput = new BufferedReader(new InputStreamReader(System.in));
        String textId = textInput.readLine();
        String textUrl = "https://www.ecs.soton.ac.uk/people/" + textId;

        URL personUrl = new URL(textUrl);
        BufferedReader urlInput = new BufferedReader(new InputStreamReader(personUrl.openStream()));
        String inputLine;
        String searchedPattern = new String("property=\"name\">");
        int startPosition = -1, endPosition=-1;
        while((inputLine = urlInput.readLine())!=null) {
            startPosition = inputLine.indexOf(searchedPattern);
            if (startPosition>0) {
                endPosition = inputLine.indexOf('<', startPosition);
                System.out.println(inputLine.substring(startPosition+searchedPattern.length(),endPosition));
                System.exit(0);
            }
        }
        System.out.println("Could not find this person in ecs database");
        System.exit(0);


        urlInput.close();
        textInput.close();
    }
}
