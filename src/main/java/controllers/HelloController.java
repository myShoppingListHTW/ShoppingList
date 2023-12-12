package controllers;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Berlin!";
    }
    @GetMapping("/pfad2")
    public String index2() {
        return "Greetings from Berlin!2";
    }
    @GetMapping("/user/{userid}/password/{password}")
    public String pfadParam(@PathVariable int userid, @PathVariable String password) {
        return "Greetings from Berlin!2, userid: " + userid + ", password: " + password;
    }

    @GetMapping("/user")
    public String queryParam(@RequestParam int userid, @RequestParam String password) { //http://localhost:8080/user?password=password&userid=50
        return "Greetings from Berlin!2, userid: " + userid + ", password: " + password;
    }
    @GetMapping("/useragent")
    public String headerParam(@RequestHeader(value = "useragent") String useragent) {
        return String.format("Greetings from Berlin!2, userid: ", useragent);
    }
}
