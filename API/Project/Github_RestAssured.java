
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalTo;

public class Github_RestAssured {
    // Set base URL
    final static String ROOT_URI = "https://api.github.com/user/keys";
    final static String Base_URI = "https://api.github.com";
    String key="ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC65cKc+SrvvUu+vkjuD6/DkwERDVnGRsFgeecCn2DfqEJTqkv6F6+VCKcb26roDNNrYWq3VpPWRWN9Mr3ZjGZtxnG5L62bg1WrW169i1cOoqW4iFJhTAYNcmS/37zhdD3YC6c0zsWQq5cyLYc7L/b/RwC2EdPyAkJPvZFsybyibrv4Mdp09r1jZT6Oqc+vtLo120C+qYbRwyURhYbNXty0n8EmIZf1KCC0FK/Z6HXsIU57cQe4eyoQSBivJYjSfxNhf9UZv18Bw0WMM2CSWIkhk7fnd9lEwMgPPIzo7zcljfYy+BrUBixJSPcaVF+hgDH61yekRk1M2PWcXW6Vgb5f";
	String token="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";
	int keyID=0;
	// Declare request specification
	RequestSpecification requestSpec;
	 
	
	@BeforeClass
	public void setUp() {
	    // Create request specification
	    requestSpec = new RequestSpecBuilder()
	    	.setContentType(ContentType.JSON)
	    	.addHeader("Authorization", "Bearer "+token)
	        .setBaseUri(Base_URI)
	        .build();
	    
	   
	}
	@Test(priority=1)
    public void POST() {
    	
		String reqBody="{"+
		"\"title\":\"TestGit123333\","+
				"\"key\":\"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC65cKc+SrvvUu+vkjuD6/DkwERDVnGRsFgeecCn2DfqEJTqkv6F6+VCKcb26roDNNrYWq3VpPWRWN9Mr3ZjGZtxnG5L62bg1WrW169i1cOoqW4iFJhTAYNcmS/37zhdD3YC6c0zsWQq5cyLYc7L/b/RwC2EdPyAkJPvZFsybyibrv4Mdp09r1jZT6Oqc+vtLo120C+qYbRwyURhYbNXty0n8EmIZf1KCC0FK/Z6HXsIU57cQe4eyoQSBivJYjSfxNhf9UZv18Bw0WMM2CSWIkhk7fnd9lEwMgPPIzo7zcljfYy+BrUBixJSPcaVF+hgDH61yekRk1M2PWcXW6Vgb5f\"}";
		 
		 System.out.println(reqBody);
		        Response response = 
		            given().contentType(ContentType.JSON) // Set headers
		            .header("Authorization", "Bearer "+token)
		            .body(reqBody) // Add request body
		            .when().post(ROOT_URI);
		        System.out.println(response.asPrettyString());
		        keyID=response.jsonPath().getInt("id");
		        System.out.println(keyID);
        // Assertions
        response.then().statusCode(201);
       // 
    }

    @Test (priority=2)
    public void GET() {
     
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
           .header("Authorization", "Bearer "+token)
           .log().all()
            .when().get(ROOT_URI); // Run GET request
        String responseBody = response.getBody().asString();
       System.out.println("Response Body is =>  " + responseBody);
         // (responseBody);
        // Assertions
        response.then().statusCode(200);
       // response.then().body("[0].status", equalTo("sold"));
    }
    @Test(priority=3)
    public void Delete() throws IOException {
    	Response response = 
                given().contentType(ContentType.JSON) // Set headers
                .header("Authorization", "Bearer "+token)
                .log().all()
                .pathParam("keyID", keyID) // Add path parameter
                .when().delete(ROOT_URI + "/{keyID}"); // Send POST request
    	            // Assertion
         response.then().statusCode(204);
    }
}