document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8088/login/Users')
        .then(response => response.json())
        .then(users => displayUsers(users))
        .catch(error => console.error('Error fetching users:', error));

    function displayUsers(users) {
		console.log(users);
        const userListDiv = document.getElementById('userList');
        let rowDiv; // Variable to track the current row

        users.forEach((user, index) => {
            // Create a new row div for every 4th card
            if (index % 4 === 0) {
                rowDiv = document.createElement('div');
                rowDiv.classList.add('row');
                userListDiv.appendChild(rowDiv);
            }

            const userCard = document.createElement('div');
            userCard.classList.add('col-md-3', 'py-5', 'user-card'); // Adjust col-md-3 based on your layout
            userCard.innerHTML = `
                <!-- Your card content here -->
           <div class = "col-12 col-md-6 col-lg-3" style="width: 89%";>
           <div class ="card">          
          <div class="col-md-6 py-5">
            <div id="demo" class="carousel slide" data-bs-ride="carousel">
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <img src="images/8cf0e78c-144a-4486-9823-d6125a09e56d.png"  alt="wastagestats" class="d-block" style="width: 100%">
                </div>
                <div class="carousel-item">
                  <img src="image/aalodum.jpg" alt="savingstats" class="d-block" style="width:100%">
                </div>
                <div class="carousel-item">
                  <img src="image/jeerarice.jpg" alt="stats" class="d-block" style="width:100%">
                </div>
                <div class="carousel-item">
                  <img src="images/Kadai-Paneer.webp" alt="stats" class="d-block" style="width:100%">
                </div>
              </div>
              <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
                <span class="carousel-control-prev-icon"></span>
              </button>
              <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
                <span class="carousel-control-next-icon"></span>
              </button>
            </div>
          </div>
          <img src="images/${user.image}" alt="wastagestats" class="d-block" style="width: 100%">
          <div class="card-body">
            <h4 class="card-title"> Info..</h4>
            <h5>Event: ${user.event}</h5>
            <h6>Name.</h6>
            <p>${user.fname}</p>
            <h6>Mobile no.</h6>
            <p>${user.phoneNo}</p>
            <h6>Email.</h6>
            <p>${user.email}</p>
            <h6>Available Food</h6>
            <p> ${user.description}</p>
            <h6>Best before (in days)</h6>
            <p>${user.bestbefore} </p>
           <!--<button class="left-button" type="submit">Accept</button>
            <button class="right-button" type="submit">Reject</button>
            
             --> 
          </div>
          </div>
          </div>
            `;

            // Append the card to the current row
            rowDiv.appendChild(userCard);
        });
    }
});
// Function to display the popup in ngo home  page
function showPopup(message) {
  document.getElementById("welcomeMessage").textContent = message;
  document.getElementById("popup").style.display = "block";
  setTimeout(function() {
      document.getElementById("popup").style.display = "none";
  }, 2000); // Hide the popup after 1 second (1000 milliseconds)
}

function hidePopup() {
  document.getElementById("popup").style.display = "none";
}
showPopup('Welcome, NGO!');
            
            
            
       
