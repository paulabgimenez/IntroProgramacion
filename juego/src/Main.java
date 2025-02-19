import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        boolean jugarOtra = true;

        do {

            String inicio = "¡Vamos a jugar al Ahorcado!";
            JOptionPane.showMessageDialog(null, inicio, "Incio", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/imagenes/inicio.jpg")));
            JOptionPane.showMessageDialog(null, "Podés elegir la palabra a adivinar (por si jugás con alguien más) o jugar con una palabra guardada");
            JOptionPane.showMessageDialog(null, "¿Querés jugar con una palabra guardada?");
            String eleccion = JOptionPane.showInputDialog("Ingrese 'si' o 'no'");

            String palabra = "";

            switch (eleccion) {
                case "si":
                    JOptionPane.showMessageDialog(null, "Ok, usaremos una palabra guardada");
                    break;

                case "no":
                    JOptionPane.showMessageDialog(null, "Ok, ingresá la palabra a adivinar");
                    palabra = JOptionPane.showInputDialog("Palabra:");

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Entendemos, no querés jugar :(");
                    return;
            }


            String[] palabraGuardada = {"variable", "clase", "ciclo", "operador"};

            Random random = new Random();
            int aleatorio = random.nextInt(palabraGuardada.length);

            String palabraAleatoria = palabraGuardada[aleatorio];


            if (eleccion.equals("si")) {
                JOptionPane.showMessageDialog(null, "¡Empecemos! La palabra tiene " + palabraAleatoria.length() + " letras");
            } else {
                JOptionPane.showMessageDialog(null, "¡Excelente elección!");
                JOptionPane.showMessageDialog(null, "¡Empecemos! La palabra tiene " + palabra.length() + " letras");
            }

            String palabraElegida = "";

            if (palabra.isEmpty()) {
                palabraElegida = palabraAleatoria;
            } else {
                palabraElegida = palabra;
            }


            int intentos = 5;

            boolean correcto = false;
            boolean adivinada = false;

            String letra = "";


            char[] elegida = new char[palabraElegida.length()];

            for (int i = 0; i < elegida.length; i++) {
                elegida[i] = '_';
            }


            while (intentos > 0 && !adivinada) {
                letra = JOptionPane.showInputDialog(null, "Ingrese una letra: " + String.valueOf(elegida));
                char letraIngresada = letra.charAt(0);
                correcto = false;

                for (int i = 0; i < palabraElegida.length(); i++) {
                    if (palabraElegida.charAt(i) == letraIngresada) {

                        elegida[i] = letraIngresada;
                        correcto = true;

                        JOptionPane.showMessageDialog(null, "¡Perfecto! '" + letra + "' se encuentra en la palabra");
                    }

                }

                if (!correcto) {
                    intentos--;

                    JOptionPane.showMessageDialog(null, "Esta letra no se encuentra en la palabra. Te quedan " + intentos + " intentos");
                }

                adivinada = true;
                for (int i = 0; i < elegida.length; i++) {
                    if (elegida[i] != palabraElegida.charAt(i)) {
                        adivinada = false;
                        break;

                    }
                }
            }

            if (intentos == 0) {
                JOptionPane.showMessageDialog(null, "¡Estás ahorcado! La palabra era '" + palabraElegida + "'");
            } else {
                JOptionPane.showMessageDialog(null, "¡Adivinaste! La palabra era '" + palabraElegida + "'");
            }

            JOptionPane.showMessageDialog(null,"¡Eso fue rápido! ¿Querés volver a jugar?");
            String otra = JOptionPane.showInputDialog(null,"Ingresá 'si' para volver a jugar:");
            jugarOtra = (otra.equals("si"));

        }

        while (jugarOtra);

        String ultimo = "¡Adiós!";

        JOptionPane.showMessageDialog(null, ultimo, "Fin del juego", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/imagenes/final.jpg")));

        }
}






