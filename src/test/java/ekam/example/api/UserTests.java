package ekam.example.api;

import com.testvagrant.ekam.testBases.testng.APITest;

import static com.testvagrant.ekam.commons.LayoutInitiator.*;

import ekam.example.api.GetSingleUser.GetSingleUserResponse;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class UserTests extends APITest {

    @Test(groups = "api")
    public void shouldReturnSingleUser() {
        //Arrange
        int userId=2;
        //Act
        GetSingleUserResponse user = Client(UserClient.class).getSingleUser(userId);
        //Assert
        assertNotNull(user.getData().getEmail());

         assertEquals(user.getData().getEmail(),"janet.weaver@reqres.in");
        System.out.println(" Id  :"+ user.getData().getId());
        System.out.println(" First name  :"+ user.getData().getFirstName());
        System.out.println(" Last name :"+ user.getData().getLastName());
        System.out.println(" Mail address  :"+ user.getData().getEmail());
        System.out.println(" Avatar Link  :"+ user.getData().getAvatar());
        System.out.println(" Mail address  :"+ user.getSupport().getText());





    }
}