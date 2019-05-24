package dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * <Description> <br>;
 *
 * @author gyw<br>
 * @version 1.0<br>
 * @taskId
 * @CreateDate 2019/5/23
 * @see dao <br>
 * @since V7.3<br>
 */
public class JasonRowMapper implements RowMapper {


    @Override
    public JSONObject mapRow(ResultSet resultSet, int i) throws SQLException {

        String key = null;
        Object obj = null;
        JSONObject jsonObject = new JSONObject();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int count = resultSetMetaData.getColumnCount();
        for (int index = 1; index <= count; index++){
            key = JdbcUtils.lookupColumnName(resultSetMetaData,i);
            obj = JdbcUtils.getResultSetValue(resultSet,i);
        }
        jsonObject.put(key,obj);
        return jsonObject;
    }
}
