package app.servlet;

import app.entities.Bean;
import app.entities.ElemBean;
import app.functions.Validation;
import com.google.gson.Gson;

import javax.json.JsonArrayBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import javax.json.Json;
import javax.json.JsonObject;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;

//@WebServlet(name = "Servlet")
//@MultipartConfig
public class Servlet extends HttpServlet {


    Bean bean = new Bean();
    //@Override
    //protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("Yeah");

        float[] reqX = (float[]) req.getAttribute("x");
        float[] reqY = (float[]) req.getAttribute("y");
        float[] reqR = (float[]) req.getAttribute("R");

        /*

        HttpSession session = req.getSession();
        if (session.getAttribute("result") == null)
            session.setAttribute("result", new LinkedList<HashMap<String, String>>());
        LinkedList<HashMap<String, String>> list = cast(session.getAttribute("result"));
        */
        long start_millis = (Long) req.getAttribute("start_millis");
        LinkedList<ElemBean> list = bean.getBean();
        SimpleDateFormat sDFormat = new SimpleDateFormat("HH:mm:ss");

        for (int i = 0; i < reqX.length; ++i){

            float R = reqR[i];
            float x = reqX[i];
            float y = reqY[i];

            boolean result = checkInArea(x, y, R);
            HashMap<String, String> map = new HashMap<>();
            ElemBean elemBean = new ElemBean(reqX[i], reqY[i], reqR[i], result, System.currentTimeMillis() - start_millis, sDFormat.format(Calendar.getInstance().getTime()));
            list.add(elemBean);
        }


        bean.setBean(list);
        HttpSession session = req.getSession();
        session.setAttribute("bean", bean);
        //session.setAttribute("result", list);
        //req.setAttribute("result", bean);
        //req.getRequestDispatcher("index.jsp").forward(req, resp);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        //JsonObject jsonObject = (JsonObject) Json.createObjectBuilder().add("res", (JsonArrayBuilder) bean.getBean());
        PrintWriter out = resp.getWriter();
        //out.println(jsonObject.toString());
        Gson json = new Gson();
        out.println(json.toJson(bean.getBean()));
    }

    //check if the point in the area
    private boolean checkInArea(float x, float y, float R){
        boolean res = false;

        //for circle
        if (ceil(x) <= 0 && ceil(y) <= 0 && Float.compare(x*x + y*y, R*R) <= 0){
            System.out.println(x*x + y*y);
            res = true;
        }

        //for rectangle
        if (floor(x) >= 0 && ceil(x) <= R && ceil(y) <= 0 && Float.compare(y, -R/2) >= 0){
            System.out.println(y);
            res = true;
        }

        //for triangle
        if (ceil(x) <= 0 && floor(y) >= 0 && Float.compare(-x + y, R) <= 0){
            System.out.println(x + y);
            res = true;
        }

        return res;
    }

}
