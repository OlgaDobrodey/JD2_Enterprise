package by.it_academy.jd2.web;

import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class PathResponse {
    public static void path(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> result, String path) {
        try {
            result.put("redirect", request.getContextPath() + path);
            JSONObject responseData = new JSONObject(result);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(responseData);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
