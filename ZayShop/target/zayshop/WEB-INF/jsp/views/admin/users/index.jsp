<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content-box-large">
	<div class="row">
		<div class="panel-heading">
			<div class="panel-title ">Quản lý danh mục</div>
		</div>
	</div>
	<hr>
	<c:if test="${not empty msg }">
		<div class="alert alert-success" role="alert">${msg }</div>
	</c:if>
	<c:if test="${not empty err}">
		<div class="alert alert-warning" role="alert">${err}</div>
	</c:if>
	<div class="row">
		<div class="col-md-8">
			<a href="${pageContext.request.contextPath}/admin/user/add"
				class="btn btn-success"><span class="glyphicon glyphicon-plus"
				aria-hidden="true"></span>&nbsp;Thêm</a>

		</div>
		<div class="col-md-4">
			<div class="input-group form">
				<form action="${pageContext.request.contextPath}/admin/user/index">
				<input type="text" class="form-control" placeholder="Search..."
					name="search"
					value='<c:if test="${not empty search }">${search }</c:if>'>
				<span class="input-group-btn">
				<input class="btn btn-primary" type="submit" value="Search" />
				</span>
				</form>
			</div>

		</div>
	</div>

	<c:choose>
		<c:when test="${not empty userList }">
			<div class="row">
				<div class="panel-body">
					<table cellpadding="0" cellspacing="0" border="0"
						class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>UserName</th>
								<th>Fullname</th>
								<th>Role</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userList}" var="item">
								<tr class="odd gradeX">
									<td>${item.u_id}</td>
									<td>${item.username}</td>
									<td>${item.fullname}</td>
									<td>${item.role.name}</td>
									<td class="center text-center"><a
										href="${pageContext.request.contextPath}/admin/user/edit/${item.u_id}"
										title="" class="btn btn-primary"><span
											class="glyphicon glyphicon-pencil "></span> Sửa</a> <a
										href="${pageContext.request.contextPath}/admin/user/delete/${item.u_id}"
										onclick="return confirm('bạn có chắc muốn xóa?')" title=""
										class="btn btn-danger"><span
											class="glyphicon glyphicon-trash"></span> Xóa</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<p class="msg">Không có danh mục nào</p>
		</c:otherwise>
	</c:choose>
	<c:if test="${totalPage > 1 and currentPage != ''}">
		<!-- Pagination -->
		<nav class="text-center" aria-label="...">
			<ul class="pagination">
				<li class="disabled"><a
					href="${pageContext.request.contextPath}/admin/user/index/${currentPage-1}"
					aria-label="Previous"><span aria-hidden="true">«</span></a></li>
				<c:forEach begin="1" end="${totalPage }" var="i">
					<li class='<c:if test="${i == currentPage }" >active</c:if>'>
						<a href="${pageContext.request.contextPath}/admin/user/index/${i}">${i}
							<span class="sr-only">(current)</span>
					</a>
					</li>
				</c:forEach>
				<li><a
					href="${pageContext.request.contextPath}/admin/user/index/${currentPage+1}"
					aria-label="Next"><span aria-hidden="true">»</span></a></li>
			</ul>
		</nav>
		<!-- /.pagination -->
	</c:if>

</div>
</div>

<!-- /.row -->
</div>

<!-- /.content-box-large -->

