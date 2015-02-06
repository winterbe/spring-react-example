package com.winterbe.react;

import jdk.nashorn.api.scripting.NashornScriptEngine;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class React {

    private NashornScriptEngine nashorn;

    public React() {
        try {
            nashorn = (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");
            nashorn.eval(readFromClassPath("server/nashorn-polyfill.js"));
            nashorn.eval(readFromClassPath("static/vendor/react.js"));
            nashorn.eval(readFromClassPath("static/vendor/showdown.min.js"));
        }
        catch (ScriptException e) {
            throw new IllegalStateException("could not init nashorn", e);
        }
    }

    public String renderCommentBox(List<Comment> comments) {
        try {
            nashorn.eval(readFromClassPath("static/example.js"));
            nashorn.eval(readFromClassPath("static/renderToString.js"));
            Object html = nashorn.invokeFunction("renderCommentBox", comments);
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
