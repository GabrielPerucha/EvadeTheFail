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
    	final ImageIcon icon;
    	
    	Titulo = "Titulo";
    	Mensaje = "Datos del personaje";
    	String RutaIcon = "assets/Gifs/WizardIlde.gif";
    	SpritesSinTiempo(RutaIcon, Titulo, Mensaje);

    	return 0;
    }
    /**
     * 
     * @param RutaIcon
     * @param titulo
     * @param mensaje
     * @param time
     */
    public static void SpritesSinTiempo(String RutaIcon, String titulo, String mensaje) {
        // Crear el JOptionPane con el mensaje deseado y la imagen
        ImageIcon icon = new ImageIcon(RutaIcon);  // Reemplaza "ruta_de_la_imagen" con la ruta de la imagen deseada
        JLabel label = new JLabel(mensaje, icon, JLabel.CENTER);
        JOptionPane optionPane = new JOptionPane(label, JOptionPane.INFORMATION_MESSAGE);

        // Crear el JDialog asociado al JOptionPane
        final javax.swing.JDialog dialog = optionPane.createDialog(titulo);


        // Mostrar el JDialog
        dialog.setVisible(true);
    }
    
}
