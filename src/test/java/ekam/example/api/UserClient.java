package ekam.example.api;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.api.retrofit.RetrofitBaseClient;
import ekam.example.api.CreateUser.CreateUserRequest;
import ekam.example.api.CreateUser.CreateUserResponse;
import ekam.example.api.GetSingleUser.GetSingleUserResponse;
import retrofit2.Call;
import retrofit2.http.*;
import com.testvagrant.ekam.reports.annotations.APIStep;

public class UserClient extends RetrofitBaseClient {

    private interface UserService {
        @GET("/api/users/{userID}")
        Call<GetSingleUserResponse> getSingleUser(
                @Path("userID") int id
              //  @Header("accept: application/json") String accept
        );
    }

    private final UserService service;

    @Inject
    public UserClient(@Named("baseUrl") String baseUrl) {
        super(baseUrl);
        service = httpClient.getService(UserService.class);
    }

    @APIStep(keyword = "When", description = "I invoke getSingleUser API")
    public GetSingleUserResponse getSingleUser(int id) {
        Call<GetSingleUserResponse> call = service.getSingleUser(id);
        return httpClient.execute(call);
    }
}