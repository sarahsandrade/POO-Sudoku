package sudokivis;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
   private static final long serialVersionUID = 1L;  // to prevent serial warning
   private JFrame frame;
   // private variables
   GameBoardPanel board = new GameBoardPanel();
   JButton btnNewGame = new JButton("New Game");

   // Constructor
   public SudokuMain() {
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());

      cp.add(board, BorderLayout.NORTH);
      
      final JRadioButton easy = new JRadioButton("Easy",true);
      final JRadioButton medium = new JRadioButton("Medium");
      final JRadioButton hard = new JRadioButton("Hard");
      ButtonGroup buttonGroup = new ButtonGroup();
      buttonGroup.add(easy);
      buttonGroup.add(medium);
      buttonGroup.add(hard);
      // Add a button to the south to re-start the game via board.newGame()
      // ......
      JButton btnNewButton_1 = new JButton("New Game");
      btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(easy.isSelected()) {
					board.newGame(1);
				}
				if(medium.isSelected()) {
					board.newGame(2);
				}
				if(hard.isSelected()) {
					board.newGame(3);
				}
			}
		});
      JButton btnNewButton = new JButton("Restart Game");
      btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.restart();
			}
		});
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel.setPreferredSize(new Dimension(540, 50));
      panel.add(btnNewButton_1);
      panel.add(btnNewButton);
      panel.add(easy);
      panel.add(medium);
      panel.add(hard);
      JMenuBar menivis = new JMenuBar();
      
      menivis.add(panel);
      cp.add(menivis, BorderLayout.SOUTH);
      
      
		
      //JButton btnNewButton = new JButton("Restart Game");
      //cp.add(btnNewButton);
      // Initialize the game board to start the game
      
      board.newGame(1);

      pack();     // Pack the UI components, instead of using setSize()
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
      setTitle("Sudoku");
      setVisible(true);
   }

   /** The entry main() entry method */
   public static void main(String[] args) {
      // [TODO 1] Check "Swing program template" on how to run
      //  the constructor of "SudokuMain"
      // .........
	   EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuMain window = new SudokuMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
   }
}