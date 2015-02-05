React.render(
    React.createElement(CommentBox, {title: "Comments (rendered by client)", url: "comments.json", pollInterval: 5000}),
    document.getElementById("content")
);