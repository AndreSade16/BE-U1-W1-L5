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
            System.out.println("Inserisci il titolo del prossimo file: " + (i + 1) + "/5");
            String title = scanner.nextLine();
            while (array[i] == null) {
                System.out.println("Inserisci il tipo del prossimo file multimediale (video, image o audio).");
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
                int duration;
                do {
                    System.out.println("Inserisci durata (0-10):");
                    duration = Integer.parseInt(scanner.nextLine());
                    ((Playable) array[i]).setDuration(duration);

                    if (duration < 0 || duration > 10) {
                        System.out.println("Valore non valido");
                    }

                } while (duration < 0 || duration > 10);

            }
        }

        while (true) {
            System.out.println(Arrays.toString(array));
            System.out.println("Inserisci il numero del file da riprodurre o 0 per uscire:");
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= array.length) {
                if (index == -1) {
                    System.out.println("Uscita.");
                    break;
                }
                System.out.println("Inserisci un numero compreso tra 1 e 5 o 0 per uscire:");
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
