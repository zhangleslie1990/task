// $(function () {
//     $.ajax({
//         type : 'GET',
//         dataType : 'json', // 数据类型配置成jsonp
//         //jsonp : "callback", //配置jsonp随机码标签,在服务器代码部分需要用到他来拼接一个json的js对象
//         url : 'http://pv.sohu.com/cityjson?ie=utf-8', //服务路径
//         success : function (response) {
//             if(response.code == 200){
//                 alert('返回成功！');
//             }else{
//                 alert('服务器异常！');
//             }
//         },
//         error : function (){
//             alert('服务器异常！');
//         }
//     });
// })
// url:'http://pv.sohu.com/cityjson?ie=utf-8',


// navigator.geolocation.getCurrentPosition( // 该函数有如下三个参数
//     function(pos){ // 如果成果则执行该回调函数
//         alert(
//             '  经度：' + pos.coords.latitude +
//             '  纬度：' + pos.coords.longitude +
//             '  高度：' + pos.coords.altitude +
//             '  精确度(经纬)：' + pos.coords.accuracy +
//             '  精确度(高度)：' + pos.coords.altitudeAccuracy +
//             '  速度：' + pos.coords.speed
//         );
//     }, function(err){ // 如果失败则执行该回调函数
//         alert(err.message);
//     }, { // 附带参数
//         enableHighAccuracy: false, // 提高精度(耗费资源)
//         timeout: 3000, // 超过timeout则调用失败的回调函数
//         maximumAge: 1000 // 获取到的地理信息的有效期，超过有效期则重新获取一次位置信息
//     }
// );
//


function getlocation() {
    var getLocation = function (successFunc, errorFunc) {
        //successFunc获取定位成功回调函数，errorFunc获取定位失败回调
        //首先设置默认城市
        var defCity = {
            id: '000001',
            name: '北京市',
            date: curDateTime()//获取当前时间方法
        };
        //默认城市
        $.cookie('VPIAO_MOBILE_DEFAULTCITY', JSON.stringify(defCity), {expires: 1, path: '/'});
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                    var lat = position.coords.latitude;
                    var lon = position.coords.longitude;
                    //var map = new BMap.Map("container");  // 创建Map实例
                    var point = new BMap.Point(lon, lat); // 创建点坐标
                    var gc = new BMap.Geocoder();
                    gc.getLocation(point, function (rs) {
                        var addComp = rs.addressComponents;
                        var curCity = {
                            id: '',
                            name: addComp.province,
                            date: curDateTime()
                        };
                        //当前定位城市
                        $.cookie('VPIAO_MOBILE_CURRENTCITY', JSON.stringify(curCity), {expires: 7, path: '/'});
                        //alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street);
                        if (successFunc != undefined)
                            successFunc(addComp);
                    });
                },
                function (error) {
                    switch (error.code) {
                        case 1:
                            alert("位置服务被拒绝。");
                            break;
                        case 2:
                            alert("暂时获取不到位置信息。");
                            break;
                        case 3:
                            alert("获取位置信息超时。");
                            break;
                        default:
                            alert("未知错误。");
                            break;
                    }
                    var curCity = {
                        id: '000001',
                        name: '北京市',
                        date: curDateTime()
                    };
                    //默认城市
                    $.cookie('VPIAO_MOBILE_DEFAULTCITY', JSON.stringify(curCity), {expires: 1, path: '/'});
                    if (errorFunc != undefined)
                        errorFunc(error);
                }, {timeout: 5000, enableHighAccuracy: true});
        } else {
            alert("你的浏览器不支持获取地理位置信息。");
            if (errorFunc != undefined)
                errorFunc("你的浏览器不支持获取地理位置信息。");
        }
    };
    var showPosition = function (position) {
        var lat = position.coords.latitude;
        var lon = position.coords.longitude;
        //var map = new BMap.Map("container");  // 创建Map实例
        var point = new BMap.Point(lon, lat); // 创建点坐标
        var gc = new BMap.Geocoder();
        gc.getLocation(point, function (rs) {
            var addComp = rs.addressComponents;
            var curCity = {
                id: '',
                name: addComp.province,
                date: curDateTime()
            };
            //当前定位城市
            $.cookie('VPIAO_MOBILE_CURRENTCITY', JSON.stringify(curCity), {expires: 7, path: '/'});
            //alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street);
        });
    };
    var showPositionError = function (error) {
        switch (error.code) {
            case 1:
                alert("位置服务被拒绝。");
                break;
            case 2:
                alert("暂时获取不到位置信息。");
                break;
            case 3:
                alert("获取位置信息超时。");
                break;
            default:
                alert("未知错误。");
                break;
        }
        var curCity = {
            id: '000001',
            name: '北京市',
            date: curDateTime()
        };
        //默认城市
        alert(curCity)
        $.cookie('VPIAO_MOBILE_DEFAULTCITY', JSON.stringify(curCity), {expires: 1, path: '/'});
    };
}