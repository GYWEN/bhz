package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description> 将JSON对象进行转换 <br>;
 *
 * @author gyw<br>
 * @version 1.0<br>
 * @taskId
 * @CreateDate 2019/5/23
 * @see utils <br>
 * @since V7.3<br>
 */
public class FastJsonConvert {


    /**
     * Description: 将JSON字符串转化为具体的对象<br>;
     *
     * @author gyw <br>;
     * @taskId <br>;
     * @Param [data, clazz]
     * @return T 返回对应对象<br>;
     */
    public static <T> T converJSONToObject(String data, Class<T> clazz){
        T t = JSON.parseObject(data,clazz);
        return t;
    }

    /**
     * Description: 将JSON对象转化为具体的Class <br>;
     *
     * @author gyw <br>;
     * @taskId <br>;
     * @Param [jsonObject, clazz]
     * @return T <br>;
     */
    public static <T> T convertJSONToObject(JSONObject jsonObject, Class<T> clazz) {
        T t = JSON.toJavaObject(jsonObject,clazz);
        return t;
    }

    /**
     * Description:将JSON字符串转化为数组 <br>;
     *
     * @author gyw <br>;
     * @taskId <br>;
     * @Param [data, clazz]
     * @return T <br>;
     */
    public static <T> List<T> convertJSONToArray(String data, Class<T> clazz){
        List<T> tList = JSON.parseArray(data,clazz);
        return tList;
    }

    /**
     * Description: 将Json数组转化为对应的Java类 <br>;
     *
     * @author gyw <br>;
     * @taskId <br>;
     * @Param [jsonObjectList, clazz]
     * @return java.util.List<T> <br>;
     */
    public static <T> List<T> convertJSONToArray(List<JSONObject> jsonObjectList, Class<T> clazz){
        List<T> tList = new ArrayList<>();
        for (JSONObject jsonObject :jsonObjectList) {
            tList.add(convertJSONToObject(jsonObject,clazz));
        }
        return tList;
    }

    /**
     * Description:将对象转换为JSON字符串 <br>;
     *
     * @author gyw <br>;
     * @taskId <br>;
     * @Param [obj]
     * @return java.lang.String <br>;
     */
    public static <T> String convertObjectToJSON(Object obj){
        String text = JSON.toJSONString(obj);
        return text;
    }


    /**
     * Description: 将对象转化为JSONObject对象<br>;
     *
     * @author gyw <br>;
     * @taskId <br>;
     * @Param []
     * @return com.alibaba.fastjson.JSONObject <br>;
     */
    public static <T> JSONObject convertObjectToJSONObject(Object object){
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(object);
        return  jsonObject;
    }

}
