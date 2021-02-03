package mytwitter;
import java.util.Vector;

public abstract class Perfil {
    
    private String usuario;
    private Vector<String> seguidores = new Vector<String>();
    private Vector<Tweet> timeline = new Vector<Tweet>();
    private boolean ativo;
    
    public Perfil(String usuario){
        this.usuario = usuario;
        this.ativo = true;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
     
    }
    public String getUsuario(){   
        return usuario;
    }
    public Vector<String> getSeguidores(){
        return seguidores;
    }
    public Vector<Tweet> getTimeline(){
        return timeline;
    }
    public void setAtivo(boolean valor){
        this.ativo = valor;
    }
    public boolean isAtivo(){
        return ativo;
    }
    public void addSeguidor(String usuario){
        seguidores.add(usuario);
    }
    public void addTweet(Tweet tweet){
        timeline.add(tweet);
    }
    @Override
    public String toString() {
        String txt_timeline = "";
        for (Tweet tweets : timeline) {
            txt_timeline += tweets.getMensagem() + "\n";
        }
        
        return "Perfil: " + "\n Usuario= \n" + usuario + "\n Seguidores= \n" + seguidores + "\n Timeline= \n" + txt_timeline + "\n Ativo= \n" + ativo + '}';
    }
    
    
}
