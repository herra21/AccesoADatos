package exception;

public class ValidadorNumPags {
    public void validarNumPags(int numPags) throws NumPagsIncorrectoException {
        int minNumPags = 10;
        int maxNumPags = 2400;
        if (numPags < minNumPags || numPags > maxNumPags) {
            throw new NumPagsIncorrectoException(String.format("El libro no puede tener menos de %d y más de %d páginas",minNumPags, maxNumPags));
        }
    }
}
