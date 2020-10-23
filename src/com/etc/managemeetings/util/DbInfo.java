package com.etc.managemeetings.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class DbInfo {
    private static DbInfo dbInfo ;
    //定义实体类ConfigInfo对象
    private ConfigInfo configInfo ;
    private DbInfo(){
        configInfo = new ConfigInfo() ;
    }
    public static DbInfo getInstance(){
        if (dbInfo == null)
            dbInfo = new DbInfo();
        return dbInfo ;
    }
    //定义一个方法，用来获取到properties文件中的信息。
    public ConfigInfo getProperties() throws URISyntaxException, IOException {
        //找到资源
        String path = DbInfo.class.getResource("/").toURI().getPath() + "db.properties" ;
        //创建File对象
        File file = new File(path) ;
        //创建流对象
        FileInputStream fin = new FileInputStream(file) ;
        //创建Properties对象
        Properties properties = new Properties() ;
        //将properties与流对象进行关联。
        properties.load(fin);
        fin.close();
        configInfo.setDbdriver(properties.getProperty("dbdriver"));
        configInfo.setDbURL(properties.getProperty("dbURL"));
        configInfo.setPwd(properties.getProperty("pwd"));
        configInfo.setUname(properties.getProperty("uname"));
        return configInfo ;
    }
    public class ConfigInfo{
        private String dbdriver ;
        private String dbURL ;
        private String uname ;
        private String pwd ;

        public String getDbdriver() {
            return dbdriver;
        }

        public void setDbdriver(String dbdriver) {
            this.dbdriver = dbdriver;
        }

        public String getDbURL() {
            return dbURL;
        }

        public void setDbURL(String dbURL) {
            this.dbURL = dbURL;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        DbInfo dbInfo =  DbInfo.getInstance() ;
        ConfigInfo configInfo = dbInfo.getProperties() ;
        System.out.println(configInfo.getDbdriver() + " "
                + configInfo.getDbURL() + " "
                + configInfo.getUname() + " "
                + configInfo.getPwd() + " ");
    }
}


