
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>

<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Thêm danh mục</div>
		</div>
		<div class="content-box-large box-with-header">


			<form action="" method="post" enctype="multipart/form-data">
				<div>
					<div class="row mb-10"></div>

					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="lname">Tên tin</label> <input type="text"
								value = "${lands.lname }"	name="lname" class="form-control" placeholder="Nhập tên tin">
							</div>

							<div class="form-group">
								<label>Danh mục tin</label>
								 <select name="category.cid" class="form-control">
									<c:choose>
										<c:when test="${not empty cat }">
											<c:forEach items="${cat}" var="item">
												<c:choose>
													<c:when test="${item.cid == lands.category.cid }">
														<option selected="selected" value="${item.cid}">${item.cname }</option>
													</c:when>
													<c:otherwise>
														<option value="${item.cid}">${item.cname }</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<p>Không có danh mục!!!</p>
										</c:otherwise>
									</c:choose>
								</select>
							</div>

							<div class="form-group">
								<label>Thêm hình ảnh</label> <input type="file" name="file"
									class="btn btn-default" id="exampleInputFile1">
								<p class="help-block">
									<em>Định dạng: jpg, png, jpeg,...</em>
								</p>
								<c:if test="${not empty lands.picture }">
									<img with="200px" height="200px" ="ảnh" src="${pageContext.request.contextPath }/resources/files/${lands.picture}" />
								</c:if>
							</div>

							<div class="form-group">
								<label>Mô tả</label>
								<textarea class="form-control" rows="3" name = "description">${lands.description }</textarea>
							</div>
							<div class="form-group">
								<label for="address">Địa chỉ</label> <input type="text" value="${lands.address }"
									name="address" class="form-control" placeholder="Nhập địa chỉ">
							</div>
							<div class="form-group">
								<label for=area>Diện tích</label> <input type="text" value="${lands.area }"
									name="area" class="form-control" placeholder="Nhập diện tích">
							</div>
						</div>

						<div class="col-sm-6"></div>
					</div>

					<hr>

					<div class="row">
						<div class="col-sm-12">
							<input type="submit" value="Sửa" class="btn btn-success" /> <input
								type="reset" value="Nhập lại" class="btn btn-default" />
						</div>
					</div>

				</div>
			</form>
			
			
			
		</div>
	</div>
</div>
<!-- /.row col-size -->

