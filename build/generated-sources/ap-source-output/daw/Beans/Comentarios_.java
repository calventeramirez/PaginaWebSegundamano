package daw.Beans;

import daw.Beans.Articulos;
import daw.Beans.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-25T19:39:31")
@StaticMetamodel(Comentarios.class)
public class Comentarios_ { 

    public static volatile SingularAttribute<Comentarios, String> texto;
    public static volatile SingularAttribute<Comentarios, Long> id;
    public static volatile ListAttribute<Comentarios, Articulos> articulo;
    public static volatile SingularAttribute<Comentarios, Usuario> user;
    public static volatile SingularAttribute<Comentarios, String> visibilidad;

}