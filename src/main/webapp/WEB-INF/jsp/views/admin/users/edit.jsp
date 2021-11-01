
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp" %>

<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Thêm danh mục</div>
		</div>
		<div class="content-box-large box-with-header">
			<div>
				<div class="row mb-10"></div>
				<form action="${pageContext.request.contextPath}/admin/user/edit/${user.u_id}"
					method="post">
					<div class="row">

						<div class="col-sm-6">

							<div class="form-group">
								<label for="name">UserName</label> <input readonly="readonly" type="text" value="${user.username }"
									class="form-control" name="username">
							</div>
							<div class="form-group">
								<label for="name">Fullname</label> <input type="text" value="${user.fullname }"
									class="form-control" name="fullname">
							</div>
							<div class="form-group">
								<label for="name">Password</label> <input type="password" value="${user.password }"
									class="form-control" name="password">
							</div>
							<div class="form-group">
											<label>Role</label>
											<select name="role_id" class="form-control">
											<c:choose>
												<c:when test="${not empty role}">
													<c:forEach items="${role}" var="item">
														<c:choose>
															<c:when test="${item.id == user.role.id }">
																<option selected="selected" value="${item.id }">${item.name }</option>
															</c:when>
															<c:otherwise>
																<option value="${item.id }">${item.name }</option>
															</c:otherwise>
														</c:choose>
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
							<input type="submit" value="sửa" class="btn btn-success" /> <input
								type="reset" value="Nhập lại" class="btn btn-default" />
						</div>
						</div>
				</form>
			</div>

		</div>
	</div>
</div>
<!-- /.row col-size -->

