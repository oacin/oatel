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
        `<th scope="row"><a href="javascript:void(0)" onclick="showPage('room');findRoom(${room.number});">${room.number}</a></th>` +
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

  document.getElementById("rooms_content").innerHTML = table;
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

function showRoom(room) {
  var card =
    '<div class="card text-center mt-3">' +
      '<div class="card-header">' +
        `Room ${room.number}` +
      '</div>' +
      '<div class="card-body">' +
        `<p class="card-text">Floor: ${room.floor}</p>` +
        `<p class="card-text">Type: ${room.type}</p>` +
        `<p class="card-text">Capacity: ${room.capacity}</p>` +
        `<p class="card-text">Is Locked: ${room.isLocked}</p>` +
        '<a href="javascript:void(0)" class="btn btn-warning m-3">Edit</a>' +
        '<a href="javascript:void(0)" class="btn btn-danger m-3">🗑</a>' +
      '</div>' +
    '</div>';

    document.getElementById("room_content").innerHTML = card;
}

function findRoom(number) {
  var xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      var resp = JSON.parse(this.responseText);

      if (resp.status != 'OK') {
        console.log(resp.errorMessage);
        return;
      }

      showRoom(resp.object);
    }
  };

  xhttp.open("GET", `${url}/room/${number}`, true);
  xhttp.send();
}

function editRoom(number) {

}

function showBookings(bookings) {
  var table = 
    '<table class="table">' +
    '<thead>' +
      '<tr>' +
        '<th scope="col">Id</th>' +
        '<th scope="col">Room</th>' +
        '<th scope="col">Start Date</th>' +
        '<th scope="col">End Date</th>' +
        '<th scope="col">Price</th>' +
        '<th scope="col">Guest</th>' +
      '</tr>' +
    '</thead>' +
    '<tbody>';

  for (let i = 0; i < bookings.length; i++) {
    var booking = bookings[i];
    
    var row =
      '<tr>' +
        `<th scope="row">${booking.id}</th>` +
        `<td>${booking.room}</td>` +
        `<td>${booking.startDate}</td>` +
        `<td>${booking.endDate}</td>` +
        `<td>${booking.price}</td>` +
        `<td>${booking.guest}</td>` +
      '</tr>';

    table += row;
  }

  table += 
    '</tbody>' +
    '</table>';

  document.getElementById("bookings_content").innerHTML = table;
}

function findBookings() {
  var xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = function() {
    if(xhttp.readyState == 4 && xhttp.status == 200) {
      var resp = JSON.parse(this.responseText);

      if(resp.status != 'OK') {
        console.log(resp.errorMessage);
        return;
      }

      showBookings(resp.object);
    }
  };

  xhttp.open("GET", `${url}/booking`, true);
  xhttp.send();
}

function destroyBooking(id) {

}
