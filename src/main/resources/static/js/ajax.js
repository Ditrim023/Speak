function getIdRoom(index) {
    var editUrl = "/answer-from-bot/" + index;
        $.ajax({
            type: 'GET',
            url: editUrl,
            success: function () {
            }
        });

}

