package swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Observer2 
public class DevilListener implements ActionListener {
   
    // Concrete Observer
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("안돼! 저질러버려!");
    }

}
