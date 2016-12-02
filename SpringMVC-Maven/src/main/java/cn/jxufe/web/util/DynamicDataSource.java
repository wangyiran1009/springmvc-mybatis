package cn.jxufe.web.util;

import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
public class DynamicDataSource extends AbstractRoutingDataSource{
    
    @Override  
    public void setTargetDataSources(Map targetDataSources) {  
        super.setTargetDataSources(targetDataSources);  
    }  
      
    @Override  
    public Object unwrap(Class iface) throws SQLException {  
        return null;  
    }  
  
    @Override  
    public boolean isWrapperFor(Class iface) throws SQLException {  
        return false;  
    }  
  
    @Override  
    protected Object determineCurrentLookupKey() {  
        String dataSourceName = DbContextHolder.getDataSourceName();  
        DbContextHolder.clear();
		      logger.debug("dataSource: "+dataSourceName);
        return dataSourceName;  
    }

    @Override
    public Logger getParentLogger() {
        return null;
    }  
    
}
