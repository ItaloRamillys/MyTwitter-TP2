
package exceptions;

public class PEException extends RuntimeException {
    public PEException(){
        super("Perfil já existente!");
    }
}
