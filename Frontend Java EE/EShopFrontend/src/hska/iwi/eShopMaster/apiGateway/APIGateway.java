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
	final static String URL_AC = "http://10.116.33.107";
	final static String PORT_AC = ":8080";
	final static String URLAC  = URL_AC + PORT_AC + "/";
	
	final static String URL_PC = "http://10.116.33.107";
	final static String PORT_PC = ":8080";
	final static String URLPC  = URL_PC + PORT_PC + "/";
	
	
	
	/*
	 * Rudimentary HTTP-Methods.
	 */
	
	/* U S E R  A C O U N T */
	
	public static boolean account_GET(String sUser) throws UnirestException
	{
		boolean uState = false;

		HttpResponse<String> g = Unirest.get(URLAC + "account/{user}")
			    .routeParam("user", sUser)
			    .asObject(String.class);
				
		uState = Boolean.valueOf(g.getBody());
		
		return uState;
	}
	
	public void account_PUT(String sUser)
	{
		HttpRequestWithBody p = Unirest.put(URLAC + "account/" + sUser)
				.header("accept", "application/json");
	}
	
	public void account_DELETE(String sUser, String sPass)
	{
		HttpRequestWithBody d = Unirest.delete(URLAC + "account/" + sUser)
				.header("accept", "application/json");
	}
	
	public void account_POST(String sUser, String sPass) throws UnirestException
	{
		HttpResponse<JsonNode> p = Unirest.post(URLAC + "account/")
				.header("accept", "application/json")
				.field("user", sUser)
				.field("pass", sPass)
				.asJson();		
	}
	
	
	
	
	/* C A T E G O R Y */
	
	public void category_POST(String id) throws UnirestException
	{
		HttpResponse<JsonNode> p = Unirest.post(URLPC + "category/")
				.header("accept", "application/json")
				.field("id", id)
				.asJson();	
	}
	
	public List<Category> category_GET()
	{
		List<Category> lst = new ArrayList<Category>();
		
		GetRequest g = Unirest.get(URLPC + "category/")
				.header("accept", "application/json");
		
		return lst;
	}
	
	public void category_DELETE(String id)
	{
		HttpRequestWithBody d = Unirest.delete(URLPC + "category/" + id)
				.header("accept", "application/json");		
	}
	
	
	
	/* P R O D U C T */
	
	public static Product product_GET(String id)
	{
		GetRequest g = Unirest.get(URLPC + "product/" + id)
				.header("accept", "application/json");
		
		return new Product("Testprodukt", 12.99, "Test", "Das sind Produktdetails, sehr geheime Angelenheit! Psssst...!");
	}
	
	public void product_PUT(String id, Product product)
	{
		RequestBodyEntity p = Unirest.put(URLPC + "product/" + id)
				.header("accept", "application/json")
				.body((Object)product);
	}
	
	public static void product_DELETE(String id)
	{
		HttpRequestWithBody d = Unirest.delete(URLPC + "product/" + id)
				.header("accept", "application/json");	
	}
	
	public void product_POST(Product product) throws UnirestException
	{
		HttpResponse<JsonNode> p = Unirest.post(URLPC + "product/")
				.header("accept", "application/json")
				.body((Object)product)
				.asJson();	
	}
	
	public static List<Product> product_list_GET() throws UnirestException, JSONException
	{
		List<Product> lst = new ArrayList<Product>();
		
		HttpResponse<JsonNode> g = Unirest.get(URLPC + "product/")
			    .asJson();
				
		JsonNode r = g.getBody();
		
		JSONArray ca= r.getArray();
		
		
		for(int i = 0; i < ca.length(); i++)
		{
			JSONObject cactual = ca.getJSONObject(i);
			
			Product pTemp = new Product(cactual.getString("name"),cactual.getDouble("price"),cactual.getString("category"), "DUMMY" /*cactual.getString("details")*/);
	
			lst.add(pTemp);
		}
		
		return lst;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/* T E S T I N G  A N D  D U M M Y */ 
	
	public static String dummy_doBasicTest() throws UnirestException
	{				
		HttpResponse<JsonNode> jsonResponse = Unirest.post(URLAC + "post")
				  .header("accept", "application/json")
				  .field("parameter", "value")
				  .field("foo", "bar")
				  .asJson();
		
		return jsonResponse.getStatusText()+ " - " + jsonResponse.getRawBody();
	}
	
	
	
}