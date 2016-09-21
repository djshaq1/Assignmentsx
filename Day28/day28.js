// Numeric only control handler
$(document).ready(function() {

  var counter = 0;
  console.log("Gothere");

  // Display total
  $("#counter").val(counter);


  // When button is clicked
  $("#add").click(function(){
    //Add 1 to counter
    counter = counter + 1;
  	// Display total
    if (counter  > 8){
      $("#counter").addClass("redtext")
    }
  	$("#counter").val(counter);

  });


  //Subtract
  $("#subtract").click(function(){
    counter = counter - 1;
    if (counter  <= 8){
      $("#counter").removeClass("redtext")
    }
    $("#counter").val(counter);
  });


  // Reset
  $("#reset").click(function(){
    counter = 0;
    if (counter  < 8){
      $("#counter").removeClass("redtext")
    }
    $("#counter").val(counter);
  });

});
