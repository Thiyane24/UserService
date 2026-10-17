package controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/root")
    public String root() {
        return "UserService Healthy";
    }

    @GetMapping("/{id}")
    public Map<String, String> getUser(@PathVariable String id, @RequestHeader Map<String, String> headers) {
        System.out.println("Received Headers at Downstream Service:");
        headers.forEach((key, value) -> System.out.println(" - " + key + ": " + value));

        return Map.of(
                "id", id,
                "name", "Thiyane Xavier",
                "role", "Data Engineer",
                "status", "Active"
        );
    }

    @PostMapping
    public Map<String, String> createUser(@RequestBody Map<String, Object> payload) {
        return Map.of(
                "message", "User created successfully",
                "received_payload", payload.toString()
        );
    }
}