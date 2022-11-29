package de.htwberlin.webtech.webtechnachbau.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Der Controller dient dazu, dem Client die angeforderte HTML-Seite zu übermitteln
 */
@Controller
public class HelloWorldController {

    /**
     * Methode verarbeitet GET-Request des Clients. Die angeforderte HTML-Seite wird zurückgegeben, wenn
     * im Browser "localhost:8080/" angegeben wird
     * @return angeforderte HTML-Seite "HelloWorld.html"
     */
    @GetMapping(path = "/")
    public ModelAndView showHelloWorldPage() {
        return new ModelAndView("HelloWorld");
    }
}
