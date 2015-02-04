package com.winterbe.react;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class React {

    private ScriptEngine nashorn;

    public React() {
        try {
            nashorn = new ScriptEngineManager().getEngineByName("nashorn");
            nashorn.eval("var window = this;");     // workaround for non-existing window
            nashorn.eval("load('https://cdnjs.cloudflare.com/ajax/libs/react/0.12.2/react.js')");
            nashorn.eval("load('http://cdnjs.cloudflare.com/ajax/libs/showdown/0.3.1/showdown.min.js')");
        }
        catch (ScriptException e) {
            throw new IllegalStateException("could not init nashorn", e);
        }
    }

    public String renderCommentBox() {
        try {
            InputStream in = getClass().getClassLoader().getResourceAsStream("static/build/example.js");
            Object html = nashorn.eval(new InputStreamReader(in));
            return String.valueOf(html);
        }
        catch (ScriptException e) {
            throw new IllegalStateException("failed to render react component", e);
        }
    }
}
