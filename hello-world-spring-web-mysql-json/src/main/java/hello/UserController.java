package hello;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Optional<User> getUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			System.out.println("User found");
		} else {
			System.out.println("no user for id" + id);
		}
		
		return userRepository.findById(id);
	}
	
//	@GetMapping("/add")
//	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
//		User u = new User();
//		u.setName(name);
//		u.setEmail(email);
//		userRepository.save(u);
//		return "User saved.";
//		
//	}
	
	@PostMapping("/")
	public @ResponseBody String addUser(@RequestBody User user) {
		userRepository.save(user);
		return "User saved.";
		
	}
	
	@DeleteMapping("/")
	public @ResponseBody String deleteUser(@RequestBody User user) {
		userRepository.delete(user);
		return "User deleted" ;
	}
	
	@PutMapping("/")
	public @ResponseBody String updateUser(@RequestBody User user) {
		userRepository.save(user);
		return "User updated" ;
	}
	
}
