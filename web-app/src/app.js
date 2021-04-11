// SHOW MODAL
$(window).on("load", function () {
    $("#accessModal").modal("show");
    // if ($("#countdown") === "TIME'S UP" || $("#countdown") === null) {
    // }
});

let start = document.getElementById("start");
start.onclick = function () {
    // start count
    countdownTimeStart();
    // Update the count down every 1 second
    setInterval(countdownTimeStart, 1000);

    $("#accessModal").modal("hide");
};

function countdownTimeStart() {
    var countDownDate = new Date();
    countDownDate.setHours(countDownDate.getHours() + 24, 0, 0, 0);

    // Get todays date and time
    var now = new Date().getTime();

    // Find the distance between now an the count down date
    var distance = countDownDate - now;

    // Time calculations for days, hours, minutes and seconds
    var hours = Math.floor(
        (distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)
    );
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);

    // Output the result in an element with id="demo"
    document.getElementById("countdown").innerHTML =
        hours + "h " + minutes + "m " + seconds + "s ";

    // If the count down is over, write some text
    if (distance < 0) {
        clearInterval(x);
        document.getElementById("countdown").innerHTML = "TIME'S UP";
    }
}

// RATING VIDEOS
let clicks1 = 0;
let clicks2 = 0;
let clicks3 = 0;
let clicks4 = 0;

function rating1() {
    clicks1 += 1;
    $("#numberLikes1").innerHTML = clicks1;
}

function rating2() {
    clicks2 += 1;
    $("#numberLikes2").innerHTML = clicks2;
}

function rating3() {
    clicks3 += 1;
    $("#numberLikes3").innerHTML = clicks3;
}

function rating4() {
    clicks4 += 1;
    $("#numberLikes4").innerHTML = clicks4;
}
