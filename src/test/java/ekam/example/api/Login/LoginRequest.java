package ekam.example.api.Login;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest{
	private String password;
	private String email;
}