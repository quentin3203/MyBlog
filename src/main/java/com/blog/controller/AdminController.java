package com.blog.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.blog.domain.Blog;
import com.blog.service.IBlogService;
import com.blog.util.Pager;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private IBlogService blogService;

	@RequestMapping("/index")
	public String Aindex(HttpServletRequest request, Model model) {
		int currentPage = 1;
		int totalSize = blogService.getTotal();
		Pager page = new Pager(currentPage, totalSize);
		List<Blog> blogs = blogService.selectBlog(currentPage,
				page.getPageSize());
		model.addAttribute("blogs", blogs);
		model.addAttribute("page", page);
		return "aindex";
	}

	@RequestMapping("/showBlog")
	public String toAindex(HttpServletRequest request, Model model,
			@RequestParam Integer currentPage) {

		int totalSize = blogService.getTotal();
		Pager page = new Pager(currentPage, totalSize);
		List<Blog> blogs = blogService.selectBlog(currentPage,
				page.getPageSize());
		model.addAttribute("blogs", blogs);
		model.addAttribute("page", page);
		return "aindex";
	}

	@RequestMapping("/addBlog")
	public String addBlog(HttpServletRequest request, Model model,
			MultipartFile file) throws Exception {
		String name = request.getParameter("name");
		String picture = file.getOriginalFilename();
		String content = request.getParameter("content");
		String catagory = request.getParameter("catagory");
		String author = request.getParameter("author");
		Date time = new Date(System.currentTimeMillis());
		Blog blog = new Blog();
		blog.setBlogName(name);
		blog.setBlogPicture(picture);
		blog.setBlogContent(content);
		blog.setBlogCatagory(catagory);
		blog.setBlogTime(time);
		blog.setBlogAuthor(author);
		blogService.addBlog(blog);
		file.transferTo(new File("c:\\Users\\Quentin\\Workspaces\\myblog Maven Webapp\\src\\main\\webapp\\images\\" + file.getOriginalFilename()));
		return "redirect:/admin/index";
	}

	@RequestMapping("/readBlog")
	public String selectBlog(HttpServletRequest request, Model model) {
		int blogId = Integer.parseInt(request.getParameter("bid"));
		Blog blog = blogService.selectBlogById(blogId);
		String sblog = blog.getBlogContent();
		String[] strs = sblog.split(" ");
		for (String b : strs) {
			blog.setBlogAuthor(b);
		}
		model.addAttribute("blog", blog);
		return "aread";
	}

	@RequestMapping("/add")
	public String add() {
		return "addBlog";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/deleteBlog")
	public String deleteBlog(HttpServletRequest request, Model model) {
		int blogId = Integer.parseInt(request.getParameter("blogid"));
		blogService.deleteBlog(blogId);
		return "redirect:/admin/showBlog";
	}

	@RequestMapping("/updateBlog")
	public String updateBlog(HttpServletRequest request, Model model) {
		int blogId = Integer.parseInt(request.getParameter("blogid"));
		Blog blog = blogService.selectBlogById(blogId);
		model.addAttribute("blog", blog);
		return "updateBlog";

	}

	@RequestMapping("doUpdateBlog")
	public String doUpdateBlog(HttpServletRequest request, Model model) {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String picture = request.getParameter("picture");
		String content = request.getParameter("content");
		String catagory = request.getParameter("catagory");
		String author = request.getParameter("author");
		Date time = new Date(System.currentTimeMillis());
		Blog blog = new Blog();
		blog.setBlogId(id);
		blog.setBlogName(name);
		blog.setBlogPicture(picture);
		blog.setBlogContent(content);
		blog.setBlogCatagory(catagory);
		blog.setBlogTime(time);
		blog.setBlogAuthor(author);
		blogService.updateBlog(blog);
		return "redirect:/admin/showBlog";
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
