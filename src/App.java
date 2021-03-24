import view.Mainframe;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                try {
                    startGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void startGUI() throws Exception {
        new Mainframe();
    }
}
