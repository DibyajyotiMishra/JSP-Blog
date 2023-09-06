 console.log("loaded");


function updateLikes(blogId) {
    $.ajax({
        url: "like",
        data: {blogId: blogId},
        success: function (data, textStatus, jqXHR) {
            if(data.trim() != '0') {
                $('.like-counter').html(data.trim());
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);
        }
    });
}
