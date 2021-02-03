
package mytwitter;
import exceptions.*;
import java.util.Vector;

public class RepositorioUsuario implements IRepositorioUsuario {
    
    private Vector<Perfil> repositorio = new Vector<Perfil>();
    
    @Override
    public void cadastrar(Perfil usuario) {
        Perfil resultado = this.buscar(usuario.getUsuario());
        if(resultado != null){
            throw new UJCException();
        }else{
            repositorio.add(usuario);
        }
        
    }

    @Override
    public Perfil buscar(String usuario) {
         for(Perfil novoPerfil : repositorio){
            if(novoPerfil.getUsuario().equals(usuario)){
                return novoPerfil;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Perfil usuario) {
     for (int cont = 0; cont < this.repositorio.size(); cont++){
            if(repositorio.get(cont).getUsuario().equals(usuario.getUsuario())){
                repositorio.set(cont,usuario);
            }
            if(buscar(usuario.getUsuario()) == null){
                throw new UNCException();
            }
        }
    }
        
}
