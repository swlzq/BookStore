/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M21
 * Generated at: 2017-06-17 17:48:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Home_005fpage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Navigation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>浪翼的小书屋</title>\r\n");
      out.write("<style>\r\n");
      out.write("body, div, ul, li {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tfont-style: normal;\r\n");
      out.write("\tfont: 12px/22px \"\\5B8B\\4F53\", Arial, Helvetica, sans-serif\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ol, ul, li {\r\n");
      out.write("\tlist-style: none\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("img {\r\n");
      out.write("\tborder: 0;\r\n");
      out.write("\tvertical-align: middle\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("\tcolor: #000000;\r\n");
      out.write("\tbackground: #FFF;\r\n");
      out.write("\ttext-align: center\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".clear {\r\n");
      out.write("\tclear: both;\r\n");
      out.write("\theight: 1px;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tmargin-top: -1px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a {\r\n");
      out.write("\tcolor: #000000;\r\n");
      out.write("\ttext-decoration: none\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:hover {\r\n");
      out.write("\tcolor: #BA2636\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".red, .red a {\r\n");
      out.write("\tcolor: #F00\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".lan, .lan a {\r\n");
      out.write("\tcolor: #1E51A2\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".pd5 {\r\n");
      out.write("\tpadding-top: 5px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dis {\r\n");
      out.write("\tdisplay: block\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".undis {\r\n");
      out.write("\tdisplay: none\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul#nav {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight:120px;\r\n");
      out.write("\tbackground-image:url(../image/mmm.jpg);\r\n");
      out.write("\tbackground-size:100%;\r\n");
      out.write("\tbackground-repeat:no-repeat;\r\n");
      out.write("\tmargin: 0 auto\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul#nav li {\r\n");
      out.write("\tdisplay: inline;\r\n");
      out.write("\theight: 120px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul#nav li a {\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tpadding: 0 20px;\r\n");
      out.write("\theight: 120px;\r\n");
      out.write("\tline-height: 120px;\r\n");
      out.write("\tcolor: #FFF;\r\n");
      out.write("\tfont-family: \"\\5FAE\\8F6F\\96C5\\9ED1\";\r\n");
      out.write("\tfont-size: 16px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul#nav li a:hover {\r\n");
      out.write("\tbackground: #e8a171\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<ul id=\"nav\">\r\n");
      out.write("\t\t<li><a href=\"Home_iframe.jsp\" target=\"_top\">首页</a></li>\r\n");
      out.write("\t\t<li><a href=\"../Shopping_cart/Shopping_frame.jsp\" target=\"_top\">我的购物车</a></li>\r\n");
      out.write("\t\t<li><a href=\"../My_order/MyOrder_frame.jsp\" target=\"_top\">我的订单</a></li>\r\n");
      out.write("\t\t<li><a href=\"Alert.jsp\" target=\"_top\">个人中心</a></li>\r\n");
      out.write("\t\t<li><a href=\"../Manager_page/Manager_login.jsp\" target=\"_top\">书屋管理</a></li>\r\n");
      out.write("\t\t<li><a href=\"../Message_board/Message_frameset.jsp\" target=\"_top\">给浪翼留言</a></li>\r\n");
      out.write("\t\t<li><a href=\"../Login/off_login.jsp\" target=\"_top\">退出登录</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
