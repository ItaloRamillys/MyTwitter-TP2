
package exceptions;

public class UJCException extends RuntimeException {
    public UJCException(){
       super("Já existe este nome de usuário!");
    }
}
