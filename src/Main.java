import entities.AudioRec;
import entities.Img;
import entities.MediaObject;
import entities.Video;
import interfaces.Playable;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static void main(String[] args) {
        MediaObject[] array = new MediaObject[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("\n" + "Inserisci il titolo del prossimo file: " + (i + 1) + "/5");
            String title = scanner.nextLine();
            while (array[i] == null) {
                System.out.println("\n" + "Inserisci il tipo del prossimo file multimediale (video, image o audio).");
                String type = scanner.nextLine().toUpperCase();
                array[i] = switch (type) {
                    case "VIDEO" -> new Video(title);
                    case "IMAGE" -> new Img(title);
                    case "AUDIO" -> new AudioRec(title);
                    default -> {
                        System.out.println("Tipo file non supportato");
                        yield null;
                        // Qui avrei messo un return, ma Java mi ha corretto con questo yield,
                        // che mi pare di capire sia una specie di return apposta per gli switch.
                    }
                };
            }
            ;
            if (array[i] instanceof Playable) {
                int duration = -1;
                do {
                    try {
                        System.out.println("\n" + "Inserisci durata (0-10):");
                        duration = Integer.parseInt(scanner.nextLine());
                        ((Playable) array[i]).setDuration(duration);
                    } catch (NumberFormatException e) {
/*                        Non sapendo tipizzare un errore/parametro di catch, ho cercato e
                          a quanto pare questo tipo di errore è il più indicato perché descrive proprio un
                           errore generato in seguito a un valore che doveva essere un numero, ma non lo è.
                           (che è proprio ciò che voglio evitare dato che mi faceva crashare il programma)*/
                        System.out.println("Formato durata non valido.");
                        continue;
                    }

                    if (duration < 0 || duration > 10) {
                        System.out.println("Valore non valido");
                    }

                } while (duration < 0 || duration > 10);

            }
        }

        while (true) {
            System.out.println("\n" + Arrays.toString(array));
            System.out.println("\n" + "Inserisci il numero del file da riprodurre o 0 per uscire:");
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= array.length) {
                if (index == -1) {
                    System.out.println("Uscita.");
                    break;
                }
                System.out.println("\n" + "Inserisci un numero compreso tra 1 e 5 o 0 per uscire:");
                continue;
            }
            if (array[index] != null) {
                array[index].execute();
            } else {
                System.out.println("File corrotto. Impossibile riprodurre.");
            }
        }
    }
}
