package org.sevenzero.jwtdemo;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

/**
 * Hello world!
 *
 */
public class App {

	static final Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {
		System.out.println("Hello World!");

		try {
			Algorithm algorithm = Algorithm.HMAC256("secret");
			String token = JWT.create().withIssuer("auth0").sign(algorithm);
			log.info(token);
		} 
		catch (UnsupportedEncodingException exception) {
			// UTF-8 encoding not supported
		} 
		catch (JWTCreationException exception) {
			// Invalid Signing configuration / Couldn't convert Claims.
		}

	}

}
