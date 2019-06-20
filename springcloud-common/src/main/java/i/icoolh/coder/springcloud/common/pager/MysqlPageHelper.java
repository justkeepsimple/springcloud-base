package i.icoolh.coder.springcloud.common.pager;

import com.github.pagehelper.PageHelper;

import java.util.Properties;

/**
 * Created by yangkaihong on 2018/12/19
 */
public class MysqlPageHelper {
    private MysqlPageHelper() {
    }

    private volatile static PageHelper pageHelper;


    public static PageHelper getMysqlPageHelper() {
        if (pageHelper == null) {
            synchronized (MysqlPageHelper.class) {
                if (pageHelper == null) {
                    pageHelper = new PageHelper();
                    Properties properties = new Properties();
                    properties.setProperty("offsetAsPageNum", "true");
                    properties.setProperty("rowBoundsWithCount", "true");
                    properties.setProperty("reasonable", "true");
                    properties.setProperty("dialect", "mysql");    //配置mysql数据库的方言
                    pageHelper.setProperties(properties);
                }
            }
        }
        return pageHelper;
    }
}
