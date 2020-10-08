
var modal = document.getElementsByClassName("myModal");
console.log(modal);

var btns = document.getElementsByClassName("myBtn");
console.log(btns);

var span = document.getElementsByClassName("close");

// When the user clicks the button, open the modal 

[...btns].forEach((item) =>
	item.addEventListener('click', function() {
		let index = [...btns].indexOf(item)
		modal[index].style.display = 'block'
	}))
// When the user clicks on <span> (x), close the modal
for (let item of span) {
	item.addEventListener('click', function() {
		let index = ([...span].indexOf(item))
		modal[index].style.display = 'none'
	})
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	for (let item of modal) {
		if (event.target == item) {
			item.style.display = "none";
		}
	}
}

