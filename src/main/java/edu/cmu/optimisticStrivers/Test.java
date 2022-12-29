package edu.cmu.optimisticStrivers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ClassName: Test
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/22 3:05 PM
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.doPopulationSearch();
//        test.fetch("https://api.census.gov/data/2020/dec/pl?get=NAME,P1_001N&for=state:42&key=80fba66b86f6ad2fc0d6b233dabbec9f77987ca9");
    }
    public String fetch(String urlString) {
        String response = "";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String str;
            // Read each line of "in" until done, adding each to "response"
            while ((str = in.readLine()) != null) {
                // str is one line of text readLine() strips newline characters
                // to get the html response
                response += str;
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Eeek, an exception");
            // Do something reasonable.  This is left for students to do.
        }
        System.out.println(response);
        return response;
    }
    public String doPopulationSearch() throws IOException {
        String stateFIPS = "42";
        String populationURL = String.format("https://api.census.gov/data/2020/dec/pl?get=NAME,P1_001N&for=state:%s&key=%s",stateFIPS,"80fba66b86f6ad2fc0d6b233dabbec9f77987ca9");

        // Fetch the page
        String response = "";
        response = fetch(populationURL);
        System.out.println(response);
//        // get the population
//        int cutLeft = response.indexOf("Pennsylvania");
//        cutLeft = response.indexOf("," , cutLeft) + 2;
//        int cutRight = response.indexOf(",", cutLeft) - 1;
//        String population = response.substring(cutLeft, cutRight);
//        System.out.println(population);
//        return population;
        return null;
    }
}
