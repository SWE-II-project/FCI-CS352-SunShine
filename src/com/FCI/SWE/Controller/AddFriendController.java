package com.FCI.SWE.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.FCI.SWE.Models.User;
import com.FCI.SWE.Services.AddServices;
import com.FCI.SWE.ServicesModels.UserEntity;
@Path("/")
@Produces("text/html")
public class AddFriendController {

	@GET
	@Path("/viewf")
	public Response friend() {


		return Response.ok(new Viewable("/jsp/addFriendViews/addFriend")).build();
	}
	
	
	
	
	/*@POST
	@Path("/addFriend")
	public String addFriend(@FormParam("name") String name)
			 {

		String serviceUrl = "http://localhost:8888/rest/addFriendService";
		String urlParameters = "user_id=" + User.getCurrentActiveUser().getId()
				+ "&name=" + name ;
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			/*if (object.get("Status").equals("OK"))
				return "Group created Successfully";
*/
		/*} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}*/

	
	@POST
	@Path("/view")
	//@Produces("text/html")
	public String view(@FormParam("uname") String uname,@FormParam("uname2") String uname2) {
		String urlParameters = "uname=" + uname +"&uname2="+uname2;
		String serviceUrl = "http://localhost:8888/rest/addFriendService";
		String retJson = Connection.connect(
				"http://localhost:8888/rest/addFriendService", urlParameters,
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");

		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("OK"))
				return "Request sent Successfully";

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Failed";
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

