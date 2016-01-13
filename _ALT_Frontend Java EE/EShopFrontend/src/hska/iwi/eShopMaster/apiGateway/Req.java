package hska.iwi.eShopMaster.apiGateway;

public class Req {
	
	private Object content;
	private int code;

	public Req(int code, Object content)
	{
		this.code=code;
		this.content=content;
	}
	
	
	public Object getContent()
	{
		return this.content;
	}
	
	public int getCode()
	{
		return this.code;
	}
	
}
