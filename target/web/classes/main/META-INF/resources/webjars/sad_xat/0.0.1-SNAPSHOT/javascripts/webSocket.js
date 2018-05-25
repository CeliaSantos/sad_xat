/**
 * Docs: http://www.websocket.org/echo.html
 */

var websocket;

function initWebsocket(websocketPath)
{
    var websocketURL = "ws://" + window.location.host + websocketPath;
    websocket = new WebSocket(websocketURL);
    websocket.onopen = function(evt) { onOpen(evt) };
    websocket.onclose = function(evt) { onClose(evt) };
    websocket.onmessage = function(evt) { onMessage(evt) };
    websocket.onerror = function(evt) { onError(evt) };
}

function onOpen(evt)
{
    writeToScreen("CONNECTED");
    doSend("WebSocket Rocks");
}

function onClose(evt)
{
    writeToScreen("DISCONNECTED");
}

/**
 * This method handles the evt json objects depending on the type;
 * types -> #login, #logout, #message}
 */
function onMessage(evt)
{
    var json = jQuery.parseJSON(evt.data);
    var type = json.type;

    var html;
    switch (type){
        case "login" :
            html = "<div><b>" + json.user + " logged in"+ "</b></div>";
            break;
        case "logout" :
            html = "<div><b>" + json.user + " logged out" +"</b></div>";
            break;
        case "message":
            html = "<div><b>" + json.user+ " wrote:</b>  " + json.message + "</div>";
            break;
        default:
            html = "<div>" + "ERROR" + "</div>";
            break;
    }
    writeToScreen(html);
}

function onError(evt)
{
    writeToScreen("<div>" + "ERROR" + "</div>");
}

var escape = document.createElement('textarea');
function escapeHTML(html) {
    escape.textContent = html;
    return escape.innerHTML;
}

function doSend(message)
{
    var json = new Object();
    json.message = escapeHTML(message);
    websocket.send(JSON.stringify(json));
}

function performLogout() {
    websocket.close();
}

function writeToScreen(message)
{
    $('#output').append(message);
}