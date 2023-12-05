package co.com.jp.HolaSpringApache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ControllerStart {
    
    @GetMapping("/")
    public String start() {
        log.info("ejecutando el controlador");
        log.debug("mas detalles del controlador");
        return "Hola mundo con spring 2";
    }
}
