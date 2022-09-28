package ekam.example.api.CreateUser;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class CreateUserRequest{
	private String name;
	private String job;
}