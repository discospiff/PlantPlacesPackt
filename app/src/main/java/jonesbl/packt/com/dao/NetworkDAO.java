package jonesbl.packt.com.dao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Given a URL, return the data from that URL as a String.
 * Created by ucint on 10/27/2016.
 */
public class NetworkDAO
{
    public String fetch(String uri) throws IOException {
        // a string builder will accumulate a collection of strings.
        StringBuilder sb = new StringBuilder();

        // open the connection to this URL.
        URL url = new URL(uri);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            // we're reading in stuff.
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));

            // the line we're reading.
            String inputLine;

            // keep reading, until we run out of lines to read.
            while ((inputLine = bin.readLine()) != null) {
                sb.append(inputLine);
            }
        } finally {
            urlConnection.disconnect();
        }
        return sb.toString();

    }
}