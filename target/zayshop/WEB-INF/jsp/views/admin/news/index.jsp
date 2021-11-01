<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-box-large">
	<div class="row">
		<div class="panel-heading">
			<div class="panel-title ">Quản lý tin</div>
		</div>
	</div>
	<c:if test="${not empty msg }">
		<div class="alert alert-success" role="alert">${msg }</div>
	</c:if>
	<c:if test="${not empty err}">
	</c:if>
	<hr>
	<div class="row">
		<div class="col-md-8">
			<a href="${pageContext.request.contextPath}/admin/news/add"
				class="btn btn-success"><span class="glyphicon glyphicon-plus"
				aria-hidden="true"></span>&nbsp;Thêm</a>

		</div>
		<div class="col-md-4">
			<div class="input-group form">
				<form action="${pageContext.request.contextPath}/admin/news/index"
					method="get">
					<input type="text" class="form-control" placeholder="Search..."
						name="search" value = '<c:if test="${not empty search }">${search }</c:if>' /> 
						<span class="input-group-btn" > 
						<input class="btn btn-primary" type="submit" value="Search" />
					</span>
				</form>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${not empty landsList }">

			<div class="row">
				<div class="panel-body">
					<table cellpadding="0" cellspacing="0" border="0"
						class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên</th>
								<th>Danh mục</th>
								<th>Mô tả</th>
								<th>Lượt đọc</th>
								<th>Hình ảnh</th>
								<th>Chức năng</th>
							</tr>
						</thead>

						<c:forEach items="${landsList }" var="item">
							<tbody>
								<tr class="even gradeA">
									<td>${item.lid}</td>
									<td>${item.lname}</td>
									<td>${item.category.cname}</td>
									<td>${item.description}</td>
									<td class="center">${item.count_views}</td>
									<td class="center text-center"><c:choose>
											<c:when test="${not empty item.picture }">
												<img width="100px" height="70px"
													src="${pageContext.request.contextPath}/resources/files/${item.picture }" />
											</c:when>
											<c:otherwise>
												<p>không có hình ảnh!!!</p>
											</c:otherwise>
										</c:choose></td>
									<td class="center text-center"><a
										href="${pageContext.request.contextPath}/admin/news/edit/${item.lid}"
										title="" class="btn btn-primary"><span
											class="glyphicon glyphicon-pencil "></span> Sửa</a> <a
										href="${pageContext.request.contextPath}/admin/news/delete/${item.lid}"
										onclick="return confirm('bạn có chắc muốn xóa?')"
										title="" class="btn btn-danger"><span
											class="glyphicon glyphicon-trash"></span> Xóa</a></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>

					<c:if test="${totalPage > 1 and currentPage != ''}">
						<!-- Pagination -->
						<nav class="text-center" aria-label="...">
							<ul class="pagination">
								<li class="disabled"><a
									href="${pageContext.request.contextPath}/admin/news/index/${currentPage-1}"
									aria-label="Previous"><span aria-hidden="true">«</span></a></li>
								<c:forEach begin="1" end="${totalPage }" var="i">
									<li class='<c:if test="${i == currentPage }" >active</c:if>'><a
										href=" ${pageContext.request.contextPath}/admin/news/index/${i}">${i }
											<span class="sr-only"></span>
									</a></li>
								</c:forEach>
								<li><a
									href="${pageContext.request.contextPath}/admin/news/index/${currentPage+1}"
									aria-label="Next"><span aria-hidden="true">»</span></a></li>
							</ul>
						</nav>
						<!-- /.pagination -->
					</c:if>
				</div>
			</div>
			<!-- /.row -->
		</c:when>
		<c:otherwise>
			<p>Không có tin nào!!!</p>
		</c:otherwise>
	</c:choose>
</div>
<!-- /.content-box-large -->