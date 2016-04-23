package model.logic;

import java.io.IOException;
import model.net.rest.RestClientGet;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Wrapper for RestClientGet.
 *
 * @author skuarch
 */
public final class RestClientGetAdapter {

    //==========================================================================
    private RestClientGetAdapter() {
    }

    //==========================================================================
    public static JSONArray receive(String url) throws IOException {

        if (url == null || url.length() < 1) {
            throw new IllegalArgumentException("url is null or empty");
        }

        RestClientGet restClientGet = new RestClientGet(url);
        JSONArray jsonArray = null;

        try {

            restClientGet.openConnection();
            restClientGet.setAuth(Constants.CREDENTIALS);
            String result = restClientGet.receiveText();
            jsonArray = new JSONArray(result);

        } catch (IOException | JSONException e) {
            throw e;
        } finally {
            restClientGet.closeConnection();
            restClientGet = null;
        }

        return jsonArray;

    }

}
