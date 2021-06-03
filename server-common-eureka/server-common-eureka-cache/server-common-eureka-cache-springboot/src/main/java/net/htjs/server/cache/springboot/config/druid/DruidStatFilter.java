package net.htjs.server.cache.springboot.config.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


@WebFilter(
	filterName="druidWebStatFilter",
	urlPatterns="/*",
	initParams={
		@WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico")//忽略资源
	}
)
public class DruidStatFilter extends WebStatFilter{

}
