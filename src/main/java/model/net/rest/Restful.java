package model.net.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Map;

/**
 * abstract class to create a restful client connection.
 *
 * @author skuarch
 */
public abstract class Restful {

    protected OutputStream outputStream = null;
    protected InputStream inputStream = null;
    protected BufferedReader bufferedReader = null;
    protected HttpURLConnection hurlc = null;
    protected static final String UTF_8 = "utf-8";
    protected static final String HURLC_IS_NULL = "hurlc is null";

    //==========================================================================
    /**
     * establish the connection.
     *
     * @throws IOException in case of error
     */
    protected abstract void openConnection() throws IOException;

    //==========================================================================
    /**
     * set property to the connection.
     *
     * @param property String
     * @param value String
     * @throws IOException in case of error
     */
    protected abstract void setRequestProperty(String property, String value) throws IOException;

    /**
     * send text to remote server.
     *
     * @param text String
     * @throws IOException in case of error
     */
    protected abstract void sendText(String text) throws IOException;

    /**
     * receive test from remote host.
     *
     * @return String
     * @throws IOException in case of error
     */
    protected abstract String receiveText() throws IOException;

    //==========================================================================
    /**
     * set credentials.
     *
     * @param credentials String
     * @throws IOException in case of error
     */
    protected void setAuthentication(String credentials) throws IOException {

        if (hurlc == null) {
            throw new IOException("hurlc is null");
        }

        if (credentials == null || credentials.length() < 1) {
            throw new IllegalArgumentException("creadentials are empty or null");
        }

        String encoding = Base64.getEncoder().encodeToString(credentials.getBytes(Charset.forName("utf-8")));
        hurlc.setRequestProperty("Authorization", String.format("Basic %s", encoding));

    }

    //==========================================================================
    /**
     * close connection.
     *
     * @throws java.io.IOException in case of error
     */
    public final void closeConnection() throws IOException {

        disconnectURL(hurlc);
        closeOutputStream(outputStream);
        closeInputStream(inputStream);
        closeBufferedReader(bufferedReader);

    } // end closeConnection

    //==========================================================================
    /**
     * disconnect from URL.
     *
     * @param hurlc HttpURLConnection
     */
    protected final void disconnectURL(HttpURLConnection hurlc) {
        if (hurlc != null) {
            hurlc.disconnect();
        }
    }

    //==========================================================================
    /**
     * close OutputStream.
     *
     * @param outputStream OutputStream
     * @throws IOException in case of error
     */
    protected final void closeOutputStream(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.close();
        }
    }

    //==========================================================================
    /**
     * close InputStream.
     *
     * @param inputStream InputStream
     * @throws IOException in case of error
     */
    protected final void closeInputStream(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            inputStream.close();
        }
    }

    //==========================================================================
    /**
     * close BufferedReader.
     *
     * @param bufferedReader BufferedReader
     * @throws IOException in case of error.
     */
    protected final void closeBufferedReader(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader != null) {
            bufferedReader.close();
        }
    }

    //==========================================================================
    /**
     * creates query parameters.
     *
     * @param parameters Map
     * @return String
     */
    public String getQueryParameters(Map<String, Object> parameters) {

        StringBuilder sb = new StringBuilder();

        parameters.entrySet().stream().forEach((entrySet) -> {
            String key = entrySet.getKey();
            Object value = entrySet.getValue();
            sb.append(key).append("=").append(value).append("&");
        });

        return sb.toString();

    }

}
