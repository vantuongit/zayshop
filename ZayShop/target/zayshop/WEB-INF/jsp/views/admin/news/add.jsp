
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
								<label for="lname">Thêm tin</label> <input type="text"
									name="lname" class="form-control" placeholder="Nhập tên tin"
									value = '<c:if test="${not empty lands.lname }">${lands.lname }</c:if>'>
									<form:errors path="lands.lname" cssStyle="color:red" cssClass="error"></form:errors>
							</div>

							<div class="form-group">
								<label>Danh mục tin</label>
								 <select name="category.cid" class="form-control">
									<c:choose>
										<c:when test="${not empty cat }">
											<c:forEach items="${cat}" var="item">
												<option value="${item.cid}">${item.cname }</option>
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
							</div>

							<div class="form-group">
								<label>Mô tả</label>
								<textarea class="form-control" rows="3" name = "description"><c:if test="${not empty lands.description }">${lands.description }</c:if></textarea>
								<form:errors path="lands.description" cssStyle="color:red" cssClass="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="address">Địa chỉ</label> <input type="text"
									name="address" class="form-control" placeholder="Nhập địa chỉ"
									value="<c:if test="${not empty lands.address }">${lands.address }</c:if>">
									<form:errors path="lands.address" cssStyle="color:red" cssClass="error"></form:errors>
							</div>
							<div class="form-group">
								<label for=area>Diện tích</label> <input type="text"
									name="area" class="form-control" placeholder="Nhập diện tích"
									value = "<c:if test="${not empty lands.area }">${lands.area}</c:if>">
							</div>
						</div>

						<div class="col-sm-6"></div>

						
						
					</div>

					<hr>

					<div class="row">
						<div class="col-sm-12">
							<input type="submit" value="Thêm" class="btn btn-success" /> <input
								type="reset" value="Nhập lại" class="btn btn-default" />
						</div>
					</div>

				</div>
			</form>
		</div>
	</div>
</div>
<!-- /.row col-size -->

