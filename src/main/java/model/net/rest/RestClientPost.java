package model.net.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * client restful, in order to used this class you need open the connection,
 * send or receive data and close the connection.
 *
 * @author skuarch
 */
public class RestClientPost extends Restful {

    private String path = null;
    private URL url = null;
    private static final String REQUEST_METHOD = "POST";

    //==========================================================================
    /**
     * create a instance.
     *
     * @param path String url of webservice
     */
    public RestClientPost(String path) {
        this.path = path;
    } // end RestfulClient

    //==========================================================================
    /**
     * open connection with remote server. *
     *
     * @throws IOException in case of error
     */
    @Override
    public void openConnection() throws IOException {

        if (path == null || path.length() < 1) {
            throw new NullPointerException("path is null or empty");
        }

        if (REQUEST_METHOD == null || REQUEST_METHOD.length() < 1) {
            throw new NullPointerException("requestMethod is null or empty");
        }

        url = new URL(path);
        hurlc = (HttpURLConnection) url.openConnection();
        hurlc.setInstanceFollowRedirects(false);
        hurlc.setRequestMethod(REQUEST_METHOD);
        hurlc.setRequestProperty("charset", UTF_8);
        hurlc.setUseCaches(false);
        hurlc.setDefaultUseCaches(false);
        hurlc.setRequestProperty("Pragma", "no-cache");
        hurlc.setRequestProperty("Cache-Control", "no-cache");
        hurlc.setRequestProperty("Expires", "-1");

    } // end openConnection

    //==========================================================================
    /**
     * setter for any property.
     *
     * @param property String
     * @param value String
     * @throws IOException if something wrong happens
     */
    @Override
    public void setRequestProperty(String property, String value) throws IOException {

        if (property == null || property.length() < 1) {
            throw new IllegalArgumentException("property is null or empty");
        }

        if (value == null || value.length() < 1) {
            throw new IllegalArgumentException("value is null or empty");
        }

        if (hurlc == null) {
            throw new IOException(HURLC_IS_NULL);
        }

        hurlc.setRequestProperty(property, value);
    }

    //==========================================================================
    /**
     * write text to web server.
     *
     * @param text String
     * @throws IOException in case of error
     */
    @Override
    public void sendText(String text) throws IOException {

        if (text == null || text.length() < 1) {
            throw new NullPointerException("text is null");
        }

        if (hurlc == null) {
            throw new IOException(HURLC_IS_NULL);
        }

        hurlc.setDoOutput(true);
        outputStream = hurlc.getOutputStream();
        outputStream.write(text.getBytes(Charset.forName(UTF_8)));
        outputStream.flush();

    } // end sendText

    //==========================================================================
    /**
     * receive text from web service.
     *
     * @return String
     * @throws IOException in case of error
     */
    @Override
    public String receiveText() throws IOException {

        if (hurlc == null) {
            throw new IOException(HURLC_IS_NULL);
        }

        String tmp;
        StringBuilder stringBuilder = new StringBuilder();
        inputStream = hurlc.getInputStream();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName(UTF_8)));

        while ((tmp = bufferedReader.readLine()) != null) {
            stringBuilder.append(tmp);
        }

        return stringBuilder.toString();

    }

    //==========================================================================
    /**
     * set the credentials for basic authentication.
     *
     * @param credentials String
     * @throws IOException in case of error
     */
    public void setAuth(String credentials) throws IOException {
        super.setAuthentication(credentials);
    }

} // end class
