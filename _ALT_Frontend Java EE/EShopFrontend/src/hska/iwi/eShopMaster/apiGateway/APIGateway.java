package hska.iwi.eShopMaster.apiGateway;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.*;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.mashape.unirest.request.body.Body;
import com.mashape.unirest.request.body.RequestBodyEntity;

import hska.iwi.eShopMaster.model.database.dataobjects.*;

public class APIGateway {

	/* server and port configuration */
	final static String URL_AC = "http://localhost";
	final static String PORT_AC = ":8070";
	final static String URLAC = URL_AC + PORT_AC + "/";

	final static String URL_PC = "http://localhost";
	final static String PORT_PC = ":8090";
	final static String URLPC = URL_PC + PORT_PC + "/";

	/*
	 * Rudimentary HTTP-Methods.
	 */

	/* U S E R A C O U N T */

	public static Req account_GET(String sUser, String sPass) throws UnirestException {
		boolean uState = false;

		HttpResponse<String> g = Unirest.get(URLAC + "account/{user}").routeParam("user", sUser).header("pass", sPass)
				.asObject(String.class);

		uState = Boolean.valueOf(g.getBody());

		return new Req(g.getStatus(), uState);
	}

	public void account_PUT(String sUser) {
		HttpRequestWithBody p = Unirest.put(URLAC + "account/" + sUser).header("accept", "application/json");
	}

	public void account_DELETE(String sUser, String sPass) {
		HttpRequestWithBody d = Unirest.delete(URLAC + "account/" + sUser).header("accept", "application/json");
	}

	public static Req account_POST(String sUser, String sPass) throws UnirestException {
		HttpResponse<JsonNode> p = Unirest.post(URLAC + "account/").header("accept", "application/json")
				.header("user", sUser).header("pass", sPass).asJson();

		return new Req(p.getStatus(), null);
	}

	/* C A T E G O R Y */

	public static void category_POST(String id) throws UnirestException {
		HttpResponse<JsonNode> p = Unirest.post(URLPC + "category/").header("accept", "application/json")
				.header("id", id).asJson();
	}

	public static List<Category> category_GET() throws JSONException, UnirestException {
		List<Category> lst = new ArrayList<Category>();		

		HttpResponse<JsonNode> g = Unirest.get(URLPC + "category/").asJson();

		JsonNode r = g.getBody();

		JSONArray ca = r.getArray();

		for (int i = 0; i < ca.length(); i++) {
			JSONObject cactual = ca.getJSONObject(i);

			Category cTemp = new Category(cactual.getString("id"));
			cTemp.setName(String.valueOf(cactual.getInt("name")));
					
			lst.add(cTemp);
		}

		return lst;
	}

	public static void category_DELETE(String id) throws UnirestException {
		HttpResponse<String> d = Unirest.delete(URLPC + "category/" + id).header("accept", "application/json").asString();
	}

	/* P R O D U C T */

	public static Product product_GET(String id) throws JSONException, UnirestException {
		HttpResponse<JsonNode> g = Unirest.get(URLPC + "product/" + id).header("accept", "application/json").asJson();

		JsonNode r = g.getBody();

		JSONObject ca = r.getObject();

		return new Product(ca.getString("name"), ca.getDouble("price"),
				ca.getString("category"),
				ca.getString("details"));
	}

	public void product_PUT(String id, Product product) {
		RequestBodyEntity p = Unirest.put(URLPC + "product/" + id).header("accept", "application/json")
				.body((Object) product);
	}

	public static void product_DELETE(String id) throws UnirestException {
		HttpResponse<String> d = Unirest.delete(URLPC + "product/" + id).header("accept", "application/json").asString();
	}

	public static void product_POST(Product p) throws UnirestException, JSONException {
		
		
		JSONObject jo = new JSONObject();
		
		jo.put("id", p.getId());
		jo.put("name", p.getName());
		jo.put("price", p.getPrice());
		jo.put("details", p.getDetails());
		jo.put("category", p.getCategory());
		
		JsonNode jno = new JsonNode(jo.toString());
		
		HttpResponse<JsonNode> po = Unirest.post(URLPC + "product/").header("content-type", "application/json").header("accept", "application/json")
				.body(jno).asJson();
	}

	public static List<Product> product_list_GET() throws UnirestException, JSONException {
		List<Product> lst = new ArrayList<Product>();

		HttpResponse<JsonNode> g = Unirest.get(URLPC + "product/").asJson();

		JsonNode r = g.getBody();

		JSONArray ca = r.getArray();

		for (int i = 0; i < ca.length(); i++) {
			JSONObject cactual = ca.getJSONObject(i);

			Product pTemp = new Product(cactual.getString("name"), cactual.getDouble("price"),
					cactual.getString("category"),
					"DUMMY" /* cactual.getString("details") */);

			lst.add(pTemp);
		}

		return lst;
	}

	/* T E S T I N G A N D D U M M Y */

	public static String dummy_doBasicTest() throws UnirestException {
		HttpResponse<JsonNode> jsonResponse = Unirest.post(URLAC + "post").header("accept", "application/json")
				.field("parameter", "value").field("foo", "bar").asJson();

		return jsonResponse.getStatusText() + " - " + jsonResponse.getRawBody();
	}

}