package dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

/**
 * <Description> 用于设置一些JDBC常用的增删改查，方便后续直接调用<br>;
 *
 * @author gyw<br>
 * @version 1.0<br>
 * @taskId
 * @CreateDate 2019/5/23
 * @see dao < br>
 * @since V7.3<br>
 */
public class BaseDao {

    /** JSON数据行映射器 */
    private static final JasonRowMapper JSON_ROW_MAPPER = new JasonRowMapper();

    private JdbcTemplate jdbcTemplate;

    private static Date startTime;

    @Autowired
    public void initJdbcTemplate(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        if (this.startTime == null) {
            startTime = getCurrentTime();
        }
    }

    /**
     * <B>取得：</B>JDBC调用模板<BR>
     *
     * @return JdbcTemplate JDBC调用模板
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * <B>取得：</B>启动时间<BR>
     *
     * @return Date 启动时间
     */
    public Date getStartTime() {
        return startTime;
    }
    /**
     * Description: 获取当前时间<br>;
     *
     * @author gyw <br>;
     * @taskId <br>;
     * @Param []
     * @return java.util.Date <br>;
     */
    public Date getCurrentTime(){

        String sql = "select NOW() currentDate";

        return jdbcTemplate.queryForObject(sql,Date.class);

    }

    /**
     * Description: 查询Json列表<br>;
     *
     * @author gyw <br>;
     * @taskId <br>;
     * @Param []
     * @return List<JSONObject> <br>;
     */
    public List<JSONObject> quertForJsonList(String sql,Object... args){
        return this.jdbcTemplate.query(sql,JSON_ROW_MAPPER,args);
    }

    /**
     * Description: 查询单个结果的Json数据 < br>;
     *
     * @author gyw <br>;
     * @taskId <br>;
     * @Param [sql, args]
     * @return com.alibaba.fastjson.JSONObject <br>;
     */
    public JSONObject queryForJsonObject(String sql, Object... args){
        List<JSONObject> jsonObjectList = this.jdbcTemplate.query(sql,JSON_ROW_MAPPER,args);
        if (jsonObjectList == null || jsonObjectList.isEmpty()){
            return null;
        }
        return jsonObjectList.get(0);
    }


    /**
     * Description:查询文本  < br>;
     *
     * @author gyw <br>;
     * @taskId <br>;
     * @Param [sql, args]
     * @return java.lang.String <br>;
     */
    public String queryForString(String sql, Object... args){
        List<String> stringList = this.jdbcTemplate.queryForList(sql,args,String.class);
        if (stringList == null || stringList.isEmpty()){
            return null;
        }
        return stringList.get(0);
    }


    /**
     * Description: 拼接分页SQL <br>;
     *
     * @author gyw <br>;
     * @taskId <br>;
     * @Param [builderSql, start, end]
     * @return void <br>;
     */
    public void appendPageSql(StringBuilder builderSql, int start,int end){

        builderSql.insert(0,"SELECT * FROM (" )
                .append(") A")
                .append("limit start,end");

    }


}
