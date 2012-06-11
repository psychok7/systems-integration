$(document).ready(function(){         
		
    $("textarea").click(function(){
           
        $(this).val("");
    });
		
    $("input").click(function(){
        if ($(this).attr("type")=="submit"){
            return;
        }
        $(this).val("");
    });		
    
    $("input.post-image").click(function(){
        if (this.checked){
            $("aside.photo-post").removeClass("hidden");
        }
        else{
            $("aside.photo-post").addClass("hidden");
        }
        
    });
  
});



	

