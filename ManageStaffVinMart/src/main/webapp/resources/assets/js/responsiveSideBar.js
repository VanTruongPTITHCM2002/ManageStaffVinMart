const roleAccount = $(".role-account > span").text();
const asideWidth = $("aside").width();

$(".header__menu-show-sidebar").css("left", `${asideWidth}px`);

// Xử lý khi click vào menu trên Header thì sẽ ẩn đi vài thông tin trên menu.
$(document).ready(function () {
  $(".header__menu-show-sidebar").click(() => {
    $(".side-bar__item-link > span").toggleClass("collapsed");
    $(".icon-caret").toggleClass("collapsed");

    if (roleAccount === $(".role-account > span").text()) {
      $(".bi-caret-down-fill").click();
      $(".role-account > span").text(
        $(".role-account > span").text().substring(0, 2).toUpperCase()
      );
      $(".side-bar__item-link").css("justify-content", "center");
    } else {
      $(".role-account > span").text(roleAccount);
      $(".side-bar__item-link").css("justify-content", "space-between");
    }

    $(".side-bar__sublist").toggleClass("collapsed");
    setTimeout(() => {
      const asideWidth = $("aside").width();
      $(".header__menu-show-sidebar").css("left", `${asideWidth}px`);
    }, 500);
  });
});

$(document).ready(function () {
  $(".side-bar__item").click(() => {
    if (roleAccount != $(".role-account > span").text()) {
      $(".header__menu-show-sidebar").click();
    }
  });
});
