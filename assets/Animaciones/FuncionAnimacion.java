import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.util.Scanner;

public class FuncionAnimacion{
    public static void main(String[] args) throws Exception{
    	Scanner sc = new Scanner(System.in);
        int sgif;
        System.out.print("Introduce el gif que quieres mostrar\n> ");
        sgif = sc.nextInt();
        gif();
    }
    /**
     * 
     * @return
     */
    public static int gif() {

    	
    	String Mensaje, Titulo;
    	int Time;
    	final ImageIcon icon;
    	
    	Titulo = "Titulo";
    	Mensaje = "Mensaje";
    	Time = 5000;
    	String RutaIcon = "assets/Gifs/WizardIlde.gif";
    	TimepoSprites(RutaIcon, Titulo, Mensaje, Time);

    	return 0;
    }
    /**
     * 
     * @param RutaIcon
     * @param titulo
     * @param mensaje
     * @param time
     */
    public static void TimepoSprites(String RutaIcon, String titulo, String mensaje, int time) {
        // Crear el JOptionPane con el mensaje deseado y la imagen
        ImageIcon icon = new ImageIcon(RutaIcon);  // Reemplaza "ruta_de_la_imagen" con la ruta de la imagen deseada
        JLabel label = new JLabel(mensaje, icon, JLabel.CENTER);
        JOptionPane optionPane = new JOptionPane(label, JOptionPane.INFORMATION_MESSAGE);

        // Crear el JDialog asociado al JOptionPane
        final javax.swing.JDialog dialog = optionPane.createDialog("Mensaje");

        // Crear un temporizador para cerrar el JOptionPane después de dos segundos
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();  // Cerrar el JDialog
            }
        });

        // Iniciar el temporizador
        timer.setRepeats(false);  // Hacer que el temporizador solo se ejecute una vez
        timer.start();

        // Mostrar el JDialog
        dialog.setVisible(true);
    }
    
}
