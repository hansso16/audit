
$(document).ready(function () {
	initMap(parseFloat(lat), parseFloat(lng))
});

let map;
var lat = $('.mapa').attr('data-latitude');
var lng = $('.mapa').attr('data-longitude');
function initMap(lat, lng) {
    map = new google.maps.Map(document.getElementById("map"), {
        center: {lat: lat, lng: lng},
        zoom: 17
    });
    
    new google.maps.Marker({
	    position: {lat: lat, lng: lng},
	    map,
	    title: "Customer Coordinates",
	  });
}