package com.zw.bbs.controller;

import com.zw.bbs.model.User;
import com.zw.bbs.service.SexService;
import com.zw.bbs.service.UserRoleService;
import com.zw.bbs.service.UserService;
import com.zw.bbs.util.validator.Add;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
@Controller
public class UserController  {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private SexService sexService;
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(Model model,@Validated(Add.class) User user){
        Map<String,Object> typeMap=userService.register(user);
        model.addAttribute(typeMap);
        return "register";
    }
    @RequestMapping("/userInfo")
    public String userInfo(Model model , HttpSession session,User user){
        user =(User)session.getAttribute("user");
        user = userService.findById(user.getId());
        model.addAttribute(user);
        session.setAttribute("user",user);
        return "userInfo";
    }
    @RequestMapping("/viewUser")
    public String viewUser(Model model,@RequestParam("userName")String userName){
        User user = userService.findByUserName(userName);
        model.addAttribute("OtherUser",user);
        return "user/viewUser";
    }
    @RequestMapping(value = "/modify",method = RequestMethod.GET)
    public String modify(Model model,HttpSession session){
        model.addAttribute("user",session.getAttribute("user"));
        model.addAttribute("roles",userRoleService.findAll());
        model.addAttribute("sexes",sexService.findAll());
        return "modify";
    }
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public String modify(HttpSession session, User user, Model model, @RequestParam("oldPassword")String oldPwd){
        if(oldPwd==null){
            return "modify";
        }
        User newUser = (User)session.getAttribute("user");
        Map map = userService.update(newUser,user);
        session.setAttribute("user",newUser);
        model.addAttribute("typeMap",map);
        return "redirect:userInfo";
    }
    @RequestMapping("checkPwd")
    @ResponseBody
    public Integer checkPwd(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        String password2 = userService.findForPassword(id);
        Integer checkType;
        if (password.equals(password2)){
            checkType = 1;
        }else{
            checkType = 0;
        }
        return checkType;
    }
}
