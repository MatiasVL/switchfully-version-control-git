package com.cegeka.switchfully.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This entry point is only used when the authentication didn't succeed (eg: an unknown username/password combination).
 */
@Component
public class ArmyAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    public static final String NAME_OF_REALM = "ARMYRealm";

    public ArmyAuthenticationEntryPoint() {
        setRealmName(NAME_OF_REALM);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) {
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
