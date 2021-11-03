<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
<c:url value="/resources/zayshop" var="contextPath" scope="application"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Zay Shop eCommerce HTML CSS Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="${contextPath }/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="${contextPath } /img/favicon.ico">

    <link rel="stylesheet" href="${contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath }/css/templatemo.css">
    <link rel="stylesheet" href="${contextPath }/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="${contextPath }/css/fontawesome.min.css">
<!--
    
TemplateMo 559 Zay Shop

https://templatemo.com/tm-559-zay-shop

-->
</head>

<body>
    <!-- Start Top Nav -->
   <tiles:insertAttribute name="header" />
    <!-- Close Header -->

    <!-- Modal -->
     <tiles:insertAttribute name="content" />
    <!-- End Featured Product -->


    <!-- Start Footer -->
    <footer class="bg-dark" id="tempaltemo_footer">
          <tiles:insertAttribute name="footer" />

    </footer>
    <!-- End Footer -->

    <!-- Start Script -->
    <script src="${contextPath } /js/jquery-1.11.0.min.js"></script>
    <script src="${contextPath } /js/jquery-migrate-1.2.1.min.js"></script>
    <script src="${contextPath } /js/bootstrap.bundle.min.js"></script>
    <script src="${contextPath } /js/templatemo.js"></script>
    <script src="${contextPath } /js/custom.js"></script>
    <!-- End Script -->
</body>

</html>