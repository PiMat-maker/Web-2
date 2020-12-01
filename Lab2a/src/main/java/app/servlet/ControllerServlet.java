package app.servlet;

import app.functions.Validation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

@WebServlet("/controllerServlet")
@MultipartConfig
public class ControllerServlet extends HttpServlet {

    //@Override
    //protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("Yeah");


        long start_millis = System.currentTimeMillis();
        req.setAttribute("start_millis", start_millis);
        LinkedList<Float> x = new LinkedList<>();
        LinkedList<Float> y = new LinkedList<>();
        LinkedList<Float> R = new LinkedList<>();


        //read items
        int size = 0;
        try {
            Part part = req.getPart("x[0]");
            while (part != null) {
                x.add(Float.parseFloat(new BufferedReader(new InputStreamReader(part.getInputStream()))
                        .lines().collect(Collectors.joining("\n"))));
                size += 1;
                part = req.getPart("x[" + size + "]");
            }
            for (int i = 0; i < size; ++i) {
                String s =new BufferedReader(new InputStreamReader(req.getPart("y[" + i + "]").getInputStream()))
                        .lines().collect(Collectors.joining("\n"));
                y.add(Float.parseFloat(s.substring(0, min(s.length(), 8))));
                System.out.println(y.get(i));
                R.add(Float.parseFloat(new BufferedReader(new InputStreamReader(req.getPart("R[" + i + "]").getInputStream()))
                        .lines().collect(Collectors.joining("\n"))));
            }
        } catch(NullPointerException ex){
            System.out.println("NULLPOINTER");
            size = min(y.size(), R.size());
        }

        float[] reqX = {};
        float[] reqY = {};
        float[] reqR = {};

        for (int i = 0; i < size; ++i) {
            Validation validation = new Validation(-7, 7, false);
            if (!validation.validate(x.get(i))) continue;
            validation = new Validation(-5, 3, true);
            if (!validation.validate(y.get(i))) continue;
            validation = new Validation(1, 5, false);
            if (!validation.validate(R.get(i))) continue;
                reqX = addElement(reqX, x.get(i));
                reqY = addElement(reqY, y.get(i));
                reqR = addElement(reqR, R.get(i));
        }

        if (reqX.length == 0 || reqY.length == 0 || reqR.length == 0){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);
        }
        req.setAttribute("x", reqX);
        req.setAttribute("y", reqY);
        req.setAttribute("R", reqR);
        req.getRequestDispatcher("Servlet").forward(req, resp);
    }

    static float[] addElement(float[] strings, Float val){
        strings = Arrays.copyOf(strings, strings.length + 1);
        strings[strings.length - 1] = val;
        return strings;
    }

}
