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



<!-- Open Content -->
<c:choose>
	<c:when test="${not empty products }">

		<section class="bg-light">
			<div class="container pb-5">
				<div class="row">
					<div class="col-lg-5 mt-5">
						<div class="card mb-3">
							<img class="card-img img-fluid"
								src="${pageContext.request.contextPath }/resources/files/${products.picture}"
								alt="Card image cap" id="product-detail">
						</div>
						<div class="row"></div>
					</div>
					<!-- col end -->
					<div class="col-lg-7 mt-5">
						<div class="card">
							<div class="card-body">
								<h1 class="h2">${products.pname}</h1>
								<p class="h3 py-2">$ ${products.price}</p>
								<p class="py-2">
									<i class="fa fa-star text-warning"></i> <i
										class="fa fa-star text-warning"></i> <i
										class="fa fa-star text-warning"></i> <i
										class="fa fa-star text-warning"></i> <i
										class="fa fa-star text-secondary"></i> <span
										class="list-inline-item text-dark">Rating 4.8 |
										${products.count_views} Views</span>
								</p>
								<ul class="list-inline">
									<li class="list-inline-item">
										<h6>Brand:</h6>
									</li>
									<li class="list-inline-item">
										<p class="text-muted">
											<strong>Easy Wear</strong>
										</p>
									</li>
								</ul>

								<h6>Description:</h6>
								<p>${products.detail }</p>
								<ul class="list-inline">
									<li class="list-inline-item">
										<h6>Avaliable Color :</h6>
									</li>
									<li class="list-inline-item">
										<p class="text-muted">
											<strong>White / Black</strong>
										</p>
									</li>
								</ul>

								<form action="" method="GET">
									<input type="hidden" name="product-title" value="Activewear">
									<div class="row">
										<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item">Size : <input
													type="hidden" name="product-size" id="product-size"
													value="S">
												</li>
												<li class="list-inline-item"><span
													class="btn btn-success btn-size">S</span></li>
												<li class="list-inline-item"><span
													class="btn btn-success btn-size">M</span></li>
												<li class="list-inline-item"><span
													class="btn btn-success btn-size">L</span></li>
												<li class="list-inline-item"><span
													class="btn btn-success btn-size">XL</span></li>
											</ul>
										</div>
										<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item text-right">Quantity <input
													type="hidden" name="product-quanity" id="product-quanity"
													value="1">
												</li>
												<li class="list-inline-item"><span
													class="btn btn-success" id="btn-minus">-</span></li>
												<li class="list-inline-item"><span
													class="badge bg-secondary" id="var-value">1</span></li>
												<li class="list-inline-item"><span
													class="btn btn-success" id="btn-plus">+</span></li>
											</ul>
										</div>
									</div>
									<div class="row pb-3">
										<div class="col d-grid">
											<button type="submit" class="btn btn-success btn-lg"
												name="submit" value="buy">Buy</button>
										</div>
										<div class="col d-grid">
											<button type="submit" class="btn btn-success btn-lg"
												name="submit" value="addtocard">Add To Cart</button>
										</div>
									</div>
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</c:when>
</c:choose>
<!-- Close Content -->

<!-- Start Article -->
<section class="py-5">
	<div class="container">
		<div class="row text-left p-2 pb-3">
			<h4>Sản phẩm bán chạy nhiều nhất</h4>
		</div>

		<!--Start Carousel Wrapper-->

		<c:forEach items="${productsList }" var="item">
			<div id="carousel-related-product">

				<div class="p-2 pb-3">
					<div class="product-wap card rounded-0">
						<div class="card rounded-0">
							<img class="card-img rounded-0 img-fluid"
								src="${pageContext.request.contextPath }/resources/files/${item.picture}">
							<div
								class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
								<ul class="list-unstyled">
									<li><a class="btn btn-success text-white"
										href="shop-single.html"><i class="far fa-heart"></i></a></li>
									<li><a class="btn btn-success text-white mt-2"
										href="${pageContext.request.contextPath}/detail/${item.pid}"><i class="far fa-eye"></i></a></li>
									<li><a class="btn btn-success text-white mt-2"
										href="shop-single.html"><i class="fas fa-cart-plus"></i></a></li>
								</ul>
							</div>
						</div>
						<div class="card-body">
							<a href="shop-single.html" class="h3 text-decoration-none">${item.pname}</a>
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
									class="text-warning fa fa-star"></i> <i
									class="text-muted fa fa-star"></i></li>
							</ul>
							<p class="text-center mb-0">$${item.price }</p>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</section>
<!-- End Article -->

<!-- Start Slider Script -->
<script src="${contextPath}/js/slick.min.js"></script>
<script>
	$('#carousel-related-product').slick({
		infinite : true,
		arrows : false,
		slidesToShow : 4,
		slidesToScroll : 3,
		dots : true,
		responsive : [ {
			breakpoint : 1024,
			settings : {
				slidesToShow : 3,
				slidesToScroll : 3
			}
		}, {
			breakpoint : 600,
			settings : {
				slidesToShow : 2,
				slidesToScroll : 3
			}
		}, {
			breakpoint : 480,
			settings : {
				slidesToShow : 2,
				slidesToScroll : 3
			}
		} ]
	});
</script>
<!-- End Slider Script -->

</body>

</html>