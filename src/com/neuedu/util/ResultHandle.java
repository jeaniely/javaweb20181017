package com.neuedu.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultHandle {
    Object getObjectByResultSet(ResultSet resultSet) throws SQLException;
}
