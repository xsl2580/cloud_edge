import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ScheduleProblemSolver {

    public static void main(String[] args) throws Exception {
        String url = "http://localhost:7777/sort?numbers=3,1,4,1,5,9,2,6,5,3,5";
        int[] sortedNumbers = sortNumbers(url);
        System.out.println(Arrays.toString(sortedNumbers));
    }

    private static int[] sortNumbers(String url) throws IOException, JSONException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpget = new HttpGet(url);
            try (CloseableHttpResponse response = httpclient.execute(httpget)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    JSONArray jsonArray = new JSONArray(result);
                    int[] sortedNumbers = new int[jsonArray.length()];
                    for (int i = 0; i < jsonArray.length(); i++) {
                        sortedNumbers[i] = jsonArray.getInt(i);
                    }
                    return sortedNumbers;
                }
            }
        }
        return null;
    }

}

