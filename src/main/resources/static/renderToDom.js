React.render(
    React.createElement(CommentBox, {url: "comments.json", pollInterval: 5000}),
    document.getElementById("content")
);