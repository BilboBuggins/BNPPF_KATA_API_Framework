package resources;

import body.PostMessage;

public class TestDataBuilder {
	
	public PostMessage postMessageload(String description, String email, String name, String phoneno, String subject) {
		PostMessage postmessage= new PostMessage();
		postmessage.setDescription(description);
		postmessage.setEmail(email);
		postmessage.setMessageid(null);
		postmessage.setName(name);
		postmessage.setPhone(phoneno);
		postmessage.setSubject(subject);
		return postmessage;
	}
	
	

}
