package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation
{
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    //"Static" para que não seja instanciado um novo "SimpleDateFormat" para cada objeto "Reservation" que a aplicação tiver, precisaremos de apenas um
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //Construtor padrão
    public Reservation(){}

    //Construtor personalizado (Com argumentos)
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut)
    {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    //Setters e Getters
    public Integer getRoomNumber()
    {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn()
    {
        return checkIn;
    }

    public Date getCheckOut()
    {
        return checkOut;
    }

    /*
        Métodos
     */
    public long duration()
    {
        //Implementar diferença entre duas datas

        //Começar calculando a diferença em milissegundos
        long diff = checkOut.getTime() - checkIn.getTime();

        //Converter milissegundos em dias
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut)
    {
        /*
            Aqui nós delegamos a lógica de erro para essa classe
            "Reservation", tirando do programa principal
         */
        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now))
        {
            return "Reservation dates for update must be future dates";
        }
        if (!checkOut.after(checkIn))
        {
            return "Check-out date must be after check-in date";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;

        //Se retorna nulo é porque não deu nenhum erro
        return null;
    }

    @Override
    public String toString()
    {
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
}