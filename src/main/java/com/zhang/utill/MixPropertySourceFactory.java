package com.zhang.utill;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.Properties;

public class MixPropertySourceFactory extends DefaultPropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource)
            throws IOException {

        String sourcename=name!=null?name:resource.getResource().getFilename();

        if (sourcename!=null && (sourcename.endsWith(".yaml")||sourcename.endsWith("yml"))){
            Properties yml = loadYml(resource);
            return new PropertiesPropertySource(sourcename,yml);
        }else {
            return super.createPropertySource(name,resource);
        }
    }
    private Properties loadYml(EncodedResource resource){
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(resource.getResource());
        yamlPropertiesFactoryBean.afterPropertiesSet();
        return yamlPropertiesFactoryBean.getObject();
    }
}
