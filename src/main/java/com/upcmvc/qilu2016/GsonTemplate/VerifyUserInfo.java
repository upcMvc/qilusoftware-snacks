package com.upcmvc.qilu2016.GsonTemplate;

/**
 * Created by 陈子枫 on 2016/7/5.
 */
public class VerifyUserInfo {
    public String status;
    public RealInfo info;

    public class RealInfo {
        public int yb_userid;
        public String yb_realname;
        public String yb_schoolid;
        public String yb_schoolname;
        public String yb_studentid;
        public String code;
        public String msgCN;
        public String msgEN;
    }
}
