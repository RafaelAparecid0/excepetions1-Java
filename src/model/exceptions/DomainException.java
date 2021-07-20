package model.exceptions;

public class DomainException extends Exception
{
    /*
        Declarando a versão da classe
     */
    private static final long serialVersionUID = 1L;

    //Criando um construtor que recebe uma String
    public DomainException(String msg)
    {
        /*
            Permitir a instância da exceção personalizada
            passando uma mensagem para ela.
         */
        super(msg);
    }

}
