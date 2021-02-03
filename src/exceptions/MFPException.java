
package exceptions;

public class MFPException extends RuntimeException {
    public MFPException(){
        super("Mensagem fora do padrão");
    }
}
