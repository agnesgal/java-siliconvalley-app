var modal = document.getElementById('cartModal');
var youWord = document.getElementById("youWord");
var span = document.getElementsByClassName("close")[0];

youWord.onclick = function() {
    modal.style.display = "block";
}

span.onclick = function() {
    modal.style.display = "none";
}

window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}