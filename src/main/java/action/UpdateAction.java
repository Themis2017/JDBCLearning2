package action;

import dao.UserinfosDAO;
import entity.Userinfos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by 10195 on 2017/7/12.
 */
@WebServlet("/update")
public class UpdateAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Userinfos user = new Userinfos();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setUsername(request.getParameter("username"));
        try {
            user.setBirthday(sdf.parse(request.getParameter("birthday")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setUserphoto(request.getParameter("userphoto"));
        user.setUserid(Integer.parseInt(request.getParameter("userid")));
        new UserinfosDAO().updateUser(user);
        response.sendRedirect("init");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
