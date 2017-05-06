/**
 * Created by andy on 03.05.17.
 */

var counter = 1;
var limit = 3;
function addInput(divName) {
    alert('aloxa');
    if (counter == limit) {
        alert("You have reached the limit of adding " + counter + " inputs");
    }
    else {
        var newdiv = document.createElement('div');
        newdiv.innerHTML = "Entry " + (counter + 1) + " <br/><input type='text' name='myInputs[]'/>";
        // newdiv.innerHTML = " <br/><input type='text' name='myInputs[]'/>";
        document.getElementById(divName).appendChild(newdiv);
        counter++;
    }
}
