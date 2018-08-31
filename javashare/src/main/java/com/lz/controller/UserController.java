package com.lz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.lz.po.Book;
import com.lz.po.Node;
import com.lz.po.Video;
import com.lz.service.*;
import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.lz.service.UserService;
import com.lz.mapper.UserMapper;
import com.lz.po.User;
/**
 * 处理前端传过来的数据并返回结果
 * @author Administrator
 *
 */
@Controller
public class UserController extends BaseController<UserService> {
    private static int star=1;
    private static int pagesize=5;
    private static String userNum;
    private static List<User> users;
    private static int star1=0;
    private static String userType="nomal";
    /**
     * 转发到登录界面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    /**
     * 转发到注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register() {
//		ModelAndView mView=new ModelAndView();
//		mView.setViewName("register");
//		return mView;
        return "register";
    }
    /**
     * 通过重定向转发到管理主页
     * @param request
     * @param response
     */
    @RequestMapping("/manage")
    public void manage(HttpServletRequest request, HttpServletResponse response) {
        try {
            selectAllUser(request,response);
            selectAllIQ(request,response);
            selectAllBook(request,response);
            selectAllNode(request,response);
            selectAllVideo(request,response);
            request.getRequestDispatcher("/WEB-INF/admin/managermain.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 用户登录，判断用户名与密码的一致性并得到用户类型
     * @param request
     * @param response
     */
    @RequestMapping("/loginuser")
    public void loginUser(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        try {
            String selectUser = service.selectUser(username);
            if(selectUser!=null) {
                String utype = service.isUser(new User(username,password));
                if("admin".equals(utype)) {
                    response.getWriter().write("2");
                }else if("nomal".equals(utype)) {
                    response.getWriter().write("1");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 添加用户
     * @param request
     * @param response
     */
    @RequestMapping("/insertuser")
    public void registerUser(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String uType=request.getParameter("usertype");
        if(uType!=null) {
            userType=uType;
        }
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUserType(userType);
//		System.out.println(user);
        try {
            String selectUser = service.selectUser(username);
            if(selectUser==null) {
                service.insterUser(user);
                response.getWriter().write("1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/selectalluser")
    public void selectAllUser(HttpServletRequest request, HttpServletResponse response) {
        users = service.selectAllUser();
        request.setAttribute("users", users);
    }
    /**
     * 分页查询，转发并重定向到管理用户界面
     * @param request
     * @param response
     */
    @RequestMapping("/selectalluserbypages")
    public void selectAllUserByPages(HttpServletRequest request, HttpServletResponse response) {
        userNum=service.selectUsersNum();
        int totalpages=pages(userNum, String.valueOf(pagesize));
        String start=(String)request.getParameter("pages");
//		System.out.println(start);
        if(start!=null) {
            int parseInt = Integer.parseInt(start);
            if(parseInt>=1&&parseInt<=totalpages) {
                star=parseInt;
                star1=(star-1)*pagesize;

            }
        }
        users = service.selectAllUserByPages(star1,pagesize);
//		System.out.println(users);
        request.setAttribute("users", users);
        request.setAttribute("pages", star);
//		System.out.println(star);
        request.setAttribute("totalpages", totalpages);
//		try {
//			request.getRequestDispatcher("/WEB-INF/admin/managingusers.jsp").forward(request, response);
//		} catch (ServletException | IOException e) {
//			e.printStackTrace();
//		}
    }
    /**
     * 根据用户名删除用户
     * @param request
     * @param response
     */
    @RequestMapping("/deleteuser")
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        try {
            service.deleteUser(username);
            response.getWriter().write("1");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/selectum")
    public void selectUserMessage(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        try {
            User user = service.selectUserMessage(username);
            if(user!=null) {
                getJson(request, response, user);//返回一个user对象
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    @RequestMapping("/updateuser")
    public void updateUser(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String userType=request.getParameter("usertype");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUserType(userType);
        try {
            int updateUser = service.updateUser(user);
            if(updateUser==1) {
                response.getWriter().write("1");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }






    @RequestMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/WEB-INF/admin/test.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }







    /**
     * 方法，传入需要显示的总数以及每页需要显示的数量，返回总页数
     * @param num
     * @param pag
     * @return
     */
    public int pages(String num,String pag) {
        int n=Integer.parseInt(num);
        int p=Integer.parseInt(pag);
        int flag=n%p;
        if(flag!=0) {
            return n/p+1;
        }else {
            return n/p;
        }
    }

    protected static void getJson(HttpServletRequest request,HttpServletResponse response,Object object){
        response.setContentType("text/html;charset=UTF-8");
        //禁用缓存，确保网页信息是最新数据
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", -10);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String jsonStr=JSON.toJSONString(object);
            out.print(jsonStr);
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            out.close();
        }
    }

    public void selectAllIQ(HttpServletRequest request,HttpServletResponse response){
        InterViewQuestionService bean = act.getBean(InterViewQuestionService.class);
        List<InterViewQuestionService> iqs = bean.selectAllIQ();
        request.setAttribute("iqs",iqs);
    }

    public void selectAllBook(HttpServletRequest request,HttpServletResponse response){
        BookService bean = act.getBean(BookService.class);
        List<Book> books = bean.selectAllBook();
        request.setAttribute("books",books);
    }

    public void selectAllNode(HttpServletRequest request,HttpServletResponse response){
        NodeService bean = act.getBean(NodeService.class);
        List<Node> nodes = bean.selectAllNode();
        request.setAttribute("nodes",nodes);
    }

    public void selectAllVideo(HttpServletRequest request,HttpServletResponse response){
        VideoService bean = act.getBean(VideoService.class);
        List<Video> videos = bean.selectAllVideo();
        request.setAttribute("videos",videos);
    }
}
