package com.neuedu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateQuery {

    //增，删，改
    //单行处理
    public static int Update(String sql,Object ...parms){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int i=-1;
        try{
            connection=SqlUtil.getConn();
            preparedStatement=connection.prepareStatement(sql);
            SqlUtil.parameterIntoPreparedStatement(preparedStatement,parms);
            i=preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            SqlUtil.close(preparedStatement,connection);
        }
        return i;
    }
    //查找
    public static List<Object> query(String sql,ResultHandle resultHandle,Object ...params){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Object> objectList=new ArrayList<>();
        try{
            connection=SqlUtil.getConn();
            preparedStatement=connection.prepareStatement(sql);
            SqlUtil.parameterIntoPreparedStatement(preparedStatement,params);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Object object=resultHandle.getObjectByResultSet(resultSet);
                objectList.add(object);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            SqlUtil.close(resultSet,preparedStatement,connection);
        }

        return objectList;
    }


}
