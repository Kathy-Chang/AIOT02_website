$('#sign-up').on('click', function() {
	$('#sign-up-modal').addClass('animationIn');
	$('#sign-up-modal').removeClass('animationOut');
});

$('#face-sign-up').on('click', function() {setTimeout(function() {
	$('#face-sign-up-modal').addClass('animationIn');
	$('#face-sign-up-modal').removeClass('animationOut');
}, 4000)}
	


);

$('#close-modal').on('click', function() {
	$('#sign-up-modal').removeClass('animationIn');
	$('#sign-up-modal').addClass('animationOut');
});

$('#face-close-modal').on('click', function() {
	$('#face-sign-up-modal').removeClass('animationIn');
	$('#face-sign-up-modal').addClass('animationOut');
});

$('#password-reveal').on('click', function() {
	if ($('#password').attr('type') === "password") {
		$('#password').attr('type', 'text');
	} else {
		$('#password').attr('type', 'password');
	}
});
