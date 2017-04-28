package club.psvm.smallshopsnetwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JAVA-P on 28.04.2017.
 */
 
 /* Создано в www.gateon.net
 * Все права на данный программный код принадлежат компании GateOn
 * Created by www.gateon.net
 * All rights to the software code are owned by GateOn
*/
@Controller
public class IndexController {

    @RequestMapping("/")
    String mainPage() {
        return "index";
    }
}
