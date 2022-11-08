package oclock.oclock.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
//이 부분은 그냥 인터넷에서 복사해옴 / 링크 - https://m.blog.naver.com/rhrkdfus/221397524547
public class MainController {
    //Controller 부분만 복사해옴 jsp로 반환해서 프론트에 넘기라는데 이건 뭔지 모르겠음
    // 안드로이드 요청(id, pw 받아서 db연동)
    @RequestMapping(value= "/android", method = {RequestMethod.POST})
    public String androidPage(HttpServletRequest request, Model model) {
        System.out.println("서버에서 안드로이드 접속 요청함");
        try{
            String androidID = request.getParameter("id");
            String androidPW = request.getParameter("pw");
            System.out.println("안드로이드에서 받아온 id : " + androidID);
            System.out.println("안드로이드에서 받아온 pw : " + androidPW);
            model.addAttribute("android", androidID);
            return "android";
        }catch (Exception e){
            e.printStackTrace();
            return "null";
        }
    }
}
