package init;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import util.SpringContextUtil;

import java.util.Map;


/**
 * 缓存预热
 */
@Component
public class InitCache implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        //我要知道哪些缓存需要进行一个预热
        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        Map<String, AbstractCache> beanMap = applicationContext.getBeansOfType(AbstractCache.class);
        //调用init方法
        if(beanMap.isEmpty()){
            return;
        }
        for(Map.Entry<String,AbstractCache> entry : beanMap.entrySet()){
            AbstractCache abstractCache = (AbstractCache) SpringContextUtil.getBean(entry.getValue().getClass());
            abstractCache.initCache();
        }
    }

}
