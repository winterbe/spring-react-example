Spring Boot React Example
============================

Example of the official [React.js Tutorial](http://facebook.github.io/react/docs/tutorial.html) using Spring Boot on the server-side.

The `CommentBox` main view is isomorphic: HTML is initially rendered on the server with Nashorn by utilizing `React.renderToString`. All interactive DOM manipulations are handled by React directly in the browser.

For further explanation read this [blog post](http://winterbe.com/posts/2015/02/16/isomorphic-react-webapps-on-the-jvm/).
