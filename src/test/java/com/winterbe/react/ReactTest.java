package com.winterbe.react;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class ReactTest {

    @Test
    public void testRenderCommentBox() throws Exception {
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment("Peter Parker", "This is a comment."));
        comments.add(new Comment("John Doe", "This is *another* comment."));

        React react = new React();
        String html = react.renderCommentBox(comments);

        assertThat(html, startsWith("<div"));

        Document doc = Jsoup.parse(html);
        assertThat(doc.select("div.comment").size(), is(2));
    }

}