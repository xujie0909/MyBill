$('#ca').calendar({
    width: 320,
    height: 320,
    data: [
        {
            date: '2015/12/24',
            value: 'Christmas Eve'
        },
        {
            date: '2015/12/25',
            value: 'Merry Christmas'
        },
        {
            date: '2016/01/01',
            value: 'Happy New Year'
        }
    ],
    onSelected: function (view, date, data) {
        var d = new Date(date);
        var datetime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
        $("#happenTime").val(datetime);
    }
});

/*$('#dd').calendar({
    trigger: '#dt',
    zIndex: 999,
    format: 'yyyy-mm-dd',
    onSelected: function (view, date, data) {
        console.log('event: onSelected')
    },
    onClose: function (view, date, data) {
        console.log('event: onClose')
        console.log('view:' + view)
        console.log('date:' + date)
        console.log('data:' + (data || 'None'));
    }
});*/
