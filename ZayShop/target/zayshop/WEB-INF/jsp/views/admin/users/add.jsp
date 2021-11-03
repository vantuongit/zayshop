
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp" %>


<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Thêm người dùng</div>
		</div>
		<div class="content-box-large box-with-header">
			<div>
				<div class="row mb-10"></div>
				<form action="${pageContext.request.contextPath}/admin/user/add"
					method="post">
					<div class="row">

						<div class="col-sm-6">

							<div class="form-group">
								<label for="username">UserName</label> <input type="text"
									class="form-control" placeholder="Nhập tên người dùng" name="username"
									value = '<c:if test="${not empty user.username }">${user.username }</c:if>'>
									<form:errors path="user.username" cssStyle="color:red" cssClass="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="fullname">Fullname</label> <input type="text"
									class="form-control" placeholder="Nhập tên" name="fullname"
									value = '<c:if test="${not empty user.fullname }">${user.fullname }</c:if>'>>
									<form:errors path="user.fullname"></form:errors>
									<form:errors path="user.fullname" cssStyle="color:red" cssClass="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="password">Password</label> <input type="password"
									class="form-control" placeholder="Nhập mật khẩu" name="password">
									<form:errors path="user.password"></form:errors>
							</div>
							<div class="form-group">
											<label>Role</label>
											<select name="role_id" class="form-control">
											<c:choose>
												<c:when test="${not empty role}">
													<c:forEach items="${role}" var="item">
														<option value="${item.id }">${item.name }</option>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<option>Không có Role</option>
												</c:otherwise>
											</c:choose>
											</select>
										</div>
						</div>
					</div>

					<hr>

					<div class="row">
						<div class="col-sm-12">
							<input type="submit" value="Thêm" class="btn btn-success" /> <input
								type="reset" value="Nhập lại" class="btn btn-default" />
						</div>
						</div>
				</form>
			</div>

		</div>
	</div>
</div>

<!-- /.row col-size -->

