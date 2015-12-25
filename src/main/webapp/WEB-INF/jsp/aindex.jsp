<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="gb2312">
<title>博客主页</title>
<meta name="keywords" content="个人博客模板,博客模板,响应式" />
<meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。" />
<link href="<%=path %>/css/base.css" type="text/css" rel="stylesheet">
<link href="<%=path %>/css/index.css" type="text/css" rel="stylesheet">
<link href="<%=path %>/css/style.css" rel="stylesheet">
<link href="<%=path %>/css/media.css" type="text/css" rel="stylesheet">
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
</head>
<body>
	<div class="ibody">
		<header>
		<h1>Quentin</h1>
		<h2>影子是一个会撒谎的精灵，它在虚空中流浪和等待被发现之间;在存在与不存在之间....</h2>
		<div class="logo">
			<a href="/"></a>
		</div>
		<nav id="topnav"> <a href="index.html">首页</a> <a
			href="<%=path %>/admin/about">关于我</a> <a href="<%=path %>/admin/newlist">慢生活</a> <a
			href="<%=path %>/admin/share">模板分享</a> <a href="<%=path %>/admin/new">模板主题</a></nav> </header>
		<article>
		<div class="banner">
			<ul class="texts">
				<p>The best life is use of willing attitude, a happy-go-lucky
					life.</p>
				<p>最好的生活是用心甘情愿的态度，过随遇而安的生活。</p>
			</ul>
		</div>
		<div class="bloglist">
			<h2>
				<p>
					<span>推荐</span>文章
				</p>
			</h2>
			<c:forEach items="${blogs}" var="blog">
				<div class="blogs">
					<h3>
						<a href="/">${blog.blogName}</a>
					</h3>
					<figure> <img src="<%=path %>/images/${blog.blogPicture}"></figure>
					<ul>
						<p>${blog.blogContent}</p>
						<a href="<%=path %>/admin/readBlog?bid=${blog.blogId}" target="_blank" class="readmore">阅读全文&gt;&gt;</a>
					</ul>
					<p class="autor">
						<span>作者：${blog.blogAuthor}</span><span>分类：【<a href="/">${blog.blogCatagory}</a>】
						</span><span>浏览（<a href="/">459</a>）
						</span><span>评论（<a href="/">30</a>）
						</span>
					</p>
					<div class="dateview">${blog.blogTime}</div>
				</div>
			</c:forEach>
			</div>
			<div class="page">
				<c:if test="${page.hasFirst}">
				<a href="<%=path %>/admin/showBlog?currentPage=1">首</a>
				</c:if>
				<c:if test="${page.hasPrevious}">
				<a href="<%=path %>/admin/showBlog?currentPage=${page.currentPage-1}">上</a>
				</c:if>
				<c:if test="${page.hasNext}">
				<a href="<%=path %>/admin/showBlog?currentPage=${page.currentPage+1}">下</a>
				</c:if>
				<c:if test="${page.hasLast}">
				<a href="<%=path %>/admin/showBlog?currentPage=${page.totalPage}">末</a>
				</c:if>
			</div>
		</article>
		<aside>
		<div class="avatar">
			<a href="about.html"><span>关于杨青</span></a>
		</div>
		<div class="topspaceinfo">
			<h1>执子之手，与子偕老</h1>
			<p>于千万人之中，我遇见了我所遇见的人....</p>
		</div>
		<div class="about_c">
			<p>网名：DanceSmile | 即步非烟</p>
			<p>职业：Web前端设计师、网页设计</p>
			<p>籍贯：四川省—成都市</p>
			<p>电话：13662012345</p>
			<p>邮箱：dancesmiling@qq.com</p>
		</div>
		<div class="bdsharebuttonbox">
			<a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a
				href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a
				href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a
				href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a
				href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a
				href="#" class="bds_more" data-cmd="more"></a>
		</div>
		<div class="tj_news">
			<h2>
				<p class="tj_t1">最新文章</p>
			</h2>
			<ul>
				<li><a href="/">犯错了怎么办？</a></li>
				<li><a href="/">两只蜗牛艰难又浪漫的一吻</a></li>
				<li><a href="/">春暖花开-走走停停-发现美</a></li>
				<li><a href="/">琰智国际-Nativ for Life官方网站</a></li>
				<li><a href="/">个人博客模板（2014草根寻梦）</a></li>
				<li><a href="/">简单手工纸玫瑰</a></li>
				<li><a href="/">响应式个人博客模板（蓝色清新）</a></li>
				<li><a href="/">蓝色政府（卫生计划生育局）网站</a></li>
			</ul>
			<h2>
				<p class="tj_t2">推荐文章</p>
			</h2>
			<ul>
				<li><a href="/">犯错了怎么办？</a></li>
				<li><a href="/">两只蜗牛艰难又浪漫的一吻</a></li>
				<li><a href="/">春暖花开-走走停停-发现美</a></li>
				<li><a href="/">琰智国际-Nativ for Life官方网站</a></li>
				<li><a href="/">个人博客模板（2014草根寻梦）</a></li>
				<li><a href="/">简单手工纸玫瑰</a></li>
				<li><a href="/">响应式个人博客模板（蓝色清新）</a></li>
				<li><a href="/">蓝色政府（卫生计划生育局）网站</a></li>
			</ul>
		</div>
		<div class="links">
			<h2>
				<p>每天都来</p>
			</h2>
			<ul>
				<li><a href="<%=path %>/admin/add">撰写个人博客</a></li>
				<li><a href="/">纵览IT好文章</a></li>
				<li><a href="<%=path %>/user/logOut">注销</a>
			</ul>
		</div>
		<div class="copyright">
			<ul>
				<p>
					Design by <a href="/">DanceSmile</a>
				</p>
				<p>蜀ICP备11002373号-1</p>
				</p>
			</ul>
		</div>
		</aside>
		<script src="<%=path %>/js/silder.js"></script>
		<div class="clear"></div>
		<!-- 清除浮动 -->
	</div>
</body>
</html>
