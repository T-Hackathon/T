function initMap() {
    const map = new google.maps.Map(document.getElementById("map"), {
        zoom: 13,
        center: { lat: 41.15900821038467, lng: -8.630699560807537 },
        mapTypeId: "satellite",
    });

    const pontos = [
        [{ lat: 41.15900821038467, lng: -8.630699560807537 }, "Casa Da Música"],
        [
            { lat: 41.14567371240455, lng: -8.614571558959996 },
            "Torre Dos Clerigos",
        ],
        [
            { lat: 41.16214516368047, lng: -8.583642553508033 },
            "Estádio do Dragão",
        ],
        
        [{ lat: 41.14047938906908, lng: -8.612548425238394 }, "Ribeira"],
        [{ lat: 41.153883156890835, lng: -8.610325444138175 }, "Perola Negra"],
        [
            { lat: 41.17868958276211, lng: -8.586933272972944 },
            "Academia De Código",
        ],
    ];

    const image = "";

    const infoWindow = new google.maps.InfoWindow();

    const locationButton = document.createElement("button");
    locationButton.textContent = "Go To Current Location";
    locationButton.classList.add("custom-map-control-button");
    map.controls[google.maps.ControlPosition.TOP_CENTER].push(locationButton);
    locationButton.addEventListener("click", () => {
        // Try HTML5 geolocation.
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(
                (position) => {
                    const pos = {
                        lat: position.coords.latitude,
                        lng: position.coords.longitude,
                    };
                    infoWindow.setPosition(pos);
                    infoWindow.setContent("Location found.");
                    infoWindow.open(map);
                    map.setCenter(pos);
                },
                () => {
                    handleLocationError(true, infoWindow, map.getCenter());
                }
            );
        } else {
            // Browser doesn't support Geolocation
            handleLocationError(false, infoWindow, map.getCenter());
        }
    });

    pontos.forEach(([position, title], i) => {
        const marker = new google.maps.Marker({
            position,
            map,
            title: `${i + 1}. ${title}`,
            label: `${i + 1}`,
            optimized: false,
        });
        // Add a click listener for each marker, and set up the info window.
        marker.addListener("click", () => {
            infoWindow.close();
            infoWindow.setContent(marker.getTitle());
            infoWindow.open(marker.getMap(), marker);
        });
    });

    // const map = new google.maps.Map(document.getElementById("map"), {
    //     zoom: 14,
    //     mapTypeId: 'satellite',
    //     center: perolaNegra,
    // });

    // new google.maps.Marker({
    //     position: casaDaMusica,
    //     map,
    //     title: "Casa da Música",
    // });

    // new google.maps.Marker({
    //     position: torreDosClerigos,
    //     map,
    //     title: "Torre dos Clérigos",
    // });

    // new google.maps.Marker({
    //     position: estadioDoDragao,
    //     map,
    //     title: "Estádio do Dragão",
    // });

    // new google.maps.Marker({
    //     position: ponteDLuis,
    //     map,
    //     title: "Ponte D. Luís",
    // });

    // new google.maps.Marker({
    //     position: ribeira,
    //     map,
    //     title: "Ribeira",
    // });

    // new google.maps.Marker({
    //     position: perolaNegra,
    //     map,
    //     title: "Pérola Negra",
    // });

    // oi = new google.maps.Marker({
    //     position: academiaDeCodigo,
    //     map,
    //     title: "<Academia de Código_>",
    //     optimized: false,
    // });
}
