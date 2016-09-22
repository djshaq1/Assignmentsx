var token ="xoxp-63743851541-69484411831-82774001267-892268f86bf24ca4a8a57c29410015c5"
var msg = "shaq attack"
$(document).ready(function()
{    function postMessage(msg, channels) {
$.ajax("https://slack.com/api/chat.postMessage", {

data: {
  token: token,
channel: channels,
text: msg,
},
method: "POST"
})
};

$("#post").click(function() {
  var text = $("#desc").val();
  var channel = $('input[name="channels"]:checked').val();
  postMessage(text, channel);
   $("#desc").val('');
  })


  $('#desc').keypress(function (e)
   { var key = e.which; if(key == 13)
     // the enter key code
      {    $("#post").click();
       return false;
      }});









  });
