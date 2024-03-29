$.post("/logout", function() {
    $(".unauthenticated").show();
    $(".authenticated").hide();
})

$.ajaxSetup({
  beforeSend : function(xhr, settings) {
    if (settings.type == 'POST' || settings.type == 'PUT'
        || settings.type == 'DELETE') {
      if (!(/^http:.*/.test(settings.url) || /^https:.*/
        .test(settings.url))) {
        // Only send the token to relative URLs i.e. locally.
        xhr.setRequestHeader("X-XSRF-TOKEN", Cookies.get('XSRF-TOKEN'));
      }
    }
  }
});