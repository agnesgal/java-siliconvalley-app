 $.ajax({
    url:
        "https://newsapi.org/v2/everything?q=silicon&from=2018-11-06&sortBy=popularity&apiKey=c1de183520fa4c1d9955791d4593104f",
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
        var author = data.articles[i].author;
        var title = data.articles[i].title;
        var description = data.articles[i].description;
        var urlToImage = data.articles[i].urlToImage;
        var publishedAt = data.articles[i].publishedAt; //todo
        var content = data.articles[i].content; //todo
        var artUrl = data.articles[i].url;

        if (artUrl.substr(-1) == '/') artUrl = artUrl.replace(/\/$/, '');

        var $author = $('<div class="author">Author: ' + author + "</div >");

        var $title = $('<div class="title">' + title + "</div>");

        var $urlToImage = $(
            "<div class=urlToImage><img width='450px' src=" + urlToImage + "></div>" //kellene masik meret ide
        );

        var $description = $('<div class="description">' + description + "</div >");

        var $clickImg = $(
            "<a class=clickImg href=" + artUrl + '><img width="50" src="https://static.thenounproject.com/png/962936-200.png"></a>"'
        );

            $(".newsFeed").append($author, $title, $urlToImage, $description, $clickImg);
        console.log(artUrl);
    }
}