$(function () {
    $.get("/api/articles/", function (data) {
        for (var i = 0; i < data.length; i++) {
            var html =
                '     <div class="article-preview">\n' +
                '                <h2 class="name">' + data[i].header + '</h2>\n' +
                '                <div class="time">' + data[i].creationDate + '</div>\n' +
                '                <div class="preview-text">\n' + data[i].preview +
                '                </div>\n' +
                '                \n' +
                '                <button class="read-more">Read more</button>\n' +
                '            </div>';
            $("main")
                .append($(html));
        }
    });
});