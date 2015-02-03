package com.winterbe.react;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @author Benjamin Winterberg
 */
@Controller
public class MainController {

    private ScriptEngine nashorn;

    public MainController() {
        try {
            nashorn = new ScriptEngineManager().getEngineByName("nashorn");
            nashorn.eval("var window = this;");
            nashorn.eval("load('https://cdnjs.cloudflare.com/ajax/libs/react/0.12.2/react.js')");
            nashorn.eval("load('http://cdnjs.cloudflare.com/ajax/libs/showdown/0.3.1/showdown.min.js')");
        }
        catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/")
    public String index(Map<String, Object> model) throws ScriptException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("static/build/example.js");
        Object html = nashorn.eval(new InputStreamReader(in));
        model.putIfAbsent("content", html);
        return "index";
    }

}
