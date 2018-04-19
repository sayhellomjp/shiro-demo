import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class Demo2 {

    @Test
    public void testHelloWorld() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-authenticator-all-success.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("majunpeng", "123456");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(subject.isAuthenticated());

        subject.logout();
    }
}
