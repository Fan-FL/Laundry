
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch("login/img/backgrounds/1.jpg");
    
    /*
        Form validation
    */
    $('.loginform input[type="text"], .loginform input[type="password"], .loginform textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.loginform').on('submit', function(e) {
    	
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	
    });
    
    
});
