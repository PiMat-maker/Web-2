package app.servlet;

import app.exception.ShowException;
import app.exception.WebException;
import app.functions.Validation;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
@WebServlet("/controllerServlet")
@MultipartConfig
public class ControllerServlet extends HttpServlet {

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


        LinkedList<String> x = new LinkedList<>();
        LinkedList<String> y = new LinkedList<>();
        LinkedList<String> R = new LinkedList<>();

        //read items
        Part part = req.getPart("x[0]");
        int size = 0;
        try {
            while (part != null) {
                x.add(new BufferedReader(new InputStreamReader(part.getInputStream()))
                        .lines().collect(Collectors.joining("\n")));
                size += 1;
                part = req.getPart("x[" + size + "]");
            }
            for (int i = 0; i < size; ++i) {
                y.add(new BufferedReader(new InputStreamReader(req.getPart("y[" + i + "]").getInputStream()))
                        .lines().collect(Collectors.joining("\n")));
                R.add(new BufferedReader(new InputStreamReader(req.getPart("R[" + i + "]").getInputStream()))
                        .lines().collect(Collectors.joining("\n")));
                System.out.println(i);
            }
        } catch (NullPointerException e){
            throw new ShowException(WebException.WRONG_NUMBER_OF_ARGUMENTS);
        }

        String[] reqX = {};
        String[] reqY = {};
        String[] reqR = {};

        for (int i = 0; i < size; ++i) {
            Validation validation = new Validation(-11, 11, false);
            if (!validation.validate(x.get(i))) throw new ShowException(WebException.X_IS_INVALID);
            validation = new Validation(-11, 11, true);
            if (!validation.validate(y.get(i))) throw new ShowException(WebException.Y_IS_INVALID);
            validation = new Validation(1, 5, false);
            if (!validation.validate(R.get(i))) throw new ShowException(WebException.RADIUS_IS_INVALID);
                reqX = addElement(reqX, x.get(i));
                reqY = addElement(reqY, y.get(i));
                reqR = addElement(reqR, R.get(i));
        }

        if (reqX.length == 0 || reqY.length == 0 || reqR.length == 0){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);
        }
        for (String str : reqY){
            System.out.println("This =" + str);
        }
        req.setAttribute("x", reqX);
        req.setAttribute("y", reqY);
        req.setAttribute("R", reqR);
        req.getRequestDispatcher("Servlet").forward(req, resp);
    }

    static String[] addElement(String[] strings, String val){
        strings = Arrays.copyOf(strings, strings.length + 1);
        strings[strings.length - 1] = val;
        return strings;
    }

}
