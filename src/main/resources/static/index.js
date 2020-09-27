var url = "http://localhost:777";

var pages = ['home', 'rooms', 'bookings', 'room', 'booking', 'new_room', 'new_booking'];

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

    console.log(`Page not found: ${currentPage}`);
  }
}

function showRooms(rooms) {
  var table = 
    '<table class="table">' +
    '<thead>' +
      '<tr>' +
        '<th scope="col">Number</th>' +
        '<th scope="col">Floor</th>' +
        '<th scope="col">Type</th>' +
        '<th scope="col">Capacity</th>' +
        '<th scope="col">Is Locked</th>' +
      '</tr>' +
    '</thead>' +
    '<tbody>';

  for (let i = 0; i < rooms.length; i++) {
    var room = rooms[i];
    
    var row =
      '<tr>' +
        `<th scope="row">${room.number}</th>` +
        `<td>${room.floor}</td>` +
        `<td>${room.type}</td>` +
        `<td>${room.capacity}</td>` +
        `<td><a href="javascript:void(0)" onclick="toggleLock(${room.number})">${room.isLocked}</a></td>` +
      '</tr>';

    table += row;
  }

  table += 
    '</tbody>' +
    '</table>';

  document.getElementById("content").innerHTML = table;
}

function findRooms() {
  var xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      var resp = JSON.parse(this.responseText);

      if (resp.status != 'OK') {
        console.log(resp.errorMessage);
        return;
      }

      showRooms(resp.object);
    }
  };

  xhttp.open("GET", `${url}/room`, true);
  xhttp.send();
}

function toggleLock(number) {
  var xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = function() {
    if(xhttp.readyState == 4 && xhttp.status == 200) {
      showPage('rooms');
      findRooms();
    }
  };

  xhttp.open("PUT", `${url}/room/toggleLock/${number}`, true);
  xhttp.send();
}
