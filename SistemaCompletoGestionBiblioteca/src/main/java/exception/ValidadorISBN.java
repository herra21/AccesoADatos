package exception;

import dao.LibroDAOIMP;

public class ValidadorISBN {
    LibroDAOIMP libroDAOIMP = new LibroDAOIMP();
    public void validarISBN(String ISBN) throws ISBNIcorrectoException{
        if (ISBN == null || ISBN.length() != 17){
            throw new ISBNIcorrectoException("El ISBN debe de tener una longitud de 17 caracteres.");
        }
        if (libroDAOIMP.existeISBN(ISBN)){
            throw new ISBNIcorrectoException("El ISBN ya existe en la Base de Datos.");
        }
    }
}
