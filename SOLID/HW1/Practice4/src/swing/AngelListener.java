package swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Observer1
public class AngelListener implements ActionListener {

    // Concrete Observer
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("아끼자!");
    }
    
}
