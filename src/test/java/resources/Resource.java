package resources;

public enum Resource {
	
	
	
	getMessageApi("/message"),
	getMessageApiWithId("/message/1"),
	getMessageApiwithCount("/message/count"),
	postMessageApi("/message/"),
	putMessageApi("/message/1/read"),
	deleteMessageApi("/message/1");

	private String resource;
	
	Resource(String resource) {
		this.resource=resource;
	}
	public String getResource() {
		return resource;
	}
	
	
	

}
