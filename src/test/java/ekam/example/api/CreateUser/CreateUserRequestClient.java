package ekam.example.api.CreateUser;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.api.retrofit.RetrofitBaseClient;
import retrofit2.Call;
import retrofit2.http.*;
import com.testvagrant.ekam.reports.annotations.APIStep;

public class CreateUserRequestClient extends RetrofitBaseClient {

    private interface CreateUserRequestService {
                @Headers({"Content-Type: application/json"})
                @POST("/api/users")
                 Call<CreateUserResponse> createUser(@Body CreateUserRequest request,@Header("authorization") String token);
    }

    private final CreateUserRequestService service;

    @Inject
    public CreateUserRequestClient(@Named("baseUrl") String baseUrl) {
        super(baseUrl);
        service = httpClient.getService(CreateUserRequestService.class);
    }

    @APIStep(keyword = "When", description = "I invoke CreateUserRequest API")
    public CreateUserResponse createUser(CreateUserRequest request,String token) {
        Call<CreateUserResponse> call = service.createUser(request,token);
        return httpClient.execute(call);
    }

}