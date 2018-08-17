<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
<script src="http://api.map.baidu.com/api?v=1.4" type="text/javascript"></script>
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
<script src="js/location.js"></script>
<body>

<h5>MOTO大军</h5>
<div style="height:100px;width: 100px">
    <jsp:include page="map/map.jsp"></jsp:include>
</div>
</body>


<script type="text/javascript">
    alert(returnCitySN.cip + "$上海力哥$" + returnCitySN.cname + returnCitySN.cid);
</script>

</html>
