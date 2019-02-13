package org.spring.springboot.utils;

import net.sf.json.JSONObject;
import org.spring.springboot.domain.SysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.ui.context.Theme;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

@Component
public class WebUtil
{
    public static String getRemortIP(HttpServletRequest request)
    {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        return attributes.getRequest();
    }

    public static HttpSession getSession(Boolean create) {
        return getRequest().getSession(create.booleanValue());
    }

    public static HttpSession getSession() {
        return getSession(Boolean.valueOf(true));
    }

    public static String getSessionId() {
        return getSession().getId();
    }

    public static ServletContext getServletContext() {
        return getSession().getServletContext();
    }

    public static Locale getLocale() {
        return getRequest().getLocale();
    }

    public static Theme getTheme() {
        return RequestContextUtils.getTheme(getRequest());
    }

    public static ApplicationContext getApplicationContext() {
        return WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    public static ApplicationEventPublisher getApplicationEventPublisher()
    {
        return getApplicationContext();
    }

    public static LocaleResolver getLocaleResolver() {
        return RequestContextUtils.getLocaleResolver(getRequest());
    }

    public static ThemeResolver getThemeResolver() {
        return RequestContextUtils.getThemeResolver(getRequest());
    }

    public static ResourceLoader getResourceLoader() {
        return getApplicationContext();
    }

    public static ResourcePatternResolver getResourcePatternResolver() {
        return getApplicationContext();
    }

    public static MessageSource getMessageSource() {
        return getApplicationContext();
    }

    public static ConversionService getConversionService() {
        return (ConversionService)getBeanFromApplicationContext(ConversionService.class);
    }

    public static DataSource getDataSource() {
        return (DataSource)getBeanFromApplicationContext(DataSource.class);
    }

    public static Collection<String> getActiveProfiles() {
        return Arrays.asList(getApplicationContext().getEnvironment().getActiveProfiles());
    }

    public static ClassLoader getBeanClassLoader() {
        return ClassUtils.getDefaultClassLoader();
    }

    private static <T> T getBeanFromApplicationContext(Class<T> requiredType) {
        return getApplicationContext().getBean(requiredType);
    }

    public static SysUser getCurrentUser() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (!ApplicationConfiguration.COOKIE_USER.equals(cookie.getName())) continue;
                try {
                    String userFromCookie = URLDecoder.decode(cookie.getValue(), "utf-8");
                    JSONObject json = JSONObject.fromObject(userFromCookie);
                    SysUser user = (SysUser)JSONObject.toBean(json, SysUser.class);

                    return user;
                }
                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public static SysUser getCurrentUserByCode() {
        EncryptUtil utils= EncryptUtil.getInstance();
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (!ApplicationConfiguration.COOKIE_USER.equals(cookie.getName())) continue;
                try {
                    String userCook=utils.Base64Decode(cookie.getValue());
                    String userFromCookie = URLDecoder.decode(userCook, "utf-8");
                    JSONObject json = JSONObject.fromObject(userFromCookie);
                    SysUser user = (SysUser)JSONObject.toBean(json, SysUser.class);

                    return user;
                }
                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
