package com.blog.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.domain.User;
import com.blog.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.selectByPrimaryKey(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	@RequestMapping("/login")
	public String checkUser(HttpServletRequest request, Model model,
			HttpSession session, HttpServletResponse response) {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		User suser = userService.checkUser(user);

		if (suser != null) {
			if ("admin".equals(suser.getRole())) {
				model.addAttribute("user", suser);
				session.setAttribute("user", suser);

				return "redirect:/admin/index";
			} else {
				return "";
			}
		} else {
			return "login";
		}
	}

	@RequestMapping("/logOut")
	public String logOUt(HttpServletRequest request, Model model,
			HttpSession session) {
		System.out.println(session.getAttribute("user"));
		session.removeAttribute("user");
		return "login";

	}

	@RequestMapping("/ulogin")
	public String login() {
		return "login";
	}
}
