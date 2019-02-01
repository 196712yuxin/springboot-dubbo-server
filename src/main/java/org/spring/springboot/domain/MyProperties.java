package org.spring.springboot.domain;

/*import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myProps")*/
public class MyProperties  {
    private String applicationTitle;
    private String sessionCurrentUser;
    private String cookieUsername;
    private String cookiePassword;
    private String cookieUser;
    private String cookieMp;
    private String errorNeedAuthentication;
    private String errorNeedPrivillege;
    private String downloadpath;
    private String cookieSingleSignin;

    public String getApplicationTitle() {
        return this.applicationTitle;
    }

    public String getSessionCurrentUser() {
        return this.sessionCurrentUser;
    }

    public String getCookieUsername() {
        return this.cookieUsername;
    }

    public String getCookiePassword() {
        return this.cookiePassword;
    }

    public String getCookieUser() {
        return this.cookieUser;
    }

    public String getCookieMp() {
        return this.cookieMp;
    }

    public String getErrorNeedAuthentication() {
        return this.errorNeedAuthentication;
    }

    public String getErrorNeedPrivillege() {
        return this.errorNeedPrivillege;
    }

    public String getDownloadpath() {
        return this.downloadpath;
    }

    public String getCookieSingleSignin() {
        return this.cookieSingleSignin;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle = applicationTitle;
    }

    public void setSessionCurrentUser(String sessionCurrentUser) {
        this.sessionCurrentUser = sessionCurrentUser;
    }

    public void setCookieUsername(String cookieUsername) {
        this.cookieUsername = cookieUsername;
    }

    public void setCookiePassword(String cookiePassword) {
        this.cookiePassword = cookiePassword;
    }

    public void setCookieUser(String cookieUser) {
        this.cookieUser = cookieUser;
    }

    public void setCookieMp(String cookieMp) {
        this.cookieMp = cookieMp;
    }

    public void setErrorNeedAuthentication(String errorNeedAuthentication) {
        this.errorNeedAuthentication = errorNeedAuthentication;
    }

    public void setErrorNeedPrivillege(String errorNeedPrivillege) {
        this.errorNeedPrivillege = errorNeedPrivillege;
    }

    public void setDownloadpath(String downloadpath) {
        this.downloadpath = downloadpath;
    }

    public void setCookieSingleSignin(String cookieSingleSignin) {
        this.cookieSingleSignin = cookieSingleSignin;
    }


    public String toString() {
        return "MyProperties(applicationTitle=" + getApplicationTitle() + ", sessionCurrentUser=" + getSessionCurrentUser() + ", cookieUsername=" + getCookieUsername() + ", cookiePassword=" + getCookiePassword() + ", cookieUser=" + getCookieUser() + ", cookieMp=" + getCookieMp() + ", errorNeedAuthentication=" + getErrorNeedAuthentication() + ", errorNeedPrivillege=" + getErrorNeedPrivillege() + ", downloadpath=" + getDownloadpath() + ", cookieSingleSignin=" + getCookieSingleSignin() + ")";
    }
}
