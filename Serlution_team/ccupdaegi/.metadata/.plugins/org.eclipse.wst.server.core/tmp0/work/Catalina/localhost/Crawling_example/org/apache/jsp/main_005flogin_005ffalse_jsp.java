/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.57
 * Generated at: 2020-08-06 13:08:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_005flogin_005ffalse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width\", initial-scale=\"1\">\r\n");
      out.write("<title>테스트</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css\" integrity=\"sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX\" crossorigin=\"anonymous\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./css/cover.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"text-center\"> <!-- 가운데 정렬 -->\r\n");
      out.write("\r\n");
      out.write("<!-- 사이트 위 헤더 -->\r\n");
      out.write("<div class=\"cover-container d-flex w-100 h-100 p-3 mx-auto flex-column\">\r\n");
      out.write("  <header class=\"masthead mb-auto\">\r\n");
      out.write("    <div class=\"inner\">\r\n");
      out.write("      <h3 class=\"masthead-brand\">Searlution</h3>\r\n");
      out.write("      <nav class=\"nav nav-masthead justify-content-center\">\r\n");
      out.write("        <a class=\"nav-link active\" href=\"#\">Home</a>\r\n");
      out.write("        <a class=\"nav-link\" href=\"./main_login_true.jsp\">로그인</a>\r\n");
      out.write("        <a class=\"nav-link\" href=\"./main_login_true.jsp\">회원가입</a>\r\n");
      out.write("      </nav>\r\n");
      out.write("    </div>\r\n");
      out.write("  </header>\r\n");
      out.write("\r\n");
      out.write("<!-- 검색창, 로고 -->\r\n");
      out.write("  <main role=\"main\" class=\"inner cover\">\r\n");
      out.write("    <img class=\"img-fluid\" src=\"./png/main_logo_short.png\" alt=\"Responsive image\">\r\n");
      out.write("  \t<div class=\"input-group input-group-lg mb-3\">\r\n");
      out.write("      <input type=\"text\" class=\"form-control\" placeholder=\"검색어를 입력하세요.\" aria-label=\"검색어를 입력하세요.\">\r\n");
      out.write("      <div class=\"input-group-append\">\r\n");
      out.write("        <button class=\"btn btn-outline-secondary\" type=\"button\" id=\"search\">Search</button>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"form-check\">\r\n");
      out.write("\t  <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"advertisement\">\r\n");
      out.write("\t  <label class=\"form-check-label\" for=\"advertisement\">광고성 데이터 제거</label>\r\n");
      out.write("\t</div>\r\n");
      out.write("  </main>\r\n");
      out.write("\r\n");
      out.write("<!-- Copyright -->\r\n");
      out.write("  <footer class=\"mastfoot mt-auto\">\r\n");
      out.write("    <div class=\"inner\">\r\n");
      out.write("      <p>Copyright &copy; 2020 Searlution Team All Rights Reserved.</p>\r\n");
      out.write("    </div>\r\n");
      out.write("  </footer>\r\n");
      out.write("</div>\r\n");
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
