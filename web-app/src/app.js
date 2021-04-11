// window.onload = function () {
//     // Set the date we're counting down to
//     function countdownTimeStart() {
//         var countDownDate = new Date("Sep 25, 2025 15:00:00").getTime();

//         // Update the count down every 1 second
//         var x = setInterval(function () {
//             // Get todays date and time
//             var now = new Date().getTime();

//             // Find the distance between now an the count down date
//             var distance = countDownDate - now;

//             // Time calculations for days, hours, minutes and seconds
//             var hours = Math.floor(
//                 (distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)
//             );
//             var minutes = Math.floor(
//                 (distance % (1000 * 60 * 60)) / (1000 * 60)
//             );
//             var seconds = Math.floor((distance % (1000 * 60)) / 1000);

//             // Output the result in an element with id="demo"
//             document.getElementById("countdown").innerHTML =
//                 hours + "h " + minutes + "m " + seconds + "s ";

//             // If the count down is over, write some text
//             if (distance < 0) {
//                 clearInterval(x);
//                 document.getElementById("countdown").innerHTML = "TIME'S UP";
//             }
//         }, 1000);
//     }
//     countdownTimeStart();

//     // let url = "http://192.168.1.238:8080/hackathon/api/user";

//     // axios.get(url).then(getInfo);
// };

// function getInfo(response) {
//     let list = document.getElementById("getListVideos");
//     let info = response.data;
//     console.log(response);

//     info.forEach((i) => {
//         list.innerHTML += `
//                     <div class="col-sm-5 inside">
//                         <i class="fas fa-user"></i>
//                         <h5 class="card-title">${i.userName}</h5>
//                         <a href="#" class="btn btn-primary my-uploads">My uploads</a>
//                     </div>`;
//     });
// }

// function getListVideosUser() {
//     let url = "http://192.168.1.238:8080/hackathon/api/user/1";

//     axios.get(url).then(getInfo);
// }

// function getInfo(response) {
//     let list = document.getElementById("getListVideos");
//     let info = response.data;
//     console.log(response);

//     info.forEach((i) => {
//         list.innerHTML += `
//                     <div class="col-sm-5 inside">
//                         <i class="fas fa-user"></i>
//                         <h5 class="card-title">${i.userName}</h5>
//                         <a href="#" class="btn btn-primary my-uploads">My uploads</a>
//                     </div>`;
//     });
// }

var clicks1 = 0;
var clicks2 = 0;
var clicks3 = 0;
var clicks4 = 0;

function rating1() {
    clicks1 += 1;
    document.getElementById("numberLikes1").innerHTML = clicks1;
}

function rating2() {
    clicks2 += 1;
    document.getElementById("numberLikes2").innerHTML = clicks2;
}

function rating3() {
    clicks3 += 1;
    document.getElementById("numberLikes3").innerHTML = clicks3;
}

function rating4() {
    clicks4 += 1;
    document.getElementById("numberLikes4").innerHTML = clicks4;
}
