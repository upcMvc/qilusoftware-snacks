package com.upcmvc.qilu2016.util;

/**
 * Created by 陈子枫 on 2016/7/5.
 */
public class SessionUser {
    public int visit_time;
    public VisitUser visit_user;
    public VisitOauth visit_oauth;

    public class VisitUser {
        public int userid;
        public String username;
        public String usernick;
        public char usersex;
    }

    public class VisitOauth {
        public String access_token;
        public int token_expires;
    }
}
