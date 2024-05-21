package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.ResponseData;
import pojo.SearchCount;

public class SearchApiSteps {
    private static final Logger logger = LoggerFactory.getLogger(SearchApiSteps.class);
    private Response response;
    private RequestSpecification requestSpec;

    public SearchApiSteps() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://www.woolworths.com.au");
        builder.setBasePath("/apis/ui/v2/Search/count");
        requestSpec = builder.build();
    }

    @Given("I perform a GET request to the search endpoint with searchTerm {string}")
    public void iPerformAGETRequestToTheSearchEndpointWithSearchTerm(String searchTerm) {
        response = RestAssured
                .given()
                .spec(requestSpec)
                .queryParam("searchTerm", searchTerm)
                .when()
                .get();
        logger.info("GET Request performed to /Search/count with searchTerm: {}", searchTerm);
        logger.info("Response Body: {}", response.getBody().asString());
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals("Status code is not as expected", statusCode, response.getStatusCode());
        logger.info("Status code is as expected: {}", statusCode);
    }

    @Then("the response should have ArticleCount and Total greater than 0")
    public void theResponseShouldHaveArticleCountAndTotalGreaterThanZero() throws Exception {
    	ResponseData responseData = response.getBody().as(ResponseData.class);
        SearchCount searchCount = responseData.getSearchCount();
        Assert.assertNotNull("ResponseData or SearchCount is null", searchCount);
        Assert.assertTrue("ArticleCount should be greater than 0", searchCount.getArticleCount() > 0);
        Assert.assertTrue("Total should be greater than 0", searchCount.getTotal() > 0);
        logger.info("ArticleCount: {}", searchCount.getArticleCount());
        logger.info("Total: {}", searchCount.getTotal());
    }

    @Then("the response should have ArticleCount and Total")
    public void theResponseShouldHaveArticleCountAndTotal() throws Exception {
    	ResponseData responseData = response.getBody().as(ResponseData.class);
        SearchCount searchCount = responseData.getSearchCount();
        Assert.assertNotNull("ResponseData or SearchCount is null", searchCount);
        Assert.assertTrue("ArticleCount should be greater than or equal to 0", searchCount.getArticleCount() >= 0);
        Assert.assertTrue("Total should be greater than or equal to 0", searchCount.getTotal() >= 0);
        logger.info("ArticleCount: {}", searchCount.getArticleCount());
        logger.info("Total: {}", searchCount.getTotal());
    }
}