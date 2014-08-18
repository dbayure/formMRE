package uy.com.antel.formmrree.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="ayudaBean")
@SessionScoped
public class AyudaBean {

    private List<String> imagenes;
    
    @PostConstruct
    public void init() {
    	imagenes = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
        	imagenes.add("/resources/imagenes/ayuda" + i + ".png");
        }
    }
 
    public List<String> getImagenes() {
        return imagenes;
    }
}
