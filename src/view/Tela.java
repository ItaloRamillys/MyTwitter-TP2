package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Italo
 */
public class Tela extends JFrame{
    
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    
    private static final long serialVersionUID = 1L;
    
    public Tela(){
        criarForm();
    }
    
    private void criarForm(){
        
        FecharAction fecharAction = new FecharAction();
        LoginAction loginAction = new LoginAction();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("LOGIN");
        setSize(400, 300);
        
        JPanel panelTit = new JPanel();
        panelTit.setLayout(new FlowLayout());
        
        JLabel lblTitulo = new JLabel("LOGIN");
        panelTit.add(lblTitulo);
        
        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(new FlowLayout());
        
        JLabel lblLogin = new JLabel("LOGIN");
        panelLogin.add(lblLogin);
        txtLogin = new JTextField(30);
        panelLogin.add(txtLogin);
        
        JLabel lblSenha = new JLabel("SENHA");
        panelLogin.add(lblSenha);
        txtSenha = new JPasswordField(30);
        panelLogin.add(txtSenha);
        
        JPanel panelBtn = new JPanel();
        panelBtn.setLayout(new FlowLayout());
        
        JButton btnLogar = new JButton("Logar");
        panelBtn.add(btnLogar);
        
        JButton btnCancelar = new JButton("Cancelar");
        panelBtn.add(btnCancelar);
        
        add(panelTit, BorderLayout.NORTH);
        add(panelLogin, BorderLayout.CENTER);
        add(panelBtn, BorderLayout.SOUTH);
        
        btnLogar.addActionListener(loginAction);
        btnCancelar.addActionListener(fecharAction);
    }
    
    public static void main(String[] args) {
        Tela tela = new Tela();
        tela.setVisible(true);
    }
    
    
    
    private class LoginAction implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(txtLogin.getText().equals("Admin") && txtSenha.getText().equals("1234")){
                JOptionPane.showMessageDialog(null, "Logado");
            }else{
                JOptionPane.showMessageDialog(null, "Login inválido");
            }
        }
        
    }
    private class FecharAction implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }
}
