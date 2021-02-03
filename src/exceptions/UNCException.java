
package exceptions;

public class UNCException extends RuntimeException {
    public UNCException(){
        super("Usuário não cadastrado!");
    }
}
