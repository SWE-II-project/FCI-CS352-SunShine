package com.FCI.SWE.ServicesModels;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

/**
 * <h1>User Entity class</h1>
 * <p>
 * This class will act as a model for user, it will holds user data
 * </p>
 *
 * @author Mohamed Samir
 * @version 1.0
 * @since 2014-02-12
 */
public class RequestEntity {
	private String sendName;
	private long sendID;
	private long recID;
	private String status;

//	private long sendId;

	/**
	 * Constructor accepts user data
	 * 
	 * @param sendName
	 *            user sendName
	 * @param email
	 *            user email
	 * @param password
	 *            user provided password
	 */
	public RequestEntity(String sendName, long sendID, long recID,String status) {
		this.sendName = sendName;
		this.sendID= sendID;
		this.recID = recID;
		this.status=status;
		
	}
	public RequestEntity(String string) {
	// TODO Auto-generated constructor stub
}
	public String getsendName()
	{
		return sendName;
	}
	public void setsendName(String sendName)
	{
		this.sendName=sendName;
	}
	
	private void setSendId(long sendID){
		this.sendID = sendID;
	}
	
	public long getsendID(){
		return sendID;
	}

	private void setrecId(long recID){
		this.recID = recID;
	}
	
	public long getRecID(){
		return recID;
	}
	public void setStatus(String Status){
	this.status=Status;
		
	}
	public String getStatus()
	{
		return status;
	}
	
	public Boolean saveRequest() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("Requests");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("Requests", list.size() + 1);

		employee.setProperty("sendName", this.sendName);
		employee.setProperty("sendID", this.sendID);
		employee.setProperty("recID", this.recID);
		employee.setProperty("status", this.status);
		datastore.put(employee);

		return true;

	}
	
	public static ArrayList<RequestEntity> getRequest(long id) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
        ArrayList<RequestEntity> matches=new ArrayList<RequestEntity>(); 
		Query gaeQuery = new Query("Requests");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			if (entity.getProperty("recID").toString().equals(id)) {
				RequestEntity returnedRequest = new RequestEntity(entity.getProperty(
						"sendName").toString());
			//	returnedRequest.setrecId(entity.getKey().getId());
			
				matches.add(returnedRequest);
			}
		}
		if(matches.size()>0)
              return matches;
		else
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}