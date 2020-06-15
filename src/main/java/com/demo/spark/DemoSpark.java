/**
 * 
 */
package com.demo.spark;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import com.demo.spark.dto.StandardResponse;
import com.demo.spark.dto.User;
import com.demo.spark.enumeration.StatusResponse;
import com.demo.spark.service.IUserService;
import com.demo.spark.service.UserServiceMapImpl;
import com.google.gson.Gson;

/**
 * @author
 *
 */
public class DemoSpark {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final IUserService userService = new UserServiceMapImpl();

		port(8080);
		get("/hello", (req, res) -> "Hola Mundo. Demo Spark.");

        get("/hello/:name", (req,res)->{
            return "Hello, "+ req.params(":name");
        });
        
		//get("/helloworld", (req, res) -> "Hello " + req.queryParams("name"));
		
		get("/helloworld", (req, res) ->
		{		
			res.status(200);
			res.type("application/json");
			return "{message: 'Hello " + req.queryParams("name") + "'}";
		});
		
		post("/users", (request, response) -> {
		    response.type("application/json");
		    User user = new Gson().fromJson(request.body(), User.class);
		    userService.addUser(user);
		 
		    return new Gson()
		      .toJson(new StandardResponse(StatusResponse.SUCCESS));
		});
		
		get("/users", (request, response) -> {
		    response.type("application/json");
		    return new Gson().toJson(
		      new StandardResponse(StatusResponse.SUCCESS,new Gson()
		        .toJsonTree(userService.getUsers())));
		});
		
	}
	
}
