<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>

<!-- Modal -->
<div class="modal fade bg-white" id="templatemo_search" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="w-100 pt-1 mb-5 text-right">
			<button type="button" class="btn-close" data-bs-dismiss="modal"
				aria-label="Close"></button>
		</div>
		<form action="" method="get"
			class="modal-content modal-body border-0 p-0">
			<div class="input-group mb-2">
				<input type="text" class="form-control" id="inputModalSearch"
					name="q" placeholder="Search ...">
				<button type="submit" class="input-group-text bg-success text-light">
					<i class="fa fa-fw fa-search text-white"></i>
				</button>
			</div>
		</form>
	</div>
</div>



<!-- Start Content -->
<div class="container py-5">
	<div class="row">
		<div class="col-lg-3">
			<h1 class="h2 pb-4">Categories</h1>
			<ul class="list-unstyled templatemo-accordion">
				<c:forEach items="${catList }" var="item">
					<li class="pb-3"><a
						class="collapsed d-flex justify-content-between h3 text-decoration-none"
						href="#"> ${item.cname} <i
							class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
					</a></li>
				</c:forEach>
			</ul>
		</div>

		<div class="col-lg-9">
			<div class="row">
				<c:forEach items="${productsList }" var="itemm">
			
				<div class="col-md-4" >
					<div class="card mb-4 product-wap rounded-0">
						<div class="card rounded-0">
							<img class="card-img rounded-0 img-fluid" 
								src="${pageContext.request.contextPath }/resources/files/${itemm.picture}">
							<div
								class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
								<ul class="list-unstyled">
									<li><a class="btn btn-success text-white"
										href="shop-single.html"><i class="far fa-heart"></i></a></li>
									<li><a class="btn btn-success text-white mt-2"
										href="${pageContext.request.contextPath}/detail/${itemm.pid}"><i class="far fa-eye"></i></a></li>
									<li><a class="btn btn-success text-white mt-2"
										href="shop-single.html"><i class="fas fa-cart-plus"></i></a></li>
								</ul>
							</div>
						</div>
						<div class="card-body">
							<a href="${pageContext.request.contextPath}/detail/${itemm.pid}" class="h3 text-decoration-none">${itemm.pname}</a>
							<ul
								class="w-100 list-unstyled d-flex justify-content-between mb-0">
								<li>M/L/X/XL</li>
								<li class="pt-2"><span
									class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
									<span
									class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
									<span
									class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
									<span
									class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
									<span
									class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
								</li>
							</ul>
							<ul class="list-unstyled d-flex justify-content-center mb-1">
								<li><i class="text-warning fa fa-star"></i> <i
									class="text-warning fa fa-star"></i> <i
									class="text-warning fa fa-star"></i> <i
									class="text-muted fa fa-star"></i> <i
									class="text-muted fa fa-star"></i></li>
							</ul>
							<p class="text-center mb-0">$${itemm.price}</p>
						</div>
					</div>
				</div>
				</c:forEach>
				
			</div>
			<c:if test="${totalPage > 1 and currentPage != ''}">
			<div div="row">
				<ul class="pagination pagination-lg justify-content-end">
					<c:forEach begin="1" end="${totalPage }" var="i">
					<li class="page-item"><a
						class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark"
						href="${pageContext.request.contextPath}/shop/${i}">${i }</a></li>
					</c:forEach>
				</ul>
			</div>
			</c:if>
		</div>

	</div>
</div>
<!-- End Content -->

<!-- Start Brands -->
<section class="bg-light py-5">
	<div class="container my-4">
		<div class="row text-center py-3">
			<div class="col-lg-6 m-auto">
				<h1 class="h1">Our Brands</h1>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod Lorem ipsum dolor sit amet.</p>
			</div>
			<div class="col-lg-9 m-auto tempaltemo-carousel">
				<div class="row d-flex flex-row">
					<!--Controls-->
					<div class="col-1 align-self-center">
						<a class="h1" href="#multi-item-example" role="button"
							data-bs-slide="prev"> <i
							class="text-light fas fa-chevron-left"></i>
						</a>
					</div>
					<!--End Controls-->

					<!--Carousel Wrapper-->
					<div class="col">
						<div class="carousel slide carousel-multi-item pt-2 pt-md-0"
							id="multi-item-example" data-bs-ride="carousel">
							<!--Slides-->
							<div class="carousel-inner product-links-wap" role="listbox">

								<!--First slide-->
								<div class="carousel-item active">
									<div class="row">
										<div class="col-3 p-md-5">
											<a href="#"><img class="img-fluid brand-img"
												src="${contextPath}/img/brand_01.png" alt="Brand Logo"></a>
										</div>
										<div class="col-3 p-md-5">
											<a href="#"><img class="img-fluid brand-img"
												src="${contextPath}/img/brand_02.png" alt="Brand Logo"></a>
										</div>
										<div class="col-3 p-md-5">
											<a href="#"><img class="img-fluid brand-img"
												src="${contextPath}/img/brand_03.png" alt="Brand Logo"></a>
										</div>
										<div class="col-3 p-md-5">
											<a href="#"><img class="img-fluid brand-img"
												src="${contextPath}/img/brand_04.png" alt="Brand Logo"></a>
										</div>
									</div>
								</div>
								<!--End First slide-->

								<!--Second slide-->
								<div class="carousel-item">
									<div class="row">
										<div class="col-3 p-md-5">
											<a href="#"><img class="img-fluid brand-img"
												src="${contextPath}/img/brand_01.png" alt="Brand Logo"></a>
										</div>
										<div class="col-3 p-md-5">
											<a href="#"><img class="img-fluid brand-img"
												src="${contextPath}/img/brand_02.png" alt="Brand Logo"></a>
										</div>
										<div class="col-3 p-md-5">
											<a href="#"><img class="img-fluid brand-img"
												src="${contextPath}/img/brand_03.png" alt="Brand Logo"></a>
										</div>
										<div class="col-3 p-md-5">
											<a href="#"><img class="img-fluid brand-img"
												src="${contextPath}/img/brand_04.png" alt="Brand Logo"></a>
										</div>
									</div>
								</div>
								<!--End Second slide-->

								<!--Third slide-->
								<div class="carousel-item">
									<div class="row">
										<div class="col-3 p-md-5">
											<a href="#"><img class="img-fluid brand-img"
												src="${contextPath}/img/brand_01.png" alt="Brand Logo"></a>
										</div>
										<div class="col-3 p-md-5">
											<a href="#"><img class="img-fluid brand-img"
												src="${contextPath}/img/brand_02.png" alt="Brand Logo"></a>
										</div>
										<div class="col-3 p-md-5">
											<a href="#"><img class="img-fluid brand-img"
												src="${contextPath}/img/brand_03.png" alt="Brand Logo"></a>
										</div>
										<div class="col-3 p-md-5">
											<a href="#"><img class="img-fluid brand-img"
												src="${contextPath}/img/brand_04.png" alt="Brand Logo"></a>
										</div>
									</div>
								</div>
								<!--End Third slide-->

							</div>
							<!--End Slides-->
						</div>
					</div>
					<!--End Carousel Wrapper-->

					<!--Controls-->
					<div class="col-1 align-self-center">
						<a class="h1" href="#multi-item-example" role="button"
							data-bs-slide="next"> <i
							class="text-light fas fa-chevron-right"></i>
						</a>
					</div>
					<!--End Controls-->
				</div>
			</div>
		</div>
	</div>
</section>
<!--End Brands-->
