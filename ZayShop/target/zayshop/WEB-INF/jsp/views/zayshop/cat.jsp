<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>

<div class="clearfix content">
	<div class="content_title">
		<h2>Our Works</h2>
	</div>

	<div class="clearfix single_work_container">
		<c:choose>
			<c:when test="${not empty landsList }">
				<c:forEach items="${landsList }" var="item">
					<div class="clearfix single_work">
						<img class="img_top"
							src="${pageContext.request.contextPath}/resources/files/${item.picture}"
							alt="" /> <img class="img_bottom"
							src="${contextPath }/images/work_bg2.png" alt="" />
						<h2>${item.lname }</h2>
						<a href="${pageContext.request.contextPath}/detail/${item.lid}"><p class="caption">${item.description}</p></a>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>

			</c:otherwise>
		</c:choose>

		<c:if test="${totalPage > 1 and currentPage != ''}">
			<div class="clearfix work_pagination">
				<nav>
					<a class="newer floatleft" href="${pageContext.request.contextPath}/cat/${currentPage-1}"> <-- Trang trước</a> <a
						class="older floatright" href="${pageContext.request.contextPath}/cat/${currentPage+1}">Trang kế -- ></a>
				</nav>
			</div>
		</c:if>

	</div>
</div>
