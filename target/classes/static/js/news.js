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

var pages = 0;

$.ajax({
    url: url,
    method: "GET",
    error: function() {
        console.log("Sry: Error with the data");
    },
    success: function(data) {
		processData(data, pages);
    }
});

function processData(data, pages) {
    var articleItems = [];

    for (var i = pages; i < pages + 4; i++) {
        if(data.articles.length >= pages) {
            $(".newsArrows").empty();
            var $arrows = $('<i class="ion-ios-arrow-back" onclick="clickBack()"></i>');
            $(".newsArrows").append($arrows);
        }
        var source = data.articles[i].source.name;
        var author = data.articles[i].author;
        var title = data.articles[i].title;
        var description = data.articles[i].description.substring(0, 180) + "...";
        var urlToImage = data.articles[i].urlToImage;
        var publishedAt = data.articles[i].publishedAt; //todo
        var content = data.articles[i].content; //todo
        var artUrl = data.articles[i].url;

        if (artUrl.substr(-1) == '/') artUrl = artUrl.replace(/\/$/, '');
        if (urlToImage == null || urlToImage == "" || urlToImage.charAt(0) == '/') urlToImage = "/img/default-art-pic.jpg";
        if (author == null) author = "Anonym";
        if(description == null) description = "Click on to read further!";


        var $containerDiv = $('<div class="floatDiv"></div>');

        var $source = $('<div class="source"><strong>' + source + "</strong></div >");

        var $author = $('<span class="author">Author: ' + author + "</span >");

        var $title = $('<div class="title">' + title + "</div>");

        var $urlToImage = $(
            "<img class=urlToImage width='280px' height='110px' src=" + urlToImage + ">"
        );

        var $description = $('<div class="description">' + description + "</div >");

        var $clickImg = $(
            "<a class=clickIco target='_blank' href=" + artUrl + '><i class="ion-arrow-right-a"></i></a>"'
        );

        var $span = $('<span class="newsLine" id="span' + i + '"></span>');

        if(i % 2 == 0){
            $(".newsFeed").append($span);
            $span.append($containerDiv);
            $containerDiv.append($source, $author, $title, $urlToImage, $description, $clickImg);

        } else {
            $("#span" + (i - 1)).append($containerDiv);
            $containerDiv.append($source, $author, $title, $urlToImage, $description, $clickImg);

        }
		
    }
    if (!(pages > 3)){
        $(".newsArrows").empty();
        var $arrows = $('<i class="ion-ios-arrow-forward" onclick="clickForward()"></i>');
        $(".newsArrows").append($arrows);
    } else {
        addArrows();
    }
    
}

function addArrows() {
    $(".newsArrows").empty();

    var $arrows = $('<i class="ion-ios-arrow-back" onclick="clickBack()"></i><i class="ion-ios-arrow-forward" onclick="clickForward()"></i>');

    $(".newsArrows").append($arrows);
} 

function clickForward() {
    $('.newsFeed').empty();
    $('.newsArrow').empty();

	pages = pages + 4;

    $.ajax({
        url: url,
        method: "GET",
        error: function() {
            console.log("Sry: Error with the data");
        },
        success: function(data) {
            processData(data, pages);
        }
    });
    $(location).attr('href', "#newsFeed");
}

function clickBack() {
    $('.newsFeed').empty();
    $('.newsArrow').empty();

	pages = pages - 4;

    $.ajax({
        url: url,
        method: "GET",
        error: function() {
            console.log("Sry: Error with the data");
        },
        success: function(data) {
            processData(data, pages);
        }
    });
    $(location).attr('href', "#newsFeed");

}