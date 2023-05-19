import modelo.entidades.Reserva;
import modelo.excecoes.ExcecaoDominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProgramaHotel {
    public static void main(String[] args) {

        /* TODO
         *  - Correção do erro da estrutura Do/While
         */
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int erro = 1;

        do {
            try {
                System.out.print("Numero do quarto (Somente numeros): ");
                int numeroQuarto = scanner.nextInt();
                System.out.print("Data de Check-In (DD/MM/YYYY): ");
                Date dataCheckIn = sdf.parse(scanner.next());
                System.out.print("Data de Check-Out (DD/MM/YYYY): ");
                Date dataCheckOut = sdf.parse(scanner.next());

                Reserva reserva = new Reserva(numeroQuarto, dataCheckIn, dataCheckOut);
                System.out.println("Reserva: " + reserva);

                System.out.println();
                System.out.println("Insira as datas para atualizar a reserva: ");
                System.out.print("Data de Check-In (DD/MM/YYYY): ");
                dataCheckIn = sdf.parse(scanner.next());
                System.out.print("Data de Check-Out (DD/MM/YYYY): ");
                dataCheckOut = sdf.parse(scanner.next());

                reserva.attDatas(dataCheckIn, dataCheckOut);
                System.out.println("Reserva: " + reserva);
            } catch (ParseException parseException) {
                System.out.println("Formato de data invalida");
                erro += 1;
            } catch (ExcecaoDominio excecaoDominio) {
                System.out.println("Erro na reserva: " + excecaoDominio.getMessage());
                erro += 1;
            } catch (RuntimeException inputMismatchException) {
                System.out.println("Formato de caracteres inválido");
                erro += 1;
            }
        } while (erro != 1);



        scanner.close();

    }
}
