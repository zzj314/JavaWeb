<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<%@ include file="/pages/common/head.jsp"%>
	<Script type="text/javascript">
		$(function () {
			// 给加入购物车按钮绑定单击事件
			$("button.addToCart").click(function () {
				/**
				 * 在事件响应的function函数 中，有一个this对象，这个this对象，是当前正在响应事件的dom对象
				 * @type {jQuery}
				 */
				var bookId = $(this).attr("bookId");
				//客户端方案修改
				//location.href = "http://localhost:8080/book/cartServlet?action=addItem&id=" + bookId;
				$.getJSON("http://localhost:8080/book/cartServlet?action=ajaxAddItem&id=" + bookId,function (data) {
					//console.log(data);
					$("#cartTotalCount").text("您的购物车中有"+data.totalCount +"件商品");
					$("#cartLastName").text(data.lastName);
				})
			});
		});
	</Script>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<c:if test="${empty sessionScope.user}">
					<a href="pages/user/login.jsp">登录</a> |
					<a href="pages/user/regist.jsp">注册</a> &nbsp;
				</c:if>
				<c:if test="${not empty sessionScope.user}">
					<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
					<a href="pages/order/order.jsp">我的订单</a>
					<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
				</c:if>

				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/bookServlet" method="get">
					<input type="hidden" name="action" value="pageByPrice">
					价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
						<input id="max" type="text" name="max" value="${param.max}"> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<c:if test="${empty sessionScope.cart.items}">
					<span id="cartTotalCount"></span>
					<div>
						<span style="color: red" id="cartLastName">当前购物车为空</span>
					</div>
				</c:if>

				<c:if test="${not empty sessionScope.cart.items}">
					<span id="cartTotalCount">您的购物车中有3件商品</span>
					<div>
						您刚刚将<span style="color: red" id="cartLastName">${sessionScope.lastName}</span>加入到了购物车中
					</div>
				</c:if>

			</div>

			<c:forEach items="${requestScope.page.items}" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="static/img/default.jpg" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.name}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">￥${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock}</span>
						</div>
						<%--<div class="book_add">--%>
						<%--	<button>加入购物车</button>--%>
						<%--</div>--%>
						<div class="book_add">
							<button bookId="${book.id}" class="addToCart">加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>

			
			<%--<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/default.jpg" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">时间简史</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">霍金</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥30.00</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">230</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">1000</span>
					</div>
					<div class="book_add">
						<button>加入购物车</button>
					</div>
				</div>
			</div>--%>
			
			<%--<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/default.jpg" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">时间简史</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">霍金</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥30.00</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">230</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">1000</span>
					</div>
					<div class="book_add">
						<button>加入购物车</button>
					</div>
				</div>
			</div>--%>
		</div>
		<%--静态包含分页条--%>
		<%@include file="/pages/common/page_nav.jsp"%>

		<%--<div id="page_nav">
			<a href="#">首页</a>
			<a href="#">上一页</a>
			<a href="#">3</a>
			【4】
			<a href="#">5</a>
			<a href="#">下一页</a>
			<a href="#">末页</a>
			共10页，30条记录 到第<input value="4" name="pn" id="pn_input"/>页
			<input type="button" value="确定">--%>
<%--分页的开始
		<div id="page_nav">

			<c:if test="${requestScope.page.pageNo > 1}">
				<a href="${requestScope.page.url}&pageNo=1">首页</a>
				<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
			</c:if>

			页码开始

			<c:choose>
				总页码小于5
				<c:when test="${requestScope.page.pageTotal<=5}">
					<c:forEach begin="1" end ="${requestScope.page.pageTotal}" var="i">
						<c:if test="${i==requestScope.page.pageNo}">
							【${i}】
						</c:if>
						<c:if test="${i!=requestScope.page.pageNo}">
							<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
						</c:if>
					</c:forEach>
					<c:set var = "begin" value="1"></c:set>
					<c:set var = "end" value="${requestScope.page.pageTotal}"></c:set>
				</c:when>

				总页码大于5
				<c:when test="${requestScope.page.pageTotal >5}">
					<c:choose>
						当前页码小于等于中间值3的情况
						<c:when test="${requestScope.page.pageNo <= 3}">
							<c:forEach begin="1" end ="5" var="i">
								<c:if test="${i==requestScope.page.pageNo}">
									【${i}】
								</c:if>
								<c:if test="${i!=requestScope.page.pageNo}">
									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
							<c:set var = "begin" value="1"></c:set>
							<c:set var = "end" value="5"></c:set>
						</c:when>
						当前页码大于等于中间值8的情况
						<c:when test="${requestScope.page.pageNo >= requestScope.page.pageTotal-3}">
							<c:forEach begin="${requestScope.page.pageTotal-4}" end ="${requestScope.page.pageTotal}" var="i">
								<c:if test="${i==requestScope.page.pageNo}">
									【${i}】
								</c:if>
								<c:if test="${i!=requestScope.page.pageNo}">
									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
							<c:set var = "begin" value="${requestScope.page.pageTotal-4}"></c:set>
							<c:set var = "end" value="${requestScope.page.pageTotal}"></c:set>
						</c:when>
						当前页码是4,5,6
						<c:otherwise>
							<c:forEach begin="${requestScope.page.pageNo-2}" end ="${requestScope.page.pageNo+2}" var="i">
								<c:if test="${i==requestScope.page.pageNo}">
									【${i}】
								</c:if>
								<c:if test="${i!=requestScope.page.pageNo}">
									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
							<c:set var = "begin" value="${requestScope.page.pageNo-2}"></c:set>
							<c:set var = "end" value="${requestScope.page.pageNo+2}"></c:set>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>

			<c:forEach begin="${begin}" end ="${end}" var="i">
				<c:if test="${i==requestScope.page.pageNo}">
					【${i}】
				</c:if>
				<c:if test="${i!=requestScope.page.pageNo}">
					<a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
				</c:if>
			</c:forEach>

			页码结束

			<a href="#">3</a>
			【${requestScope.page.pageNo}】
			<a href="#">5</a>

			<c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
				<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
				<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
			</c:if>

			共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
						到第<input value="4" name="pn" id="pn_input"/>页
			到第<input value="${page.pageNo}" name="pn" id="pn_input"/>页
			<input id="searchPageBtn" type="button" value="确定">

			<script type="text/javascript">
				$(function () {
					$("#searchPageBtn").click(function () {
						var pageNo = $("#pn_input").val();

						var pageTotal = ${requestScope.page.pageTotal};
						// alert(pageTotal);
						//location地址栏对象，href可以获取浏览器地址
						// alert(location);
						//相当于跳转到指定地址了
						// location.href="http://localhost:8080/book/manager/bookServlet?action=page&pageNo="+pageNo;
						location.href="${pageScope.basePath}${requestScope.page.url}&pageNo="+pageNo;
					});
				})
			</script>

		</div>
		分页条的结束
		--%>

		</div>
	
	</div>
	
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>