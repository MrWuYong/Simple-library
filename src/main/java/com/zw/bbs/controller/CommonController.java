package com.zw.bbs.controller;

import com.github.pagehelper.PageInfo;
import com.zw.bbs.model.Posts;
import com.zw.bbs.model.Topic;
import com.zw.bbs.model.User;
import com.zw.bbs.service.PostsService;
import com.zw.bbs.service.TopicService;
import com.zw.bbs.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {
    @Autowired
    private TopicService topicService;
    @Autowired
    private UserService userService;
    @Autowired
    private PostsService postsService;
    private static final Integer PAGE_NUM=1;
    private static final Integer  PAGE_SIZE=5;
    @RequestMapping({"/","/index","/home"})
    public String index(Model model, Topic topic, @RequestParam(value = "id",required = false)Integer id, PageInfo<Posts> pageInfo){
        if (pageInfo.getPageNum()==0){
            pageInfo.setPageNum(PAGE_NUM);
        }
        if (pageInfo.getPageSize()==0){
            pageInfo.setPageSize(PAGE_SIZE);
        }
        topic.setId(id);
        pageInfo = postsService.findAsPage(pageInfo,topic);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("list",topicService.findAll());
        return "index";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Model model,User user){
        userService.login(user);
        return "redirect:index";
    }
    @RequestMapping("/logout")
    public String logout(){
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return "redirect:index";
    }
}
