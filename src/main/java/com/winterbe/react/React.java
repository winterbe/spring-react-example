package com.winterbe.react;

import jdk.nashorn.api.scripting.NashornScriptEngine;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class React {

    private NashornScriptEngine nashorn;

    public React() {
        try {
            nashorn = (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");
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
            nashorn.eval(readFromClassPath("static/example.js"));
            nashorn.eval(readFromClassPath("static/renderToString.js"));
            String title = "Comments (rendered by server)";
            Object html = nashorn.invokeFunction("renderCommentBox", title);
            return String.valueOf(html);
        }
        catch (Exception e) {
            throw new IllegalStateException("failed to render react component", e);
        }
    }

    private Reader readFromClassPath(String path) {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        return new InputStreamReader(in);
    }
}
