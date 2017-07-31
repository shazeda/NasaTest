package nasa.apiTest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by shazeda on 7/30/17.
 */
public class SoundAPITest {

    final static String url = "https://api.nasa.gov/planetary/sounds";

    @Test
    //Test Case ID: 1
    public void testWithFiveLimit() throws Exception {

        HttpResponse<JsonNode> response = Unirest.get(url + "?q=moon&limit=5&api_key=DEMO_KEY").asJson();
        print(response.getStatus());
        print(response.getBody());

        Assert.assertEquals(response.getStatus(), 200);
        Assert.assertEquals(response.getBody().getObject().get("count"), 5);


    }

    @Test
    //Test Case ID: 2
    public void testWithFiftyLimit() throws Exception {

        HttpResponse<JsonNode> response = Unirest.get(url + "?q=moon&limit=50&api_key=DEMO_KEY").asJson();
        print(response.getStatus());
        print(response.getBody());

        Assert.assertEquals(response.getStatus(), 200);
        Assert.assertEquals(response.getBody().getObject().get("count"), 50);

    }

    @Test
    //Test Case ID: 3
    public void testWithoutApiKey() throws Exception {

        HttpResponse<JsonNode> response = Unirest.get(url + "?q=moon&limit=50").asJson();
        print(response.getStatus());
        print(response.getBody());

        Assert.assertEquals(response.getStatus(), 403);
        Assert.assertEquals(response.getBody().getObject().getJSONObject("error").get("code"), "API_KEY_MISSING");
        Assert.assertEquals(response.getBody().getObject().getJSONObject("error").get("message"), "No api_key was supplied. Get one at https://api.nasa.gov");

    }

    public void print(Object obj) {
        System.out.println(obj);
    }

}
