var url = "http://localhost:777";

var pages = [
  'home', 'rooms', 'bookings', 'room', 'booking', 'new_room', 'new_booking'
];

function showPage(currentPage) {
  var found = false;

  for (let i = 0; i < pages.length; i++) {
    if (pages[i] == currentPage) {
      document.getElementById(pages[i]).style.display = 'block';
      found = true;
    } else {
      document.getElementById(pages[i]).style.display = 'none';
    }
  }

  if (!found) {
    document.getElementById('home').style.display = 'block';
  }
}

function findRooms() {
  var xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      var resp = JSON.parse(this.responseText);

      if (resp.status != 'OK') {
        console.log()

        return;
      }
    }
  }
}
