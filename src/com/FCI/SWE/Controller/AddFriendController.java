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

public class AddFriendController {

	@GET
	@Path("/friend")
	public Response friend() {

		if (User.getCurrentActiveUser() == null) {
			return Response.serverError().build();
		}
		return Response.ok(new Viewable("/jsp/addFriendViews/addFriend")).build();
	}

	
	
	
	@POST
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@POST
	@Path("/add")
	public String add(@FormParam("id") long id)
			 {

		String serviceUrl = "http://localhost:8888/rest/addService";
		String urlParameters = "user_id=" + User.getCurrentActiveUser().getId();
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@POST
	@Path("/view")
	@Produces("text/html")
	public Response view(@FormParam("uname") String uname) {
		String urlParameters = "uname=" + uname ;

		String retJson = Connection.connect(
				"http://localhost:8888/rest/addFriendService", urlParameters,
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");

		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("Failed"))
				return null;
			//Map<String, ArrayList<UserEntity>> map = new HashMap<String, ArrayList<UserEntity>>();
			Map<String, String> map = new HashMap<String, String>();
			ArrayList<User> users = User.getUsers(object.toJSONString());
			for(int i=0;i<users.size();i++)
			{
				map.put("name"+i, users.get(i).getName());
			}
			
			//map.put("email", user.getEmail());
			return Response.ok(new Viewable("/jsp/addFriendViews/view", map)).build();
		//	for(int i=0; i<user)
			//map.put("name", user.getName());
		//	map.put("email", user.getEmail());
			//return Response.ok(new Viewable("/jsp/home", map)).build();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return null;

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

