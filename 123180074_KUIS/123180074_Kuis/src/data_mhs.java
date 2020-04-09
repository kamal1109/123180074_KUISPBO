import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.sql.SQLException;
import java.sql.Statement;

public class data_mhs extends JFrame 
{
    JLabel nim,nama,mata_kuliah1,mata_kuliah2,nilai1,nilai2; 
    JTextField isinama,isinim,isimata_kuliah1,isimata_kuliah2,isinilai1,isinilai2; 
    JButton ya; 
    Statement statement; 
    
    public void data_mhs()
    {
        setTitle("Hitung Nilai"); 
        nim = new JLabel("NIM");
        nama = new JLabel("Nama");
        mata_kuliah1 = new JLabel("Mata Kuliah 1");
        nilai1 = new JLabel("Nilai 1");
        mata_kuliah2 = new JLabel("Mata Kuliah 2");
        nilai2 = new JLabel("Nilai 2");
        ya = new JButton("Convert");
        isinim = new JTextField();
        isinama = new JTextField();
        isimata_kuliah1 = new JTextField();
        isinilai1 = new JTextField();
        isimata_kuliah2 = new JTextField();
        isinilai2 = new JTextField();
        
        
        setLayout(null); 
        add(nim);
        nim.setBounds(30,40,100,20);
        add(isinim);
        isinim.setBounds(140,40,200,20);
        add(nama);
        nama.setBounds(30,80,100,20);
        add(isinama);
        isinama.setBounds(140,80,200,20); 
        add(mata_kuliah1);
        mata_kuliah1.setBounds(30,120,200,20);
        add(isimata_kuliah1);
        isimata_kuliah1.setBounds(140,120,200,20);
        add(nilai1);
        nilai1.setBounds(30,160,200,20);
        add(isinilai1);
        isinilai1.setBounds(140,160,200,20);
        add(mata_kuliah2);
        mata_kuliah2.setBounds(30,200,200,20);
        add(isimata_kuliah2);
        isimata_kuliah2.setBounds(140,200,200,20);
        add(nilai2);
        nilai2.setBounds(30,240,100,20);
        add(isinilai2);
        isinilai2.setBounds(140,240,200,20);
        add(ya);
        ya.setBounds(150,280,90,20);
        setSize(400,400); 
        setVisible(true); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ya.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try
                {
                    int nim =  Integer.parseInt(isinim.getText());
                    String nama = isinama.getText();
                    String matkul = isimata_kuliah1.getText();
                    int nilai = Integer.parseInt(isinilai1.getText());
                    String mata_kuliah2 = isimata_kuliah2.getText();
                    int nilai2 = Integer.parseInt(isinilai2.getText());
                    
                    koneksiDB koneksi = new koneksiDB();
                    
                    try
                    {
                        statement = koneksi.getKoneksi().createStatement();
                        String sql = "INSERT INTO data_mahasiswa VALUES ('"+ nim + "','" + nama + "','" 
                                     + matkul + "','" + nilai + "','" + mata_kuliah2 + "','" + nilai2 + "')";
                        
                        statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(rootPane, "Data Tersimpan");
                    } catch (ClassNotFoundException ex) 
                    {
                        Logger.getLogger(data_mhs.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) 
                    {
                        Logger.getLogger(data_mhs.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    int total = 0; 
                    nilaiRata rata = new nilaiRata(); 
                    total = nilai+nilai2; 
                    System.out.println("NIM           : "+nim);
                    System.out.println("Nama          : "+nama);
                    System.out.println("Mata Kuliah 1 : "+matkul);
                    System.out.println("Mata Kuliah 2 : "+mata_kuliah2);
                    System.out.println("Rata - Rata   : "+rata.rata(total)); 
                    System.out.println("Nilai Huruf   : "+rata.nilaiHuruf(total)); 
                    
                } catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(rootPane,"TIPE DATA SALAH");
                    
                } catch (Error ext)
                {
                    JOptionPane.showMessageDialog(rootPane,"SALAH");
                    
                }
            }
  
        });
    }
}