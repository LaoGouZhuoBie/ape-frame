package init;

import org.springframework.stereotype.Component;


/**
 * 预热缓存的抽象类
 */
@Component
public abstract class AbstractCache {

    public void initCache(){}

    public <T> T getCache(String key){
        return null;
    }

    public void clearCache(){}

    public void reloadCache(){
        clearCache();
        initCache();
    }

}
