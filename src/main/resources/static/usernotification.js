const unReadMessages = document.querySelectorAll('.unread') ;
const unReadMessagesCount=document.getElementById('num-of-notif');
const markAll=document.getElementById('mark-as-read');

unReadMessagesCount.innerText=unReadMessages.length;

unReadMessages.forEach((message) =>
{
    message.addEventListener('click',()=>
    {
      message.classList.remove('unread');
      const newUnreadMessages = document.querySelectorAll('.unread');
      unReadMessagesCount.innerText = newUnreadMessages.length;
    });
});


// Mark as All read 
markAll.addEventListener('click',()=>
{
    unReadMessages.forEach((message)=>
    {
        message.classList.remove('unread');
    });
    const newUnreadMessages = document.querySelectorAll('unread');
    unReadMessagesCount.innerHTML = newUnreadMessages.length;
});





// Color change of unread message after reading 

function changeColor(event) {
  var targetElement = event.target;
  if (!targetElement.classList.contains('fa-circle-check') && !targetElement.classList.contains('fa-circle-xmark')) {
      var notificationDiv = event.currentTarget;
      notificationDiv.classList.remove('checked');
  }
}

function toggleChecked(event) {
  var notificationDiv = event.currentTarget.closest('.notificationcard');
  if (notificationDiv) {
      notificationDiv.classList.toggle('checked');
  }
}


// function changeColor(element) {
//   var notificationDiv = element.closest('.notificationcard');
//   if (notificationDiv) {
//       notificationDiv.classList.toggle('checked');
//   }
// }

//         function changeColor(clickedBox)
//          {
//             let myColor = "#ececec";
//             clickedBox.style.backgroundColor = myColor;
//           }

function toggleRandomAcceptance(notificationId) {
  const notificationElement = document.getElementById(notificationId);
  const descriptionElement = notificationElement.querySelector('.description p');

  // Generate a random number between 0 and 1
  const randomNumber = Math.random();

  if (randomNumber < 0.5) {
      // If the random number is less than 0.5, show acceptance message
      descriptionElement.textContent = 'NGO has accepted your request.';
  } else {
      // If the random number is greater than or equal to 0.5, show rejection message
      descriptionElement.textContent = 'NGO has rejected your request.';
  }
}
// remove unwanted notification 

function hideNotification(notificationId) {
  var notificationDiv = document.getElementById(notificationId);
  if (notificationDiv) {
      notificationDiv.style.display = "none";
  }
}

function fetchNotifications() 
{
    fetch('/api/notifications') // Assuming this endpoint returns notifications
        .then(response => response.json())
        .then(data => {
            // Process the notifications data and update the UI
            console.log(data);
        })
        .catch(error => console.error('Error fetching notifications:', error));
}


