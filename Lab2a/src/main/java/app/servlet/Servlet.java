package app.servlet;

import app.entities.Bean;
import app.exception.ShowException;
import app.exception.WebException;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        //requestDispatcher.forward(req, resp);
        throw new ShowException(WebException.METHOD_DOES_NOT_AVAILABLE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("Yeah");

        String[] reqX = (String[]) req.getAttribute("x");
        String[] reqY = (String[]) req.getAttribute("y");
        String[] reqR = (String[]) req.getAttribute("R");

        /*

        HttpSession session = req.getSession();
        if (session.getAttribute("result") == null)
            session.setAttribute("result", new LinkedList<HashMap<String, String>>());
        LinkedList<HashMap<String, String>> list = cast(session.getAttribute("result"));
        */
        LinkedList<HashMap<String, String>> list = bean.getBean();


        for (int i = 0; i < reqX.length; ++i){

            float R = Float.parseFloat(reqR[i]);
            float x = Float.parseFloat(reqX[i]);
            float y = Float.parseFloat(reqY[i]);

            String result = checkInArea(x, y, R);
            HashMap<String, String> map = new HashMap<>();
            map.put("x", reqX[i]);
            map.put("y", reqY[i]);
            map.put("R", reqR[i]);
            map.put("result", result);
            map.put("workTime", "workTime");
            map.put("currentTime", "currentTime");
            list.add(map);
        }

        bean.setBean(list);
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
    private String checkInArea(float x, float y, float R){
        String res = "&#10060";

        //for circle
        if (ceil(x) <= 0 && ceil(y) <= 0 && x*x + y*y <= R*R){
            res = "&#9989";
        }

        //for rectangle
        if (floor(x) >= 0 && ceil(x) <= R && ceil(y) <= 0 && y + R/2 >= 0){
            res = "&#9989";
        }

        //for triangle
        if (ceil(x) <= 0 && floor(y) >= 0 && -x + y + R >= 0){
            res = "&#9989";
        }

        return res;
    }

}
