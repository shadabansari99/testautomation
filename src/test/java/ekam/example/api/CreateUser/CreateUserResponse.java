package ekam.example.api.CreateUser;

import lombok.Data;
import lombok.Getter;

@Getter
public class CreateUserResponse{
	private String createdAt;
	private String name;
	private String id;
	private String job;
}