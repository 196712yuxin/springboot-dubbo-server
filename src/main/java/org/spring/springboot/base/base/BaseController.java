package org.spring.springboot.base.base;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class BaseController
{
    private static final int BUFFER_SIZE = 102400;

    protected String modelAndView(String viewname, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("currenturl", request.getRequestURI().replace(request.getContextPath(), ""));

        return viewname;
    }

    protected ModelAndView modelAndView(ModelAndView modelview, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("currenturl", request.getRequestURI().replace(request.getContextPath(), ""));

        return modelview;
    }

    protected void appendFile(InputStream in, File destFile) {
        OutputStream out = null;
        try
        {
            if (destFile.exists())
                out = new BufferedOutputStream(new FileOutputStream(destFile, true), 102400);
            else {
                out = new BufferedOutputStream(new FileOutputStream(destFile), 102400);
            }
            in = new BufferedInputStream(in, 102400);

            int len = 0;
            byte[] buffer = new byte[102400];
            while ((len = in.read(buffer)) > 0)
                out.write(buffer, 0, len);
        }
        catch (Exception localIOException1) {
        }
        finally {
            try {
                if (null != in) {
                    in.close();
                }
                if (null != out)
                    out.close();
            }
            catch (IOException localIOException2)
            {
            }
        }
    }
}
