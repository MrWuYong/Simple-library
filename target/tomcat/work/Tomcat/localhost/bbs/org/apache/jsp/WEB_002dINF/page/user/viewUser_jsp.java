/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-22 09:03:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class viewUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/page/public/header.jsp", Long.valueOf(1526966373700L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OtherUser.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("的资料</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<header class=\"head\">\r\n");
      out.write("    <div>\r\n");
      out.write("        <ul class=\"nav nav-pills\">\r\n");
      out.write("            <li class=\"active\"><a href=\"index\">首页</a></li>\r\n");
      out.write("            <c:choose>\r\n");
      out.write("                <c:when test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user!=null}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                    <li class=\"\">\r\n");
      out.write("                        <span>我的</span>\r\n");
      out.write("                            <ul class=\"nav nav-list\">\r\n");
      out.write("                                <li><a href=\"userInfo\">个人信息</a></li>\r\n");
      out.write("                                <li><a href=\"modify\">修改信息</a></li>\r\n");
      out.write("                                <li><a href=\"userPosts?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">过往发帖</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li><a href=\"logout\">退出</a></li>\r\n");
      out.write("                </c:when>\r\n");
      out.write("                <c:otherwise>\r\n");
      out.write("                    <li><a href=\"login\">登录</a></li>\r\n");
      out.write("                    <li><a href=\"register\">注册</a></li>\r\n");
      out.write("                </c:otherwise>\r\n");
      out.write("            </c:choose>\r\n");
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("    <p>用户姓名：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OtherUser.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("    <p>身份：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OtherUser.role.roleName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("    <p>性别：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OtherUser.sexModel.sex}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("    <p>帖子数：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OtherUser.posts.size()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("    <p>评论数：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OtherUser.replies.size()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
