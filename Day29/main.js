//var slackToken = GetSlackToken;
var channelsList = [];

function listChannels() {
  var GetSlackToken = getSlackToken();
  $.ajax("https://slack.com/api/channels.list", {
    method: "POST",
    data: {
      token: GetSlackToken
    }
  }).then(function(channelsList) {
    console.log(channelsList);
    for(var count = 0; count < channelsList.channels.length; count++) {
      //radioId++;
      var newChannelBtn = $("<div2><input type='radio' name='channels' value="+channelsList.channels[count].name+"> " + "<label>"+channelsList.channels[count].name+"</label>" + "</input></div2>");

      $("#channels").append(newChannelBtn);
    }
  });
}


$(document).ready(function() {
  listChannels();


  $("#post").click(function() {

    var msg = $("#desc").val();
    var channels = $('input[name="channels"]:checked').val();
    var GetSlackToken = getSlackToken();

    $.ajax("https://slack.com/api/chat.postMessage", {
      method: "POST",
      data: {
        token: GetSlackToken,
        channel: channels,
        text: msg
      }
    }).then(function(result) {
        $("#desc").val('');
    })
  });

  $('#desc').keypress(function (e) {
    var key = e.which;
    if(key == 13) {
      $("#post").click();
       return false;
    }
  });

});
