package com.produtos.apirest;

import com.produtos.apirest.services.PessoaService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UsuarioTests {

	@Test
	public void testDadoQueCrioUmUsuarioEntaoObtenhoStatusCode200(){
		String pessoa = given()
				.body("    {\n" +
						"        \"nome\": \"lontrinha\",\n" +
						"        \"cep\": 87200161\n" +
						"    }")
				.contentType(ContentType.JSON)
				.when()
				.post("http://localhost:8080/api/pessoa")
				.then()
				.statusCode(200)
				.extract()
				.path("nome");
		Assertions.assertEquals(pessoa, "lontrinha");
	}

	@Test
	public void testDadoQuePesquisoUmaPessoaEntaoObtenhoStatusCode200(){
		String pessoa = given()
				.contentType(ContentType.JSON)
				.when()
				.get("http://localhost:8080/api/pessoa/12")
				.then()
				.statusCode(200)
				.extract()
				.path("nome");
		Assertions.assertEquals(pessoa, "Henrique Rezende Bulla");

	}
}
