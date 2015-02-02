var converter = new Showdown.converter();

var CommentForm = React.createClass({
    render: function () {
        return (
            <div className="commentForm">
                Hello World! I'm a comment form.
            </div>
        );
    }
});

var Comment = React.createClass({
    render: function () {
        var rawMarkup = converter.makeHtml(this.props.children.toString());
        return (
            <div className="comment">
                <h2>{this.props.author}</h2>
                <span dangerouslySetInnerHTML={{__html: rawMarkup}} />
            </div>
        );
    }
});

var CommentList = React.createClass({
    render: function () {
        return (
            <div className="commentList">
                <Comment author="Peter Parker">This is a **comment**.</Comment>
                <Comment author="John Doe">This is *another* comment.</Comment>
            </div>
        );
    }
});

var CommentBox = React.createClass({
    render: function () {
        return (
            <div className="commentBox">
                <h1>Comments</h1>
                <CommentList />
                <CommentForm />
            </div>
        );
    }
});

React.render(
    <CommentBox />,
    document.getElementById("content")
);