<%@page contentType="text/html" pageEncoding="UTF-8"%><%@taglib prefix="spring" uri="http://www.springframework.org/tags"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
    <c:when test="${jsonArrayStations.length() > 0}">
        <c:forEach begin="0" end="${jsonArrayStations.length() -1}" var="index">            
            <c:choose>
                <c:when test="${index < 5}">
                    <div class="well-sm">
                        <button class="btn btn-block btn-lg btn-primary" onclick="javascript:replay('${jsonArrayStations.getJSONObject(index).getString("urlStreaming")}', '${jsonArrayStations.getJSONObject(index).getString("name")}');">                        
                            <span style="float: left">
                                <i class="fa fa-play" style="margin-right: 5px;"></i>
                                ${jsonArrayStations.getJSONObject(index).getString("name")}
                            </span>
                        </button>
                        <div style="float: right">                            
                            <span class="label label-default">${jsonArrayStations.getJSONObject(index).get("country").getString("name")}</span>
                            <c:forEach begin="0" end="${jsonArrayStations.getJSONObject(index).getJSONArray('genre').length() -1}" var="g">
                                <span class="label label-danger">${jsonArrayStations.getJSONObject(index).getJSONArray("genre").getJSONObject(g).get("name")}</span>
                            </c:forEach>
                            <c:forEach begin="0" end="${jsonArrayStations.getJSONObject(index).getJSONArray('language').length() -1}" var="l">
                                <span class="label label-success">${jsonArrayStations.getJSONObject(index).getJSONArray("language").getJSONObject(l).get("name")}</span>
                            </c:forEach>
                        </div>
                        <br/>
                    </div>
                </c:when>
            </c:choose>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <div class="alert alert-info">
            <i class="fa fa-times"></i> <spring:message code="text11"/>
        </div>        
    </c:otherwise>
</c:choose>
