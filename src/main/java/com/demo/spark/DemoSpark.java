/**
 * 
 */
package com.demo.spark;

import static spark.Spark.*;

/**
 * @author
 *
 */
public class DemoSpark {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
	}
	
}
