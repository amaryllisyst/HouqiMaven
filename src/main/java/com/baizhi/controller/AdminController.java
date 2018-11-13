package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String queryAdmin(Admin admin1, String enCode, HttpServletRequest request){
        Admin admin=adminService.queryAdmin(admin1);
        HttpSession session=request.getSession();
        String code=(String) session.getAttribute("randomString");
        if(code.equals(enCode)) {
            if (admin != null) {
                session.setAttribute("admin",admin);
                return "redirect:/main/main.jsp";
            } else {
                return "redirect:/login.jsp";
            }
        }else{
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("/upd")
    @ResponseBody
    public void upd(Admin admin){
        System.out.println("========admin======="+admin);
        adminService.upd(admin);
    }

    @RequestMapping("/clear")
    public String clear(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("admin",null);
        return "redirect:/login.jsp";
    }
}
