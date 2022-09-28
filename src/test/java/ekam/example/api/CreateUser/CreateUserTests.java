package ekam.example.api.CreateUser;

import com.testvagrant.ekam.testBases.testng.APITest;

import static com.testvagrant.ekam.commons.LayoutInitiator.*;

import ekam.example.api.Login.LoginClient;
import ekam.example.api.Login.LoginRequest;
import ekam.example.api.UserClient;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateUserTests extends APITest {

    @Test(groups = "api")
    public void shouldCreateUser() {
        //Arrange
        String name="Bob";
        String job= "Builder";
        String email = "eve.holt@reqres.in";
        String password= "cityslicka";
        LoginRequest loginRequest =  LoginRequest.builder()
                .email(email)
                .password(password)
                .build();

        String token = Client(LoginClient.class)
                .login(loginRequest)
                .getToken();
        //Act
            CreateUserRequest request = CreateUserRequest.builder().name(name).job(job).build();

            CreateUserResponse response = Client(CreateUserRequestClient.class)
                    .createUser(request,token);
        //Assert
     //   assertNotNull(response.getName());
            assertEquals(response.getName(), "Bob");
            assertEquals(response.getJob(),"Builder");
    }


    }
