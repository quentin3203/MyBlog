package com.blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.domain.Blog;
import com.blog.service.IBlogService;
import com.blog.util.Pager;
import com.blog.util.Weather;

@Controller
@RequestMapping("/blog")
public class BlogController {
	@Resource
	private IBlogService blogService;

	@RequestMapping("/index")
	public String Index(HttpServletRequest request, Model model) {
		String httpUrl="http://apis.baidu.com/apistore/weatherservice/weather";
		String httpArg="citypinyin=hangzhou";
		int currentPage = 1;
		int totalSize = blogService.getTotal();
		Pager page = new Pager(currentPage, totalSize);
		List<Blog> blogs = blogService.selectBlog(currentPage,
				page.getPageSize());
		Weather weather=new Weather();
		String weatherResult=weather.request(httpUrl, httpArg);
		System.out.println(weatherResult);
		model.addAttribute("weather", weatherResult);
		model.addAttribute("blogs", blogs);
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping("/showBlog")
	public String toIndex(HttpServletRequest request, Model model,
			@RequestParam Integer currentPage) {
		int totalSize = blogService.getTotal();
		Pager page = new Pager(currentPage, totalSize);
		List<Blog> blogs = blogService.selectBlog(currentPage,
				page.getPageSize());
		model.addAttribute("blogs", blogs);
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping("/readBlog")
	public String readBlog(HttpServletRequest request, Model model) {
		int blogId = Integer.parseInt(request.getParameter("blogid"));
		Blog blog = blogService.selectBlogById(blogId);
		model.addAttribute("blog", blog);
		return "read";
	}

	@RequestMapping("/about")
	public String toAbout(HttpServletRequest request) {
		return "about";
	}

	@RequestMapping("/newlist")
	public String toNewList(HttpServletRequest request, Model model) {
		return "newlist";
	}

	@RequestMapping("/share")
	public String toShare(HttpServletRequest request, Model model) {
		return "share";
	}

	@RequestMapping("/new")
	public String toNew(HttpServletRequest request, Model model) {
		return "new";
	}
}
