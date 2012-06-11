//Useful links:
// http://code.google.com/apis/maps/documentation/javascript/reference.html#Marker
// http://code.google.com/apis/maps/documentation/javascript/services.html#Geocoding
// http://jqueryui.com/demos/autocomplete/#remote-with-cache
      
var geocoder;
var map=null;
var marker;
var markers_array = new Array();  

var attrs = {
        'results':"",
        'locale':null,
        'map':null,
        'infowindow':null        
    }

var settings = {
      'longitude'  : false,
      'sensor':"false",
      'latitude':false,
      'zoom':15,
      'radius' : 5000,
      'types' : false,
      'clear':true,
      'name':false,
      'map_type':"satellite",
      'language':'en',
      'map_id':"map",
      "debug":false,
      'html_container':true,
      'output_format':"list"
      
    };
    
function initialize(){
	var latlng = new google.maps.LatLng(40.20952,-8.42978);
	var options = {
		zoom: settings.zoom,
		center: latlng,
		mapTypeId: get_map_type()
  };
        
	map = new google.maps.Map(document.getElementById("map_canvas"), options);
        
	//GEOCODER
	geocoder = new google.maps.Geocoder();
        
	marker = new google.maps.Marker({
		map: map,
		title: "Search Target",
		position: latlng,
		draggable: true
	});
	attrs.locale = latlng;
	attrs.infowindow = new google.maps.InfoWindow();
          
}

function add_listeners(){
	//Add listener to marker for reverse geocoding
	google.maps.event.addListener(marker, 'drag', function() {
		geocoder.geocode({'latLng': marker.getPosition()}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (results[0]) {
					$('#address').val(results[0].formatted_address);
					$('#latitude').val(marker.getPosition().lat());
					$('#longitude').val(marker.getPosition().lng());
					}
				}
			});
	
		});
    
    //Add listener to marker for reverse geocoding
	google.maps.event.addListener(map, 'click', function(event) {
		geocoder.geocode({'latLng': event.latLng}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (results[0]) {
					marker.setPosition(event.latLng);
					$('#address').val(results[0].formatted_address);
					//$('#latitude').val(marker.getPosition().lat());
					//$('#longitude').val(marker.getPosition().lng());
					}
				}
			});
	});
	
}
        

function build_search(types){
	attrs.locale=marker.getPosition();
	var r={radius:settings.radius, location:attrs.locale};
	r.types = types.split(",");
	return r;
}        


function run_search(request){
	clear_markers();
	if (map){
		var service = new google.maps.places.PlacesService(map);
		service.search(request, output_results);
	}
	
    
}

function output_results(results, status, $obj){
	html= "<h3>" +results.length + " results</h3>";
		if (results.length>0) {
			var the_place = null;
			if (status == google.maps.places.PlacesServiceStatus.OK){
				before = "<ul>";				
				middle_tags = "<br>";
				close_tags = "</li>";
				after = "</ul>";
				html += before;
				for (var i = 0; i < results.length; i++){
					the_place = results[i];
					var item = "";
					//show item
					open_tags = "<li id='"+the_place.id+"' class='result-item'>";		
					
					item+= open_tags;
					item+= "<img src='"+the_place.icon+"' width='32px' height='32px'/>";
					item+= middle_tags;
					
					item+= "<b>"+the_place.name+"</b>";
					item+= middle_tags;
					item+= "<span class='small'>"+the_place.vicinity +"</span>"; 
					item+= middle_tags;
					
					if (the_place.rating){
						item+= "<span class='small'>Public Rating: " + the_place.rating+"</span>";
						item+= middle_tags;
					}
					//create form
					var form = "<form id='";
					form += the_place.id + "' action='profile.html' method='post'>";
					form += "<input type='hidden' name='place_icon' value='"
					form += the_place.icon+"'>";
					form += "<input type='hidden' name='place_name' value='";
					form += the_place.name+"'>";
					form += "<input type='hidden' name='place_vicinity' value='";
					form += the_place.vicinity+"'>";
					if (the_place.rating){
						form += "<input type='hidden' name='place_rating' value='";
						form += the_place.rating+"'>";
					}
					form += "<input class='post-to-wall' type='submit' value='Post to Wall'>";
					form += "</form>";
					
					item+= form;
					item+= close_tags;
						
					if (settings.html_container){
						html+=item;
					}
					add_marker(the_place,item);
				}
				html += after;
			}
		}
        if(settings.html_container){
			$("#map-output").html(html);
		}	
}

function add_marker(place,more_info_link){
	var placeLoc = place.geometry.location;
    var image = new google.maps.MarkerImage(place.icon, new google.maps.Size(20,20),new google.maps.Point(0,0), new google.maps.Point(13,18),new google.maps.Size(20,20));
    var place_marker = new google.maps.Marker({
			map: map,
            position: place.geometry.location,
            icon:image
		});
            
         markers_array.push(place_marker);
			google.maps.event.addListener(place_marker, 'click', function() {
            attrs.infowindow.setContent("<div>"+more_info_link);
            attrs.infowindow.open(map, this);
		});
}

function clear_markers(){
	 if (markers_array != null){
		for (i in markers_array){
			markers_array[i].setMap(null);
		}
		$("#results-output").html("");
	}
	else{
		alert("marker null");
	}
	
}

function inc_radius(){
	settings.radius = settings.radius + 1000;
		$("#radius").text(settings.radius+ " meters");
	}
        
function dec_radius(){
	if (settings.radius>1000){
		settings.radius = settings.radius - 1000;
		$("#radius").text(settings.radius+" meters");
	}
}


function get_map_type(){
	var type = ""
		switch(settings.map_type){
			case "terrain": type = google.maps.MapTypeId.TERRAIN;
				break;
                case "road": type = google.maps.MapTypeId.ROADMAP;
                break;
                case "hybrid":type = google.maps.MapTypeId.HYBRID;
                break;
                case "satellite":type = google.maps.MapTypeId.SATELLITE;
                break;
            }
            return type;
        }
        

function input_search(value){
	if (value!="xx"){
		var request = build_search(value);
		run_search(request)
	}
}

$(document).ready(function() { 
         
  initialize();
                  
  $(function() {
    $("#address").autocomplete({
      //This bit uses the geocoder to fetch address values
      source: function(request, response) {
        geocoder.geocode( {'address': request.term }, function(results, status) {
          response($.map(results, function(item) {
			
            return {
              label:  item.formatted_address,
              value: item.formatted_address,
              latitude: item.geometry.location.lat(),
              longitude: item.geometry.location.lng()
            }
          }));
        })
      },
      //This bit is executed upon selection of an address
      select: function(event, ui) {
        $("#latitude").val(ui.item.latitude);
        $("#longitude").val(ui.item.longitude);
        var location = new google.maps.LatLng(ui.item.latitude, ui.item.longitude);
        marker.setPosition(location);
        map.setCenter(location);
		attrs.locale = location;
      }
    });
  });
  
    add_listeners();
    
    $("#type-search-select").change(function(){
		var value=$(this).val();
		input_search(value);
		
	});
	
	$("#dec-radius").click(function(){
		dec_radius();
		input_search($("#type-search-select").val());
	});
	
	$("#inc-radius").click(function(){
		inc_radius();
		input_search($("#type-search-select").val());
	});
		
		

	});
	
	
	
	
	
