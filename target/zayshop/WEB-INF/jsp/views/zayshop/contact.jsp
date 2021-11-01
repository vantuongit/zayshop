<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script	type="text/javascript" src="/WEB-INF/resources/cland/js/jquery-3.5.1.min.js"></script>
<script	type="text/javascript" src="/WEB-INF/resources/cland/js/jquery.validate.min.js"></script>



<div class="clearfix content">
	<c:if test="${not empty msg }">
		<div style="color: green; margin-left: 30%; font-weight: bold;" class="alert alert-success" role="alert">${msg }</div>
		<br /><br /><br />
	</c:if>
	<c:if test="${not empty err}">
		<div class="alert alert-warning" role="alert">${err}</div>
		<br /><br /><br />
	</c:if>

	<div class="contact_us">

		<h1>Liên hệ với chúng tôi</h1>

		<p>
			TRUNG TÂM ĐÀO TẠO LẬP TRÌNH VINAENTER EDU<br /> Trụ sở: 154 Phạm Như
			Xương, Liên Chiểu, Đà Nẵng<br /> Web: <a
				href="http://vinaenter.edu.vn" title="">www.vinaenter.edu.vn</a>
		</p>


		<form action="${pageContext.request.contextPath }/contact"
			method="post"  class="contact_form">
			<p>
				<input name="ct_fullname" type="text" class="wpcf7-text"
					placeholder="Họ tên *" value = '<c:if test="${not empty contact.ct_fullname }">${contact.ct_fullname }</c:if>' />
					<form:errors path="contact.ct_fullname" cssStyle="color:red" cssClass="error" />
			</p>
			<p>
				<input name="ct_email" type="text" class="wpcf7-email"
					placeholder="Email *" value = '<c:if test="${not empty contact.ct_email }">${contact.ct_email }</c:if>' />
					<form:errors path="contact.ct_email" cssStyle="color:red" cssClass="error" />	
			</p>
			<p>
				<input name="ct_subject" type="text" class="wpcf7-text"
					placeholder="Chủ đề *"  value = '<c:if test="${not empty contact.ct_subject }">${contact.ct_subject }</c:if>'/>
					<form:errors path="contact.ct_subject" cssStyle="color:red" cssClass="error" />	
			</p>
			<p>
				<textarea name="ct_content" class="wpcf7-textarea"
					placeholder="Nội dung *"><c:if test="${not empty contact.ct_content }">${contact.ct_content }</c:if></textarea>
					<form:errors path="contact.ct_content" cssStyle="color:red" cssClass="error" />	
						
			</p>
			<p>
				<input type="submit" class="wpcf7-submit" value="Gửi liên hệ" />
			</p>
		</form>

	</div>
	 <script type="text/javascript" class="vali" >
	$(document).ready(function () {
		$('#contact_form').validate({
			rules: {
				"ct_fullname": {
					required: true,
					minlength : 5,
					maxlength : 25,
				},
				"ct_email": {
					required: true,
					email: "true",
				},
				"ct_subject": {
					required: true,
				},
				"ct_content": {
					required: true,
				},
			},
			messages: {
			  "ct_fullname": {
				required : "Vui lòng nhập Tên",
				minlength : "Nhập tối thiểu 5 kí tự",
				maxlength : "nhập tối đa 25 kí tự",
			  },
			  "ct_email": {
				required: "vui lòng nhập email",
				email: "Vui lòng nhập đúng định dạng",
			  },
			  "ct_subject": {
				required: "Vui lòng nhập chủ đề",
			  },
			  "ct_content": {
					required: "Vui lòng nhập ý kiến",
				  },
			},
		});
	});	
</script>

</div>

