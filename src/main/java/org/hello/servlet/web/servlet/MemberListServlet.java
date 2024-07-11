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
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Member> list = memberRepository.findAll();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter w = resp.getWriter();
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("   <meta charset=\"UTF-8\">\n");
        w.write("   <title>Title</title>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        w.write("<a href=\"/index.html\">메인</a>\n");
        w.write("<table>\n");
        w.write("   <thead>\n");
        w.write("       <tr>\n");
        w.write("           <td>ID</td>\n");
        w.write("           <td>이름</td>\n");
        w.write("           <td>나이</td>\n");
        w.write("       </tr>\n");
        w.write("   </thead>\n");
        w.write("   <tbody>\n");

        for(Member member : list) {
            w.write("       <tr>\n");
            w.write("           <td>" + member.getId() + "</td>\n");
            w.write("           <td>" + member.getUsername() + "</td>\n");
            w.write("           <td>" + member.getAge() + "</td>\n");
            w.write("       </tr>\n");
        }

        w.write("   </tbody>\n");
        w.write("</table>\n");
        w.write("</body>\n");
        w.write("</html>\n");


    }
}
