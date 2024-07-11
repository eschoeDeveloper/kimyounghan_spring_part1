package org.hello.servlet.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.servlet.domain.Member;
import org.hello.servlet.domain.MemberRepository;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        int age = Integer.parseInt( req.getParameter("age") );

        Member member = new Member(username, age);
        memberRepository.save(member);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("   <meta charset=\"UTF-8\">\n");
        w.write("   <title>Title</title>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        w.write("<ul>\n");
        w.write("   <li>id: " + member.getId() + "</li>\n");
        w.write("   <li>username: " + member.getUsername() + "</li>\n");
        w.write("   <li>age: " + member.getAge() + "</li>\n");
        w.write("</ul>\n");
        w.write("<a href=\"/index.html\">메인</a>\n");
        w.write("</body>\n");
        w.write("</html>\n");

    }

}
