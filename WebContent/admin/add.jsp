<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String ctx = request.getContextPath();
			pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet" href="${ctx }/admin/css/style.css"
	type="text/css" />
<link rel="stylesheet" href="${ctx }/admin/css/amazeui.min.css" />
</head>
<body>

	<div class="main_top">
		<div class="am-cf am-padding am-padding-bottom-0">
			<div class="am-fl am-cf">
				<strong class="am-text-primary am-text-lg">添加商品</strong><small></small>
			</div>
		</div>
		<hr>

		<div class="edit_content">
			<form action="${ctx }/GoodsServlet?action=addGoods" method="post"
				id="add_form" style="background: none; width: 700px;">
				<div class="item1">
					<div>
						<span>商品名称：</span> <input type="text" class="am-form-field"
							name="name">&nbsp;&nbsp;
					</div>
					<div>
						<span>商品价格：</span> <input type="text" class="am-form-field"
							name="price">
					</div>

				</div>

				<div class="item1">
					<div>
						<span>所属分类：</span> <select id="category_select" name="cid">
							<c:forEach items="${allCategories }" var="category">
								<option value="${category.cid }">${category.cname }</option>
							</c:forEach>
						</select> &nbsp;
					</div>

					<div>
						<span>是否热门：</span> <select id="category_select" name="is_hot">
							<option value="0">否</option>
							<option value="1">是</option>
						</select>
					</div>

				</div>

				<div class="item1">
					<span>商品图片：</span> <input type="file" name="image" />
				</div>

				<div class="item1 item_desc">
					<span>商品描述：</span>
					<textarea id="desc" name="gdesc" rows="4" cols="50"></textarea>
				</div>
				<button class="am-btn am-btn-default" type="button" id="add">添加</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="am-btn am-btn-default" type="button" id="reset">重置</button>
			</form>
		</div>

	</div>

	<script src="${ctx }/admin/js/jquery.min.js"></script>

	<script>
		$("#add").click(function() {
			//让表单提交 GoodsAddServlet
			//获取表单  让其提交
			$("#add_form").submit();
		});
	</script>
</body>
</html>