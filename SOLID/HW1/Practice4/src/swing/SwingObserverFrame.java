package swing;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingObserverFrame extends JFrame{
    public SwingObserverFrame() {
        JButton button = new JButton("정말 해?");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("그안돼 분명 나중에 후회할거야");
            }
        }); // Observer1 등록 (익명 클래스) 
        button.addActionListener(new DevilListener()); // Observer2 등록
        button.addActionListener(k -> System.out.println("살지 말지 고민!")); // Observer3 등록 (lambda)

		this.getContentPane().add(BorderLayout.CENTER, button);
        this.setSize(200, 200);
        this.setVisible(true);
    }
}
