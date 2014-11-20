/*

FORMMRREEANTEL - Formulario Ministerio Relaciones Exteriores
Copyright (C) 2009  ANTEL - MRREE

This file is part of FORMMRREEANTEL.

FORMMRREEANTEL is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 
*/

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
