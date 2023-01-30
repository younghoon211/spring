package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 파라미터 받고
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        // 비지니스 로직 호출하고
        Member member = new Member(username, age);
        memberRepository.save(member);

        // Model에 데이터를 보관
        request.setAttribute("member", member);

        // view로 던짐
        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
