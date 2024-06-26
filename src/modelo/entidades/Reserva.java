package modelo.entidades;

import modelo.excecoes.ExcecaoDominio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static Date date = new Date();

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * @param numeroQuarto
     * @param checkIn
     * @param checkOut     <p>Construtor da classe com as mesmas <b>REGRAS</b> da função "attDatas" </p>
     */
    public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
        if (checkIn.before(date) || checkOut.before(date)) {
            throw new ExcecaoDominio("reservas devem ser feitas com datas futuras");
        }
        if (!checkOut.after(checkIn)) {
            throw new ExcecaoDominio("a data de check-out tem que ser depois da data de check-in");
        }
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Reserva() {
    }

    /**
     * @return um long que tem a duracao entre a <b>data de entrada e saida da reserva em dias</b>
     */
    public long duracao() {
        long diferenca = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    /**
     * @param checkIn
     * @param checkOut <p>atualiza as datas de entrada e saida da reserva</p>
     *                 <b>Regras:</b> <p>- Alteração de reserva só podem ocorrer para datas futuras</p>
     *                 <p>- A data de saída deve ser maior que a data de entrada</p>
     */
    public void attDatas(Date checkIn, Date checkOut) {
        if (checkIn.before(date) || checkOut.before(date)) {
            throw new ExcecaoDominio("reservas devem ser feitas com datas futuras");
        }
        if (!checkOut.after(checkIn)) {
            throw new ExcecaoDominio("a data de check-out tem que ser depois da data de check-in");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quarto: ");
        sb.append(numeroQuarto);
        sb.append(", check-in: ");
        sb.append(sdf.format(checkIn));
        sb.append(", check-out: ");
        sb.append(sdf.format(checkOut));
        sb.append(", ");
        sb.append(duracao());
        sb.append(" noites");

        return sb.toString();
    }
}