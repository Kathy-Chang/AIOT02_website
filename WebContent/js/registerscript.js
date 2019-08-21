// Variables

var $close = $('.js-close'),
    $intro = $('.default-info'),
    $form = $('.create-account'),
    $started = $('.js-sign-in');

var $errorText = $('.error'),
    $emailInput = $('input[type="email"]'),
    $passwordInput = $('input[type="password"]'),
    $signInBtn = $('#sign-in'),
    $termsText = $('.terms');



// Click event for "Get Started" button
$started.on('click', function() {
  $intro.hide("slow");
  $form.show("slow");
});

// Click event for "Close" button
$close.on('click', function() {
  $form.hide();
  $intro.show();
});

// Make "Sign In" button change text to "Sign Up" when Email Address is entered
$emailInput.on("keyup", function() {
  if ($(this).val().length > 8) {
    $termsText.show("slow");
    $signInBtn.text("Sign Up");
  } 
  else {
    $termsText.hide("slow");
    $signInBtn.text("Sign In");
  }
});

// Make error message appear if a password isn't entered
$signInBtn.on("click", function() {
  if ($passwordInput.val().length === 0 | $emailInput.val().length === 0) {
    event.preventDefault();
    $errorText.show("fast");
  }
  else {
    $form.hide();
    $intro.show();
  }
});