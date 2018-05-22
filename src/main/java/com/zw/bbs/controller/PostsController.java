package com.zw.bbs.controller;

import com.github.pagehelper.PageInfo;
import com.zw.bbs.model.Content;
import com.zw.bbs.model.Posts;
import com.zw.bbs.model.Topic;
import com.zw.bbs.model.User;
import com.zw.bbs.service.ContentService;
import com.zw.bbs.service.PostsService;
import com.zw.bbs.service.ReplyService;
import com.zw.bbs.service.TopicService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PostsController {
    @Autowired
    private PostsService postsService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private ContentService contentService;
    @Autowired
    private ReplyService replyService;

    /**
     * 跳转发帖页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/posted",method = RequestMethod.GET)
    public String posted(Model model){
        List<Topic> topics = topicService.findAll();
        model.addAttribute("topics",topics);
        return "/posts/posted";
    }

    /**
     * 发帖到数据库
     * @param session 获取user
     * @param model
     * @param content 内容
     * @param postTopic 所选标题
     * @return 把发送结果发送到页面
     */
    @RequestMapping(value = "/posted",method = RequestMethod.POST)
    public String posted(HttpSession session, Model model, Content content, @RequestParam("postTopic")Integer postTopic){
        Posts posts=new Posts();
        content.setId(contentService.insert(content));
        User user =(User)session.getAttribute("user");

        posts.setPostTopic(postTopic);
        posts.setContentId(content.getId());
        posts.setUserId(user.getId());

        Map map = postsService.insert(posts);
        model.addAttribute("id",posts.getId());
        model.addAttribute("resultMap",map);
        return "/posts/posted";
    }

   /* *//**
     * 获取主题下的帖子
     * @param topic
     * @param id
     * @param pageInfo
     * @return
     *//*
    @RequestMapping("/postList/{id}")
    @ResponseBody
    public  Map<String,Object>postList(Topic topic, @PathVariable("id")Integer id,PageInfo<Posts> pageInfo){
        if (pageInfo.getPageNum()==0){
            pageInfo.setPageNum(PAGE_NUM);
        }
        if (pageInfo.getPageSize()==0){
            pageInfo.setPageSize(PAGE_SIZE);
        }
        topic.setId(id);
        Map<String,Object> map = new HashMap();
        pageInfo = postsService.findAsPage(pageInfo,topic);
        map.put("list",pageInfo.getList());
        map.put("pageNum",pageInfo.getPageNum());
        map.put("pageCount",pageInfo.getPages());
        String a= map.toString();
        System.out.println("mapxinxi:"+a);
        return map;
    }*/

    /**
     *跳转帖子详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/posts")
//    @RequestMapping("posts/{id}")
//    @PathVariable("id")
    public String posts(@RequestParam("id")Integer id, Model model){
        Posts posts = postsService.findById(id);
        posts.setReplies(replyService.findAllByPostId(id));
        model.addAttribute("posts",posts);
        return "/posts/posts";
    }

    /**
     * 查看用户的帖子
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/userPosts")
    public String userPostList(HttpSession session,Model model,@RequestParam("userId")Integer userId){
        List<Posts> postsList =postsService.findByUserId(userId);
        model.addAttribute("postsList",postsList);
        return "/posts/userPosts";
    }

    /**
     * 删除帖子
     * @param postsId
     * @param contentId
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping("/deletePosts/{id}/{contentId}")
    public void deletePosts(@PathVariable("id")Integer postsId, @PathVariable("contentId")Integer contentId, HttpServletResponse response, HttpServletRequest request) throws Exception{
        int deleteReply = replyService.deleteByPostsId(postsId);
        int deletePostsNum = postsService.removeById(postsId);
        int deleteContentNum=contentService.delete(contentId);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (deletePostsNum == 1 && deleteContentNum==1 && deleteReply !=-1){
//            writer.print("<script>alert('评论成功');window.location.href=posts?id="+reply.getId()+"</script>");
            writer.print("<script type='text/javascript'>alert('已删除');document.location.href='"+request.getContextPath()+"/userPosts?userId="+((User) request.getSession().getAttribute("user")).getId()+"';</script>");
//            writer.print(" alert('评论成功')");
//            writer.print("window.location.href=posts?id="+reply.getId());
//            writer.print("</script>");
        }else {
            writer.print(" <script>alert('删除失败！')</script>");
        }
        writer.flush();
        writer.close();
    }
}
