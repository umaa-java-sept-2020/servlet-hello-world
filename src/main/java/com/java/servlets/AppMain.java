package com.java.servlets;

public class AppMain {

    public static void main(String[] args) {
        HttpServlet a = new TestServlet();
        a.service();
    }

    private abstract static  class HttpServlet {

        public void service()
        {
            System.out.println("default logic");
        }
    }

    private static class TestServlet extends HttpServlet {

        @Override
        public void service() {
           // super.service();
            System.out.println("custom logic");
        }
    }
}
