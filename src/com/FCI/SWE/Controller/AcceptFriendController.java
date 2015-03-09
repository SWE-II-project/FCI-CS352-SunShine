package com.FCI.SWE.Controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.FCI.SWE.Models.User;
@Path("/")
public class AcceptFriendController {

	@GET
	@Path("/friend")
	public Response friend() {

		if (User.getCurrentActiveUser() == null) {
			return Response.serverError().build();
		}
		return Response.ok(new Viewable("/jsp/acceptFriendViews/acceptFriend")).build();
	}

	
	
	
	@POST
	@Path("/acceptFriend")
	public String acceptFriend(@FormParam("uname") String uname,@FormParam("uname2") String uname2)
			 {
		String urlParameters = "uname=" + uname +"&uname2="+uname2;
		String serviceUrl = "http://localhost:8888/rest/acceptFriendService";
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("OK"))
				return "you now friend :D ";

		} catch (ParseException e) {
	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

		
}

