package mytwitter;
import exceptions.*;
import java.awt.JobAttributes;
import java.util.Vector;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.*;
/*
@Italo Ramillys
*/

public class MyTwitter implements ITwitter{

    
    public IRepositorioUsuario repositorio;
    
    public static void main(String[] args) {
        
        //Tela tela = new Tela();
        //tela.setVisible(true);
        
        
        RepositorioUsuario rep = new RepositorioUsuario();
        MyTwitter novo_twitter = new MyTwitter(rep); 
        
        Scanner scan = new Scanner(System.in);
        
        //String de alerta de retorno
        String msg_return = "Retornando ao menu principal";
        
        boolean execute = true;        
        //Laço de execução do MyTwitter
        while(execute){
            
            //String para apresentar o menu
            String menu = "";
            menu += "\n [Bem vindo ao MyTWITTER]";
            menu += "\n [MENU PRINCIPAL] ";
            menu += "\n NAVEGUE PELO MyTWITTER";
            menu += "\n Utilizando os comandos numericos";
            menu += "\n ====================================";
            menu += "\n 1 - CADASTRAR USUARIO";
            menu += "\n 2 - CANCELAR CONTA";
            menu += "\n 3 - TWEETAR";
            menu += "\n 4 - VISUALIZAR TIMELINE";
            menu += "\n 5 - VISUALIZAR TWEETS";
            menu += "\n 6 - SEGUIR ALGUÉM";
            menu += "\n 7 - VISUALIZAR NUMERO DE SEGUIDORES";
            menu += "\n 8 - VISUALIZAR SEGUIDORES";
            menu += "\n 9 - VISUALIZAR DADOS DE ALGUÉM";
            menu += "\n 0 - ENCERRAR NAVEGAÇÃO [X]";
            menu += "\n====================================";
            
            String op = JOptionPane.showInputDialog(null, menu);
            
            if(op == null) {
                System.exit(0);
            }
            
            switch(op){
	            case "0":
	                System.exit(0);
                case "1": 
                    
                    //String para o JOptionPane do cadastro de PessoaFisica
                    String texto_cpf = "[BEM VINDO A TELA DE CADASTRO]\n";
                    texto_cpf += "O USUARIO A SER CADASTRADO POSSUI: \n";
                    texto_cpf += "=================================\n";
                    texto_cpf += "1 - CPF \n";
                    texto_cpf += "2 - CNPJ \n";
                    texto_cpf += "OUTRA OPÇÃO - RETORNAR AO MENU: \n";
                    texto_cpf += "================================= \n";
                    
                    String op1 = JOptionPane.showInputDialog(null, texto_cpf);
                    
                    if(op1.equals("1")){
                        
                        String nome = JOptionPane.showInputDialog(null, "POR FAVOR DIGITE UM NOME PARA O PERFIL");
                        long cpf = Long.parseLong(JOptionPane.showInputDialog(null, "POR FAVOR DIGITE O CPF DE: " 
                                                                                    + nome.toUpperCase()));
                            
                        PessoaFisica p = new PessoaFisica(nome, cpf);
                        
                        String mensagem_cpf = "=================== \n";
                        mensagem_cpf += "PERFIL: \n" + "NOME: " + p.getUsuario() + "\nCPF: " + p.getCpf();
                        mensagem_cpf += "\n ===================";
                        mensagem_cpf += "\nOs dados estão corretos?";
                        
                        int a = JOptionPane.showConfirmDialog(null, mensagem_cpf, "Perfil", 0, 1);
                        if(a == 0){
                                try{
                                    novo_twitter.criarPerfil(p);
                                }catch(PEException e){
                                    JOptionPane.showMessageDialog(null,e.getMessage());
                                    break;
                                }
                                JOptionPane.showMessageDialog(null, "Perfil criado");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Opção inválida\n" + msg_return);
                        }
                    }
                    else if(op1.equals("2")){    
                            String nome = JOptionPane.showInputDialog(null, "POR FAVOR DIGITE UM NOME PARA O PERFIL");
                            long cnpj = Long.parseLong(JOptionPane.showInputDialog(null, "POR FAVOR DIGITE O CNPJ DE: " 
                                                                                    + nome.toUpperCase()));
                            PessoaJuridica p = new PessoaJuridica(nome, cnpj);
                            
                            String mensagem_cnpj = "=================== \n";
                            mensagem_cnpj += "PERFIL: \n" + "NOME: " + p.getUsuario() + "\nCNPJ: " + p.getCnpj();
                            mensagem_cnpj += "\n ===================";
                            mensagem_cnpj += "\nOs dados estão corretos?";
                            
                            int a = JOptionPane.showConfirmDialog(null, mensagem_cnpj, "Perfil", 0, 1);
                            if(a == 0){
                                    try{
                                        novo_twitter.criarPerfil(p);
                                    }catch(PEException e){
                                        JOptionPane.showMessageDialog(null,e.getMessage());
                                        break;
                                    }
                                    
                                    JOptionPane.showMessageDialog(null, "Perfil criado");
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Opção inválida\n" + msg_return);
                            }
                        break;
                    }    
                    else{
                       JOptionPane.showMessageDialog(null, msg_return);
                    }    
                    break;
                case "2":
                    String msg_cancel = "";
                    msg_cancel += "[BEM VINDO A TELA DE CADASTRO]\n";
                    msg_cancel += "Digite o nome do usuario para cancelar o perfil: \n";
                    String nome_cancel = JOptionPane.showInputDialog(null, msg_cancel);
                    
                    try{
                        novo_twitter.cancelarPerfil(nome_cancel);
                    }catch(PIException | PDException e){
                        JOptionPane.showMessageDialog(null,e.getMessage() + "\n" + msg_return);
                        break;
                    }
                    
                    JOptionPane.showMessageDialog(null, "Perfil Cancelado");
                    break;
                case "3":
                    
                    String msg_tweetar_nome = "";
                    msg_tweetar_nome += "[BEM VINDO A TELA DE TWEETAR]\n";
                    msg_tweetar_nome += "Digite o nome do usuario que deseja Tweetar a mensagem:";
                    
                    String nome_usu = JOptionPane.showInputDialog(null, msg_tweetar_nome);
                    
                    String msg_tweetar = "";
                    msg_tweetar += "[BEM VINDO A TELA DE TWEETAR]\n";
                    msg_tweetar += "Digite a mensagem:";

                    String msg_usu = JOptionPane.showInputDialog(null, msg_tweetar);

                    try{
                        novo_twitter.tweetar(nome_usu, msg_usu);
                    }catch(PIException | MFPException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

                    break;
                case "4":
                    String msg_timeline = "";
                    msg_timeline += "[BEM VINDO A TELA DA TIMELINE]\n";
                    msg_timeline += "Digite o nome do usuario: ";
                    
                    String nome_time = JOptionPane.showInputDialog(null, msg_timeline);
                    
                    Vector<Tweet> tweets_time = new Vector<Tweet>();
                    
                    String all_tweets = "Os tweets de sua timeline são: \n";
                    
                    try{
                        tweets_time = novo_twitter.timeline(nome_time);
                        for (Tweet tweet : tweets_time) {
                            all_tweets += "[" + tweet.getMensagem() + "]" + "\n";
                        }
                       JOptionPane.showMessageDialog(null, all_tweets);
                    }catch(PIException | PDException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case "5":
                    String msg_vis_tweet = "";
                    msg_vis_tweet += "[BEM VINDO A TELA DE TWEETS]\n";
                    msg_vis_tweet += "Digite o nome do usuario: ";
                    
                    String nome_vis_tweet = JOptionPane.showInputDialog(null, msg_vis_tweet);
                    
                    Vector<Tweet> your_tweets = new Vector<Tweet>();
                    
                    String msg_tweets = "Os seus tweets são: \n";
                    
                    try{
                        your_tweets = novo_twitter.tweets(nome_vis_tweet);
                        for (Tweet tweet : your_tweets) {
                            msg_tweets += "[" + tweet.getMensagem() + "]" + "\n";
                        }
                        JOptionPane.showMessageDialog(null, msg_tweets);
                    }catch(PIException | PDException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    
                    break;
                case "6":
                    String msg_fllw = "";
                    msg_fllw += "[BEM VINDO A TELA DE FOLLOWERS]\n";
                    msg_fllw += "Digite o nome do usuario seguidor:";
                    
                    String nome_seguidor = JOptionPane.showInputDialog(null, msg_fllw);
                    
                    String msg_fllw2 = "";
                    msg_fllw2 += "[BEM VINDO A TELA DE FOLLOWERS]\n";
                    msg_fllw2 += "Digite o nome do usuario seguido:";
                    
                    String nome_seguido = JOptionPane.showInputDialog(null, msg_fllw2);
                    
                    try {
                        novo_twitter.seguir(nome_seguidor, nome_seguido);
                        JOptionPane.showMessageDialog(null, "Operação bem sucessida");
                    } catch (PIException | PDException | SIException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    
                    break;
                case "7":
                    String msg_n_seg = "";
                    msg_n_seg += "[BEM VINDO A TELA DE NUMERO DE SEGUIDORES]\n";
                    msg_n_seg += "Digite o nome do usuario:";
                    
                    String nome_n_seg = JOptionPane.showInputDialog(null, msg_n_seg);
                    
                    try {
                        int n = novo_twitter.numeroSeguidores(nome_n_seg);
                        JOptionPane.showMessageDialog(null, "Numero de seguidores: " + n);
                    } catch (PIException | PDException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    
                    break;
                case "8":
                    String msg_nome_seg = "";
                    msg_nome_seg += "[BEM VINDO A TELA DE SEGUIDORES]\n";
                    msg_nome_seg += "Digite o nome do usuario:";
                    
                    String nome_seg = JOptionPane.showInputDialog(null, msg_nome_seg);
                    
                    try {
                        Vector<Perfil> v_seg = new Vector<>();
                        v_seg = novo_twitter.seguidores(nome_seg);
                        String txt_nomes = "";
                        for (Perfil perfil : v_seg) {
                            txt_nomes +="- " + perfil.getUsuario() + " -\n";
                        }
                        JOptionPane.showMessageDialog(null, txt_nomes);
                    } catch (PIException | PDException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    
                    break;
                case "9":
                    String msg_src = "";
                    msg_src += "[BEM VINDO A TELA DE BUSCA]\n";
                    msg_src += "Digite o nome do usuario para buscar seus dados:";
                    
                    
                    String nome_src = JOptionPane.showInputDialog(null, msg_src);
                    
                    if(nome_src != "" && nome_src != null){ 
                        JOptionPane.showMessageDialog(null, novo_twitter.repositorio.buscar(nome_src).toString());
                    }else{
                        JOptionPane.showMessageDialog(null, "Nome inválido");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Tente novamente");
            }
        }
        
    }
    
    public MyTwitter(IRepositorioUsuario repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public void criarPerfil(Perfil usuario) {
         if(repositorio.buscar(usuario.getUsuario())!= null){
            throw new PEException();
        }
        try{
            repositorio.cadastrar(usuario);
        }catch(UJCException e){
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void cancelarPerfil(String usuario) {
        if(repositorio.buscar(usuario) == null){
            throw new PIException();
        }else if(!(repositorio.buscar(usuario).isAtivo())){
            throw new PDException();
        }else{
           repositorio.buscar(usuario).setAtivo(false);
        }
        
    }

    @Override
    public void tweetar(String usuario, String mensagem) {
        if(repositorio.buscar(usuario) == null){
            throw new PIException();
        }
        if(mensagem.length()<1 || mensagem.length()>140){
            throw new MFPException();
        }
        Tweet novo_tweet = new Tweet();
        novo_tweet.setUsuario(usuario);
        novo_tweet.setMensagem(mensagem);
        Perfil aux_usuario = repositorio.buscar(usuario);
        aux_usuario.addTweet(novo_tweet);
        Vector<String> seguidores = repositorio.buscar(usuario).getSeguidores();
        if(seguidores != null){
            for(String seguidor : seguidores){
                if(repositorio.buscar(seguidor) != null && repositorio.buscar(seguidor).isAtivo()){
                    (repositorio.buscar(seguidor).getTimeline()).add(novo_tweet);
                }
            }
        }
    }

    @Override
    public Vector<Tweet> timeline(String usuario) {
        if(repositorio.buscar(usuario) == null){
            throw new PIException();
        }else if(!(repositorio.buscar(usuario).isAtivo())){
            throw new PDException();
        }else{
            return repositorio.buscar(usuario).getTimeline();
        }
    }

    @Override
    public Vector<Tweet> tweets(String usuario) {
        if(repositorio.buscar(usuario) == null){
            throw new PIException();
        }else if(!(repositorio.buscar(usuario).isAtivo())){
            throw new PDException();
        }
        if((repositorio.buscar(usuario).getTimeline()) != null){
            Vector<Tweet> vetor_tweets_usuario = new Vector<Tweet>();
            for (Tweet tweets_usuario : repositorio.buscar(usuario).getTimeline()){
                if(tweets_usuario != null && (tweets_usuario.getUsuario().equals(usuario))){
                    vetor_tweets_usuario.add(tweets_usuario);
                }
            }
            return vetor_tweets_usuario;
        }
        return null;
    }

    @Override
    public void seguir(String seguidor, String seguido) {
        if(repositorio.buscar(seguidor) == null || repositorio.buscar(seguido) == null){
            throw new PIException();
        }else if(!(repositorio.buscar(seguidor).isAtivo()) || !(repositorio.buscar(seguido).isAtivo()) ){
            throw new PDException();
        }
        if(repositorio.buscar(seguidor).getUsuario().equals(repositorio.buscar(seguido).getUsuario())){
            throw new SIException();
        }
        (repositorio.buscar(seguido).getSeguidores()).add(seguidor);
        
        Vector<Tweet> t = new Vector<>();
        
        t = repositorio.buscar(seguido).getTimeline();
        
        int i = 0;
        for (Tweet tweet : t) {
            repositorio.buscar(seguidor).addTweet(t.get(i));
            i++;
        }
    }


    @Override
    public int numeroSeguidores(String usuario) {
        if(repositorio.buscar(usuario) == null){
            throw new PIException();
        }else if(!(repositorio.buscar(usuario).isAtivo())){
            throw new PDException();
        }
        Vector<String> numero_seguidores = new Vector<String>();
        Vector<String> seguidores_aux = repositorio.buscar(usuario).getSeguidores();
        for (String seguidor : seguidores_aux){
            if(repositorio.buscar(seguidor)!= null && repositorio.buscar(seguidor).isAtivo()){
                numero_seguidores.add(seguidor);
            }
        }
        return numero_seguidores.size();
    }

    @Override
    public Vector<Perfil> seguidores(String usuario) {
        if(repositorio.buscar(usuario) == null){
            throw new PIException();
        }else if(!(repositorio.buscar(usuario).isAtivo())){
            throw new PDException();
        }
        Vector<Perfil> seguidores_perfil = new Vector<Perfil>();
        Vector<String> seguidores_aux = repositorio.buscar(usuario).getSeguidores();
        for (String seguidor : seguidores_aux){
            if(repositorio.buscar(seguidor)!= null && repositorio.buscar(seguidor).isAtivo()){
                seguidores_perfil.add(repositorio.buscar(seguidor));
            }
        }
        return seguidores_perfil;
    }
    
}
