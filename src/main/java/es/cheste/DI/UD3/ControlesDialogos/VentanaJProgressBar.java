package es.cheste.DI.UD3.ControlesDialogos;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VentanaJProgressBar extends JFrame {
    private JProgressBar progressBar;
    private int progress = 0;

    // Constructor de la clase
    public VentanaJProgressBar() {
        // Configuración del marco (JFrame)
        setTitle("Ejemplo de JProgressBar");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear y configurar el JProgressBar
        progressBar = new JProgressBar(0, 100); // Valor mínimo 0, máximo 100
        progressBar.setValue(0);                // Valor inicial
        progressBar.setStringPainted(true);     // Mostrar el porcentaje

        // Añadir el JProgressBar al marco
        add(progressBar);

        // Simular una tarea en segundo plano que actualiza el progreso
        startProgress();
        setVisible(true);
    }

    // Método para simular el progreso
    private void startProgress() {
        // Crear un ExecutorService para manejar tareas en segundo plano
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                // Simulamos una tarea que tarda 100 iteraciones
                while (progress < 100) {
                    Thread.sleep(100);  // Simula trabajo (100ms de pausa)
                    progress += 1;      // Incrementa el progreso

                    // Actualizar el progreso en el hilo de la interfaz
                    SwingUtilities.invokeLater(() -> progressBar.setValue(progress));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                executor.shutdown();  // Termina el ExecutorService
            }
        });
    }
}
