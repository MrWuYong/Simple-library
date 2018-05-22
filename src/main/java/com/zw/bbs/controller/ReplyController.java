package com.zw.bbs.controller;

import com.zw.bbs.model.Reply;
import com.zw.bbs.model.User;
import com.zw.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @RequestMapping("/sendReply")
    public void sendReply(HttpServletResponse response, HttpServletRequest request, HttpSession session, Reply reply) throws Exception{
        Integer id = ((User)session.getAttribute("user")).getId();
        reply.setUserId(id);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (replyService.insert(reply) == 1){
//            writer.print("<script>alert('评论成功');window.location.href=posts?id="+reply.getId()+"</script>");
            writer.print("<script type='text/javascript'>alert('评论成功');document.location.href='"+request.getContextPath()+"/posts?id="+reply.getPostsId()+"';</script>");
//            writer.print(" alert('评论成功')");
//            writer.print("window.location.href=posts?id="+reply.getId());
//            writer.print("</script>");
        }else {
            writer.print(" <script>alert('评论失败！')</script>");
        }
        writer.flush();
        writer.close();
//        return "redirect:posts?id="+reply.getId();
    }
}
