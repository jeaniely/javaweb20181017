package com.neuedu.util;

import java.sql.*;

public class SqlUtil {
    //加载驱动
    static{
        try {
            Class.forName(com.neuedu.util.ParaUtil.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //连接
    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(ParaUtil.URL,ParaUtil.USERNAME,ParaUtil.PASSWORD);
    }

    public static void parameterIntoPreparedStatement(PreparedStatement pstm,Object ...objs) throws SQLException{
        if(objs!=null&&objs.length>0) {
            for (int i = 0; i < objs.length; i++) {
                pstm.setObject(i + 1, objs[i]);
            }
        }
    }

    //关闭
    public static void close(Object ...objs){//可变数组
        if(objs!=null&& objs.length>0){
            try{
                for(Object obj:objs){
                    if(obj!=null){
                        if(obj instanceof Connection){
                            ((Connection)obj).close();
                        }
                        if(obj instanceof Statement){
                            ((Statement)obj).close();
                        }

                        if(obj instanceof ResultSet){
                            ((ResultSet)obj).close();
                        }

                    }
                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws  SQLException{
        System.out.println(getConn());
    }

}
