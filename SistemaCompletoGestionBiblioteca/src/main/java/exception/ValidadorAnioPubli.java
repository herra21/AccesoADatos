package exception;

public class ValidadorAnioPubli {
    public void validarAnioPubli(int anioPubli) throws AnioPubliIncorrectoException{
        int minAnio = 1586;
        int maxAnio = 2026;
        if (anioPubli < 1586 || anioPubli > 2026) {
            throw new AnioPubliIncorrectoException(String.format("El año de publicación del libro no puede ser menor a %d o mayor a %d",minAnio, maxAnio));
        }
    }
}
