package hska.iwi.eShopMaster.apiGateway;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.HttpGet;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.*;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.mashape.unirest.request.body.Body;
import com.mashape.unirest.request.body.RequestBodyEntity;

import hska.iwi.eShopMaster.model.database.dataobjects.*;


public class APIGateway {
	
	final static String URL_ = "http://10.0.2.15";
	
	final static String PORT = ":8080";
	
	final static String URL = URL_ + PORT + "/";
	
	
	public String dummy_doBasicTest() throws UnirestException
	{				
		HttpResponse<JsonNode> jsonResponse = Unirest.post(URL + "post")
				  .header("accept", "application/json")
				  .queryString("apiKey", "123")
				  .field("parameter", "value")
				  .field("foo", "bar")
				  .asJson();
		
		return jsonResponse.getStatusText()+ " - " + jsonResponse.getRawBody();
	}
	
	
	/*
	 * Rudimentary HTTP-Methods.
	 */
	
	public void account_GET(String sUser)
	{
		GetRequest g = Unirest.get(URL + "account/" + sUser)
				.header("accept", "application/json");
	}
	
	public void account_PUT(String sUser)
	{
		HttpRequestWithBody p = Unirest.put(URL + "account/" + sUser)
				.header("accept", "application/json");
	}
	
	public void account_DELETE(String sUser, String sPass)
	{
		HttpRequestWithBody d = Unirest.delete(URL + "account/" + sUser)
				.header("accept", "application/json");
	}
	
	public void account_POST(String sUser, String sPass) throws UnirestException
	{
		HttpResponse<JsonNode> p = Unirest.post(URL + "account/")
				.header("accept", "application/json")
				.field("user", sUser)
				.field("pass", sPass)
				.asJson();		
	}
	
	
	
	
	public void category_POST(String id) throws UnirestException
	{
		HttpResponse<JsonNode> p = Unirest.post(URL + "category/")
				.header("accept", "application/json")
				.field("id", id)
				.asJson();	
	}
	
	public List<Category> category_GET()
	{
		List<Category> lst = new ArrayList<Category>();
		
		GetRequest g = Unirest.get(URL + "category/")
				.header("accept", "application/json");
		
		return lst;
	}
	
	public void category_DELETE(String id)
	{
		HttpRequestWithBody d = Unirest.delete(URL + "category/" + id)
				.header("accept", "application/json");		
	}
	
	
	
	
	public static Product product_GET(String id)
	{
		GetRequest g = Unirest.get(URL + "product/" + id)
				.header("accept", "application/json");
		
		return new Product("Testprodukt", 12.99, "Test", "Das sind Produktdetails, sehr geheime Angelenheit! Psssst...!");
	}
	
	public void product_PUT(String id, Product product)
	{
		RequestBodyEntity p = Unirest.put(URL + "product/" + id)
				.header("accept", "application/json")
				.body((Object)product);
	}
	
	public static void product_DELETE(String id)
	{
		HttpRequestWithBody d = Unirest.delete(URL + "product/" + id)
				.header("accept", "application/json");	
	}
	
	public void product_POST(Product product) throws UnirestException
	{
		HttpResponse<JsonNode> p = Unirest.post(URL + "product/")
				.header("accept", "application/json")
				.body((Object)product)
				.asJson();	
	}
	
	public static List<Product> product_list_GET()
	{
		List<Product> lst = new ArrayList<Product>();
		
		GetRequest g = Unirest.get(URL + "product/")
				.header("accept", "application/json");
		
		
		/*
		 * TESTING
		 */
		lst.add(new Product("Testprodukt", 12.99, "Test"));
		// -------
		
		return lst;
	}
	
	
	
	
	
}