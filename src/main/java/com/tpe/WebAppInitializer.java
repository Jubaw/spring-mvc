package com.tpe;

//Java tabanlo Web uygulamaları web.xml dosyası ile config edilir.
//Bu classı web.xml yerine kullanacağız.

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//AbstractAnnotation... : DispatcherServlet configurasyonu ve başlatılması için gerekli adımları gösterir.
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {//dataya erişim:Hibernate, JDBC
        return new Class[]{
                RootConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//viewresolver, handlermapping
        return new Class[]{
                WebMvcConfig.class
        };
    }

    @Override//hangi url ile gelen istekler servlet tarafından karşılanacak ayarlaması
    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }
}
