<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="<spring:message code="text8" />">
    <head><title><spring:message code="text1"/></title><jsp:include page="links.jsp" /><jsp:include page="metas.jsp" /></head>
    <body><spring:htmlEscape defaultHtmlEscape="true" /><div id="jumbotron" class="jumbotron text-center _10"><div class="header-text-shadow"><h1><spring:message code="text2"/></h1><p class="lead"><spring:message code="text3"/><br/><spring:message code="text4"/></p></div><br/><br/><br/><br/><br/><br/><br/><br/></div><div class="container"><div class="row"><div class="col-lg-5 text-center"><audio id="radioPlayer"></audio><button type="button" id="playButton" onclick="clickPlayButton()" class="btn btn-lg btn-danger"><i class="fa fa-play"></i></button><span class="_11"></span><button type="button" id="pauseButton" onclick="clickPauseButton()" class="btn btn-lg btn-primary"><i class="fa fa-pause"></i></button><span class="_11"></span><button type="button" id="stopButton" onclick="clickStopButton()" class="btn btn-lg btn-primary"><i class="fa fa-stop"></i></button><span class="_11"></span>                    
                    <button type="button" id="increaseVolumenButton" onclick="increaseVolumen()" class="btn btn-lg btn-primary"><i class="fa fa-plus-square"></i></button>
                    <span class="_11"></span>
                    <button type="button" id="decreaseVolumenButton" onclick="decreaseVolumen()" class="btn btn-lg btn-primary"><i class="fa fa-minus-square"></i></button>                                                            
                </div>              
                <div class="col-lg-7 text-center">                                        
                    <div id="stationName" class="text-center rectangleGrey fontSize25 _12">
                        <spring:message code="text5"/>
                    </div>
                </div>   
            </div>   
            <br/><br/><br/>
            <div class="row">
                <div class="col-md-6">
                    <button id="lessStationsButton" class="btn btn-success btn-lg btn-block" onclick="lessStations()" disabled>
                        <i class="fa fa-backward"></i> <spring:message code="text12"/>
                    </button>&nbsp;                    
                </div>
                <div class="col-md-6">
                    <button id="moreStationsButton" class="btn btn-success btn-lg btn-block" onclick="moreStations()">
                        <spring:message code="text9"/> <i class="fa fa-forward"></i>
                    </button>                    
                </div>
            </div>
            <br/>
            <div class="row">
                <jsp:include page="googleAd.jsp"/>
                <div class="col-md-8">                    
                    <div id="stationsUp"></div>
                </div>
            </div>
            <br/>
            <div class="row">
                <jsp:include page="googleAd2.jsp"/>
                <div class="col-md-8">
                    <div id="stationsDown"></div>                    
                </div>
            </div>
            <br/>
            <div class="row">                
                <div class="col-md-12 text-center"><p>neutroware.com.</p></div>
            </div>
        </div>        
        <div id="modalLoading" class="_8">
            <div class="_9 text-center"><img src="<c:url value="/resources/images/484.GIF"/>" alt="" height="128" width="128"/></div>            
        </div>        
            <jsp:include page="scripts.jsp" />
    </body>
</html>
