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
        while((inputLine = urlInput.readLine())!=null) {
            System.out.println(inputLine);
        }


        urlInput.close();
        textInput.close();
    }
}
