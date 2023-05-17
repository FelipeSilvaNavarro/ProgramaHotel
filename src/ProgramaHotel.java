import modelo.entidades.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProgramaHotel {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto: ");
        int numeroQuarto = scanner.nextInt();
        System.out.print("Data de Check-In (DD/MM/YYYY): ");
        Date dataCheckIn = sdf.parse(scanner.next());
        System.out.print("Data de Check-Out (DD/MM/YYYY): ");
        Date dataCheckOut = sdf.parse(scanner.next());

        /* TODO
         *  Resolução de inserção de caracteres invalidos (Datas tbm)
         */

        /* TODO
        * Contador de dias pra quanto tempo falta para o checkin
         */
        if (!dataCheckOut.after(dataCheckIn)) {
            System.out.print("Erro na reserva: a data de check-out tem que ser depois da data de check-in");
        } else {
            Reserva reserva = new Reserva(numeroQuarto, dataCheckIn, dataCheckOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Insira as datas para atualizar a reserva: ");
            System.out.print("Data de Check-In (DD/MM/YYYY): ");
            dataCheckIn = sdf.parse(scanner.next());
            System.out.print("Data de Check-Out (DD/MM/YYYY): ");
            dataCheckOut = sdf.parse(scanner.next());

            Date now = new Date();
            if (dataCheckIn.before(now) || dataCheckOut.before(now)) {
                System.out.println("Erro na reserva: reservas devem ser feitas com datas futuras");
            } else if (!dataCheckOut.after(dataCheckIn)){
                System.out.print("Erro na reserva: a data de check-out tem que ser depois da data de check-in");
            } else {
                reserva.attDatas(dataCheckIn, dataCheckOut);
                System.out.println("Reserva: " + reserva);
            }

        }


        scanner.close();

    }
}