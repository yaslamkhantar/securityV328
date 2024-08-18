package elmoukhantar.yass.securitytraining328v.entities;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employe {

    @GetMapping("/voiture")
    public String testWeb(){
        return "voiture";
    }
}
