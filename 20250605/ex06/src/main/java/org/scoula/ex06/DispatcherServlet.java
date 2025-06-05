package org.scoula.ex06;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.scoula.ex06.command.Command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class DispatcherServlet extends HttpServlet {

    // URL과 Command 매핑을 저장하는 Map
    Map<String, Command> getMap;
    Map<String, Command> postMap;

    // View Resolver 설정
    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";


    // 서블릿 객체 생성 시 실행되는 init() 메서드
    @Override
    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();

        // 템플릿 메서드 패턴
        createMap(getMap, postMap);
    }

    // 자식 클래스에서 오버라이드
    protected abstract void createMap(Map<String, Command> getMap, Map<String, Command> postMap);


    /* URL 식별 값 추출 메서드 */
    private String getCommandName(HttpServletRequest req) {
        String requestURI = req.getRequestURI(); // 전체 URI 반환
        String contextPath = req.getContextPath(); // context 경로 반환
        return requestURI.substring(contextPath.length());
    }

    /* 커맨드 가져오기 */
    private Command getCommand(HttpServletRequest req) {

        String commandName = getCommandName(req); // /todo/update
        Command command;

        if(req.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
        } else {
            command = postMap.get(commandName);
        }
        return command;
    }


    /* 커맨드 실행 및 뷰 연결 처리 */
    public void execute(Command command, HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        // Command를 실행하여 View 이름 얻어오기
        String viewName = command.execute(req, resp); // "redirect:/todo/list"

        // 얻어온 View 이름이 "redirect:"로 시작하는 경우 Redirect
        if(viewName.startsWith("redirect:")) { // redirect 처리

            // redirect 요청은 무조건 "GET"
            resp.sendRedirect(viewName.substring("redirect:".length()));
        }

        // 나머지 경우는 접두사/접미사를 붙여 JSP로 Forward
        else { // forward 처리
//      String prefix = "/WEB-INF/views/";
//      String suffix = ".jsp";

            // /WEB-INF/views/index.jsp
            String view = prefix + viewName + suffix;
            RequestDispatcher dis = req.getRequestDispatcher(view);
            dis.forward(req, resp);
        }
    }


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Command command = getCommand(req);

        if(command != null) { // url이 일치하는 커맨드가 있으면 실행
            execute(command, req, resp);

        } else { // url이 일치하는 커맨드가 없다 -> 404 에러 처리
            String view = prefix + "404" + suffix;
            RequestDispatcher dis = req.getRequestDispatcher(view);
            dis.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);  // GET과 동일한 처리 로직 사용
    }

}