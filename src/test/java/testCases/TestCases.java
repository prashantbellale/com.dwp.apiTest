package testCases;

import com.dwp.api.testbase.UsersTestBase;
import com.dwp.api.utils.CalculateDistance;
import com.dwp.api.utils.DataWriter;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestCases {

    // 1.Write a Test for API that returns the number of users
    @Test(priority = 1)
    public void getNumberOfUsers() {

        Response data = UsersTestBase.getAllUsers();
        int allUserCount = data.jsonPath().getList("id").size();
        System.out.println("Total number of users:" + allUserCount);
    }

    // 2.Write a Test for API that returns the number of users who live in London
    @Test(priority = 2)
    public void getLondonUserCount() {

        Response data = UsersTestBase.getLondonUsers("London");
        int londonUsersCount = data.jsonPath().getList("id").size();
        System.out.println("Total number of London users:" + londonUsersCount);

    }

    // 3.Write a Test that looks for users within 50 miles radius of London and output the result to console/text file.
    @Test(priority = 3)
    public void getUsersIn50Miles() throws IOException {

        Response data = UsersTestBase.getAllUsers();
        JSONArray userData = new JSONArray((data.asString()));

        for (int i = 0; i < userData.length(); i++) {

            JSONObject allUser = userData.getJSONObject(i);
            double inMiles = CalculateDistance.getDistance(allUser);

            if (inMiles <= 50) {
                List<JSONObject> finalUsers = new ArrayList<>();
                finalUsers.add(allUser);
                System.out.println(allUser); // Write output to Console
                DataWriter.writeOutput(allUser); // Write output to text file.

            }
        }
    }


}
