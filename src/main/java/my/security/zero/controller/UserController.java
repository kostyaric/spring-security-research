package my.security.zero.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping("/all")
    public String findCommonPage(Model model) {
        return "common/all"; /*need thymeleaf*/
    }

    @GetMapping("/admin")
    public String findAdminPage(Model model) {
        return "secure/admin"; /*need thymeleaf*/
    }

    @GetMapping("/doc")
    @ResponseBody
    public String fromSpringDoc() {
        return "<h1>Response body</h1>";
    }

    @GetMapping("/resp")
    public ResponseEntity<String> responseEntity() {
        return ResponseEntity.ok().eTag("ETAG").body("<h1>Response entity builder</h1>");
    }
}
