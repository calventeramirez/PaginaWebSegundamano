package daw.Beans;

import daw.Beans.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-25T19:39:31")
@StaticMetamodel(Articulos.class)
public class Articulos_ { 

    public static volatile SingularAttribute<Articulos, String> descripcion;
    public static volatile SingularAttribute<Articulos, String> fecha;
    public static volatile SingularAttribute<Articulos, String> estado;
    public static volatile SingularAttribute<Articulos, Double> precio;
    public static volatile SingularAttribute<Articulos, String> categoria;
    public static volatile SingularAttribute<Articulos, Long> id;
    public static volatile SingularAttribute<Articulos, String> nombre;
    public static volatile SingularAttribute<Articulos, Usuario> user;

}