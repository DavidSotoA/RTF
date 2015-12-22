package com.websystique.springsecurity.configuration;


import com.websystique.springsecurity.dao.ProgramacionDAO;
import com.websystique.springsecurity.dao.ProgramacionDAOImp;
import com.websystique.springsecurity.dao.UsuarioDAO;
import com.websystique.springsecurity.dao.UsuarioDAOImp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration 
@EnableWebMvc
//@EnableTransactionManagement
@ComponentScan(basePackages = "com.websystique.springsecurity")
//@Import({ SecurityConfiguration.class })
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter {
   
    /* 
     @Bean
        public SessionFactory sessionFactory() {
                LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
                builder.scanPackages("com.websystique.springsecurity.model").addProperties(getHibernateProperties());

                return builder.buildSessionFactory();
        }
        
        private Properties getHibernateProperties() {
                Properties prop = new Properties();
                prop.put("hibernate.format_sql", "true");
                prop.put("hibernate.show_sql", "true");
                prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                return prop;
        }
*/
   
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    
    @Bean(name = "dataSource")
	public DriverManagerDataSource getDataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
            driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/cineudea");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("root");
	    return driverManagerDataSource;
	}
    
    @Bean(name = "HelloWorld")
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
      }
    
    
//    @Bean(name="HelloWorld")       
//    UrlBasedViewResolver resolver(){
//    UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//
//    resolver.setPrefix("/WEB-INF/views/");
//    resolver.setSuffix(".jsp");
//    resolver.setViewClass(JstlView.class);
//    return resolver;
//    }
    
    @Bean(name="usuarioBean")
    public UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOImp(getDataSource());
    }
        
    @Bean(name="programacionBean")
    public ProgramacionDAO getProgramacionDAO(){
        return new ProgramacionDAOImp(getDataSource());
    }       

    
    /*

     @Bean
     public HibernateTransactionManager txManager() {
     return new HibernateTransactionManager(sessionFactory());
     }
     */

    
    
    
    
}
