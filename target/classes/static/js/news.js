function dailyDate(dateIn) {
    var yyyy = dateIn.getFullYear();
    var mm = dateIn.getMonth() + 1;
    var dd  = dateIn.getDate();
    return String(yyyy + "-" + mm + "-" + dd);
}

function minusDaysDate(dateIn) {
    var yyyy = dateIn.getFullYear();
    var mm = dateIn.getMonth() + 1;
    var dd  = dateIn.getDate() - 3;
    return String(yyyy + "-" + mm + "-" + dd);
}

var today = new Date();
var minusDay = new Date();

var url = "https://newsapi.org/v2/everything?q=silicon&from=" + minusDaysDate(minusDay) +"&to=" + dailyDate(today) + "&sortBy=popularityt&apiKey=c1de183520fa4c1d9955791d4593104f";

$.ajax({
    url: url,
    method: "GET",
    error: function() {
        console.log("Sry: Error with the data");
    },
    success: function(data) {
        processData(data);
    }
});

function processData(data) {
    var articleItems = [];

    for (var i = 0; i < data.articles.length; i++) {
        var source = data.articles[i].source.name;
        var author = data.articles[i].author;
        var title = data.articles[i].title;
        var description = data.articles[i].description;
        var urlToImage = data.articles[i].urlToImage;
        var publishedAt = data.articles[i].publishedAt; //todo
        var content = data.articles[i].content; //todo
        var artUrl = data.articles[i].url;

        if (artUrl.substr(-1) == '/') artUrl = artUrl.replace(/\/$/, '');

        if (urlToImage == null || urlToImage == "" || urlToImage.charAt(0) == '/') urlToImage = "https://techtalk.vn/wp-content/uploads/2017/08/silicon-valley.jpg";

        if (author == null) author = "Anonym";


        var $source = $('<div class="source">Source: ' + source + "</div >");

        var $author = $('<div class="author">Author: ' + author + "</div >");

        var $title = $('<div class="title">' + title + "</div>");

        var $urlToImage = $(
            "<div class=urlToImage><img width='450px' src=" + urlToImage + "></div>" //kellene masik meret ide
        );

        var $description = $('<div class="description">' + description + "</div >");

        var $clickImg = $(
            "<a class=clickImg href=" + artUrl + '><img width="50" src="https://static.thenounproject.com/png/962936-200.png"></a>"'
        );

        $(".newsFeed").append($source, $author, $title, $urlToImage, $description, $clickImg);
        console.log(artUrl);
    }
}