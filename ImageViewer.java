package imageviewer;
import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


/*
 Программа для просмотра изображений...
 */
public class ImageViewer 
{    
    public static void main(String[] args)
    {
        EventQueue.invokeLater (new Runnable()
        {
            public void run() 
            {
                JFrame frame = new ImageViewerFrame();
                frame.setTitle("Image Viewer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }        
        });       
    }    
}
/*
Фрейм текстовой метки
*/
class ImageViewerFrame extends JFrame
{
    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    
    public ImageViewerFrame()
    {
       setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT );
       
       //Использовать метку для вывода изображения на экран
       label = new JLabel();
       add(label);
       
       //Установить селектор файлов
       chooser = new JFileChooser();
       chooser.setCurrentDirectory(new File("."));
       
       //Установить строку меню
       JMenuBar menuBar= new JMenuBar();
       setJMenuBar(menuBar);
       
       JMenu menu = new JMenu("File");
       menuBar.add(menu);
       JMenuItem openItem = new JMenuItem("Open");
       menu.add(openItem);
       openItem.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent event)
           {
               //Отобразить диалоговое окно селектора файлов
               int result = chooser.showOpenDialog(null);
               
               //Есди файл выбран задать его в качестве писктограммы для метки
               if (result==JFileChooser.APPROVE_OPTION)
               {
                   String name=chooser.getSelectedFile().getPath();
                   label.setIcon(new ImageIcon(name));
               }
           }           
       });
       JMenuItem exitItem = new JMenuItem("Exit");
       menu.add(exitItem);
       exitItem.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent event){
               System.exit(0);
           }
       });
    }
}
