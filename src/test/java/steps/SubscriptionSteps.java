package steps;
import base.model.DataProvider;
import base.model.User;
import base.services.SubscriptionService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import java.util.List;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Subscription steps.
 */
public class SubscriptionSteps {

    /**
     * The Subscription service.
     */
    @Steps
    SubscriptionService subscriptionService;
    /**
     * The constant ENDPOINTS_JSON.
     */
    public static final String ENDPOINTS_JSON = "https://628e7107a339dfef87ae307a.mockapi.io/APIAutomation";
    /**
     * The Random __ users list.
     */
    DataProvider random__users_list;


    /**
     * Get the response from the endpoint.
     */
    @Given("I get the response from the endpoint")
    public void iGetTheResponseFromTheEndpoint() {
        subscriptionService.sendGetRequest("https://628e7107a339dfef87ae307a.mockapi.io/APIAutomation");
    }

    /**
     * Initialize the pojo with 10 random data.
     */
    @Given("I initialize the POJO with 10 random data verifying there are not emails repeated")
    public void IInitializeThePojoWith10RandomData() {
        random__users_list = new DataProvider(10);
        assertThat(random__users_list.checkIfAnEmailIsRepeated().equals("no hay emails duplicados"));
    }

    /**
     * Perform a post  request of the 10 random data.
     */
    @Then("I perform a POST request of the 10 random data")
    public void IPerformAPOSTARequestOfThe10RandomData() {
        for (User user : random__users_list.listOfUsers) {
            subscriptionService.sendPostQueryWithBody(user);
        }
    }

    /**
     * Verify there are not duplicate email accounts.
     */
    @Then("I verify there are not duplicate email accounts")
    public void IVerifyThereAreNotDuplicateEmailAccounts() {
        subscriptionService.sendGetRequest(ENDPOINTS_JSON);
        List<User> user_list = subscriptionService.getUserListFromService();
        String flag = "false";
        for (int i = 0; i < user_list.size(); i++) {
            String emailCheck = user_list.get(i).getEmail();
            for (int j = i + 1; j < user_list.size(); j++) {
                if (emailCheck.equals(user_list.get(j).getEmail())) {
                    flag = "true";
                }
            }
        }
        assertThat(flag.equals("false"));
    }

    /**
     * Update the last users account number.
     */
    @Then("I Update the last user's account number")
    public void IUpdateTheLastUsersAccountNumber() {
        subscriptionService.sendGetRequest(ENDPOINTS_JSON);
        List<User> user_list = subscriptionService.getUserListFromService();
        User userToUpdate = user_list.get(user_list.size()-1);
        userToUpdate.setAccountNumber(11234123);
        int id = userToUpdate.getId();
        assertThat(subscriptionService.updateUserById(userToUpdate,id).equals("200"));
    }


    /**
     * Get the response if any data is stored idelete it.
     */
    @When("I get the response, if we have any data I DELETE it")
    public void IGetTheResponseIfAnyDataIsStoredIDELETEIt() {
        subscriptionService.sendGetRequest(ENDPOINTS_JSON);
        List<User> user_list = subscriptionService.getUserListFromService();
        List<User> copy_user_list = user_list;
        for (User user : copy_user_list) {
            subscriptionService.sendDeleteQueryById(user.getId());
        }
    }


    /**
     * Get the response code equals to.
     *
     * @param responseCode the response code
     */
    @Then("I get the response code equals to {}")
    public void iGetTheResponseCodeEqualsTo(int responseCode) {
        restAssuredThat(response -> response.statusCode(responseCode));
    }




}
